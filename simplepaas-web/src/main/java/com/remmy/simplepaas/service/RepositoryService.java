package com.remmy.simplepaas.service;

import com.remmy.simplepaas.model.Repository;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface RepositoryService {
    /**
     * 根据名称查询仓库
     * @param name 名称
     * @return
     */
    List<Repository> getRepositoryByName(String name);

    /**
     * 仓库列表
     * @return 仓库列表
     */
    List<Repository> listRepository();
}
