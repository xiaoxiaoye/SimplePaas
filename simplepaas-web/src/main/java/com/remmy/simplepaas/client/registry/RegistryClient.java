package com.remmy.simplepaas.client.registry;

import com.remmy.simplepaas.dto.Image;
import com.remmy.simplepaas.dto.RepositoryStatus;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface RegistryClient {
    /**
     * 获取仓库全量镜像列表
     * @return
     * @throws Exception
     */
    List<Image> listImages() throws Exception;

    /**
     * 删除仓库镜像
     * @param name
     * @param tag
     */
    void deleteByTag(String name, String tag);

    /**
     * 检查仓库健康度
     * @return
     */
    boolean health();

    /**
     * 获取仓库详细信息
     * @return
     */
    RepositoryStatus getInfo() throws Exception;
}
