package com.remmy.simplepaas.service;

import com.github.pagehelper.PageInfo;
import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
    /**
     * 创建或更新应用配置
     *
     * @param app 应用定义
     */
    void applyApplication(ApplicationDefine app);


    /**
     * 删除应用
     *
     * @param appId 应用id
     */
    void deleteApplication(int appId);

    /**
     * 获取应用状态
     *
     * @param appId 应用id
     */
    ApplicationStatus getApplicationStatus(int appId) throws Exception;

    /**
     * 获取应用列表
     *
     * @return 应用列表
     */
    List<ApplicationDefine> listApplication();

    /**
     * 获取应用分页列表
     *
     * @param pageNum  分页序号
     * @param pageSize 分页大小
     * @return 应用分页列表
     */
    PageInfo<ApplicationDefine> listApplicationPage(int pageNum, int pageSize);

    /**
     * 查询应用定义
     *
     * @param appId 应用id
     * @return 应用配置详情
     */
    ApplicationDefine getApplication(int appId);

    /**
     * 应用发布
     *
     * @param appId 应用id
     * @throws Exception
     */
    void publishApplication(int appId, int target) throws Exception;

    /**
     * 应用下线
     *
     * @param appId
     * @throws Exception
     */
    void offlineApplication(int appId) throws Exception;

    /**
     * 更新应用状态
     */
    void updateApplicationStatus() throws Exception;
}
