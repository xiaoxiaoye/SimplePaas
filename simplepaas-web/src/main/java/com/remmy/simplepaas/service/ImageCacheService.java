package com.remmy.simplepaas.service;

import com.remmy.simplepaas.dto.Image;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface ImageCacheService {
    /**
     * 刷新镜像缓存
     */
    void refreshCache();

    /**
     * 获取镜像列表
     * @return 镜像列表
     */
    List<Image> list();

    /**
     * 查询镜像信息
     * @param imageId 镜像ID
     * @return 镜像信息
     */
    Image get(String imageId);
}
