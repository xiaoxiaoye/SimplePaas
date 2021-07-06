package com.remmy.simplepaas.service;

import com.remmy.simplepaas.dto.Image;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface ImageService {
    /**
     * 仓库镜像列表
     * @return 镜像列表
     * @throws Exception
     */
    List<Image> listImagesByRepositoryName() throws Exception;
}
