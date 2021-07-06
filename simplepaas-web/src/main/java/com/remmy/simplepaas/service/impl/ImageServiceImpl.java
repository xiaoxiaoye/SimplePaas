package com.remmy.simplepaas.service.impl;

import com.remmy.simplepaas.client.registry.RegistryClient;
import com.remmy.simplepaas.client.registry.RegistryClientFactory;
import com.remmy.simplepaas.dto.Image;
import com.remmy.simplepaas.dto.RepositoryType;
import com.remmy.simplepaas.service.ImageCacheService;
import com.remmy.simplepaas.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yejiaxin
 */
@Service
public class ImageServiceImpl implements ImageService {
    private final RegistryClientFactory clientFactory;
    @Autowired
    private ImageCacheService cacheService;

    public ImageServiceImpl(RegistryClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public List<Image> listImagesByRepositoryName() throws Exception {
        List<Image> imageList = cacheService.list();
        if (!imageList.isEmpty()){
            return imageList;
        }
        RegistryClient client = clientFactory.getClient(RepositoryType.V2);
        return client.listImages();
    }
}
