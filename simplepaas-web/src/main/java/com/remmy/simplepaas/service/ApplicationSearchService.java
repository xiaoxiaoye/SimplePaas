package com.remmy.simplepaas.service;

import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.model.ApplicationDefine;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface ApplicationSearchService {

    /**
     * 查找应用
     *
     * @param keyword 关键字
     * @return 响应
     */
    RespBean search(String keyword);

    /**
     * 创建应用搜索
     * @param id 应用id
     * @return 响应
     */
    void create(Integer id);

    /**
     * 删除应用搜索
     * @param id 应用id
     * @return 响应
     */
    void delete(Integer id);
}
