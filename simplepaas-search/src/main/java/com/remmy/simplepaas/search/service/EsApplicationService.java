package com.remmy.simplepaas.search.service;

import com.remmy.simplepaas.search.domain.EsApplication;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface EsApplicationService {
    /**
     * 从数据库中将所有的应用列表导入到ES
     * @return 导入数量
     */
    int importAll();

    /**
     * 模糊搜索
     * @param keyword 关键字
     * @return 应用列表
     */
    List<EsApplication> search(String keyword);

    /**
     * 根据id创建应用
     * @param id 应用id
     * @return 应用信息
     */
    EsApplication create(Long id);

    /**
     * 删除应用
     * @param id 应用id
     */
    void delete(Long id);
}
