package com.remmy.simplepaas.service.impl;

import com.remmy.simplepaas.dto.Image;
import com.remmy.simplepaas.client.registry.RegistryClient;
import com.remmy.simplepaas.service.ImageCacheService;
import com.remmy.simplepaas.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author yejiaxin
 */

@Component
@Slf4j
public class ImageCacheServiceImpl implements ImageCacheService {
    @Value("${redis.key.image}")
    private String REDIS_IMAGE_KEY;
    private final RedisService redisService;
    private final RegistryClient registryClient;

    public ImageCacheServiceImpl(RedisService redisService, RegistryClient registryClient) {
        this.redisService = redisService;
        this.registryClient = registryClient;
    }

    @Override
    public void refreshCache() {
        try {
            redisService.del(REDIS_IMAGE_KEY);
            List<Image> images = registryClient.listImages();
            for (Image image : images) {
                redisService.hSet(REDIS_IMAGE_KEY, hashKey(image), image);
            }
        } catch (Exception e) {
            log.error("list images from registry failed!", e);
        }
    }

    private String hashKey(Image image) {
        return image.getName() +
                "::" +
                image.getVersion();
    }

    @Override
    public List<Image> list() {
        Map<Object, Object> imageCacheList = redisService.hGetAll(REDIS_IMAGE_KEY);
        List<Image> imageList = new ArrayList<>(imageCacheList.size());
        for (Map.Entry<Object, Object> entry : imageCacheList.entrySet()) {
            imageList.add((Image) entry.getValue());
        }
        return imageList;
    }

    @Override
    public Image get(String imageId) {
        return (Image) redisService.hGet(REDIS_IMAGE_KEY, imageId);
    }
}
