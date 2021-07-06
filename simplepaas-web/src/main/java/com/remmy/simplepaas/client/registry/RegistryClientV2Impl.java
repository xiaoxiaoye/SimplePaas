package com.remmy.simplepaas.client.registry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.remmy.simplepaas.dto.Image;
import com.remmy.simplepaas.dto.RepositoryStatus;
import com.remmy.simplepaas.model.Repository;
import com.remmy.simplepaas.service.impl.RepositoryServiceImpl;
import com.remmy.simplepaas.service.impl.SystemParamServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yejiaxin
 */
@Component
public class RegistryClientV2Impl implements RegistryClient {
    private static final Logger logger = LoggerFactory.getLogger(RegistryClientV2Impl.class);

    private RestTemplate rTemplate;
    private final ObjectMapper objectMapper;
    private final RepositoryServiceImpl registryService;
    private final ThreadPoolTaskExecutor executor;
    private final SystemParamServiceImpl systemParamService;

    private static final String URL_CATALOG = "/v2/_catalog";
    private static final String URL_TAG_LIST = "/tags/list";

    public RegistryClientV2Impl(RestTemplate restTemplate,RepositoryServiceImpl registryService,
                                ThreadPoolTaskExecutor executor, SystemParamServiceImpl systemParamService) {
        this.rTemplate = restTemplate;
        this.registryService = registryService;
        this.executor = executor;
        this.systemParamService = systemParamService;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void deleteByTag(String name, String tag) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean health() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public RepositoryStatus getInfo() throws Exception {
        List<Image> imageList = listImages();
        long totalSize = 0;
        for (Image image : imageList) {
            totalSize += image.getSize();
        }

        return RepositoryStatus.builder()
                .count((long)imageList.size())
                .address(systemParamService.getRegistryUrl())
                .diskSize(totalSize)
                .isHealth(true)
                .build();
    }

    @Override
    public List<Image> listImages() throws Exception {
        long time = System.currentTimeMillis();
        String registryAddress = systemParamService.getRegistryUrl();
        if (registryAddress == null) {
            throw new RuntimeException("registry is null");
        }

        List<Image> imageList = new LinkedList<>();
        String url = registryAddress + URL_CATALOG;
        String context = rTemplate.getForObject(url, String.class);
        List<String> imageNameList = parseImageNames(context);

        CountDownLatch countDownLatch = new CountDownLatch(imageNameList.size());
        for (String imageName : imageNameList) {
            executor.execute(() -> {
                try {
                    String tagsUrl = registryAddress + "/v2/" + imageName + URL_TAG_LIST;
                    String jsonTagsString = rTemplate.getForObject(tagsUrl, String.class);
                    List<String> tagList = parseImageTags(jsonTagsString);
                    for (String tag : tagList) {
                        Image image = new Image();
                        image.setName(imageName);
                        image.setVersion(tag);
                        getImageManifest(registryAddress, image);
                        synchronized (imageList) {
                            imageList.add(image);
                        }
                    }
                } catch (Exception e) {
                    logger.error("get image failed!", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        imageList.sort(Comparator.comparing(Image::getName));
        logger.debug("list all images cost: {}ms", System.currentTimeMillis()-time);
        return imageList;
    }

    private void getImageManifest(String registryAddress, Image image) throws Exception {
        String manifestUrl = registryAddress + "/v2/" + image.getName() + "/manifests/" + image.getVersion();
        RequestEntity<?> request = RequestEntity.get(URI.create(manifestUrl))
                .header("Accept", "application/vnd.docker.distribution.manifest.v2+json").build();
        ResponseEntity<String> responseEntity = rTemplate.exchange(request, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String jsonManifestString = responseEntity.getBody();
            ImageManifest manifest = objectMapper.readValue(jsonManifestString, ImageManifest.class);

            String imageId = manifest.getConfig().getDigest().substring(7);
            int imageSize = 0;
            for (Digest digest : manifest.getLayers()) {
                imageSize += digest.getSize();
            }
            image.setId(imageId);
            image.setSize(imageSize);
        }
    }

    private String getRegistryAddressByName(String registryName) throws URISyntaxException {
        List<Repository> repositories = registryService.getRepositoryByName(registryName);
        if (repositories.isEmpty()) {
            return null;
        }
        Repository repository = repositories.get(0);
        return new URI(repository.getProtocol(), null, repository.getHost(), repository.getPort(),null, null, null).toString();
    }

    private List<String> parseImageNames(String context) {
        List<String> imageNameList = new LinkedList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(context);
            jsonNode = jsonNode.get("repositories");
            if (jsonNode instanceof NullNode) {
                return imageNameList;
            }
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            for (JsonNode node : arrayNode) {
                imageNameList.add(node.asText());
            }
            return imageNameList;
        } catch (JsonProcessingException e) {
            return Collections.emptyList();
        }
    }

    private List<String> parseImageTags(String context) {
        try {
            List<String> tagList = new LinkedList<>();
            JsonNode jsonNode = objectMapper.readTree(context);
            jsonNode = jsonNode.get("tags");
            if (jsonNode instanceof NullNode) {
                return tagList;
            }
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            for (JsonNode node : arrayNode) {
                tagList.add(node.asText());
            }
            return tagList;
        } catch (JsonProcessingException e) {
            return Collections.emptyList();
        }
    }

    static class Digest {
        private String mediaType;
        private int size;
        private String digest;

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }
    }

    static class ImageManifest {
        private String schemaVersion;
        private String mediaType;
        private Digest config;
        private List<Digest> layers;

        public String getSchemaVersion() {
            return schemaVersion;
        }

        public void setSchemaVersion(String schemaVersion) {
            this.schemaVersion = schemaVersion;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public Digest getConfig() {
            return config;
        }

        public void setConfig(Digest config) {
            this.config = config;
        }

        public List<Digest> getLayers() {
            return layers;
        }

        public void setLayers(List<Digest> layers) {
            this.layers = layers;
        }
    }
}
