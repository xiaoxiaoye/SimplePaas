package com.remmy.simplepaas.client.kubernetes.convert;

import com.remmy.simplepaas.model.ApplicationStatus;
import com.remmy.simplepaas.model.ApplicationDefine;

/**
 * @author yejiaxin
 */
public interface Converter {
    /**
     * 查询k8s中应用状态
     *
     * @param app 应用配置
     * @return 应用状态
     * @throws Exception
     */
    ApplicationStatus status(ApplicationDefine app) throws Exception;

    /**
     * 根据应用配置更新或创建k8s应用对象
     *
     * @param app 应用配置
     */
    void apply(ApplicationDefine app) throws Exception;

    /**
     * 删除k8s中应用对象
     *
     * @param app 应用配置
     */
    void delete(ApplicationDefine app) throws Exception;

    /**
     * 获取应用部署模式
     *
     * @return 部署模式
     */
    String getDeployMode();
}
