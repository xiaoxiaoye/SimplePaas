package com.remmy.simplepaas.service;

import com.remmy.simplepaas.model.SysParam;

import java.util.List;

/**
 * @author yejiaxin
 */
public interface SystemParamService {
    /**
     * 查询系统参数
     *
     * @param category 分类
     * @param code     编码
     * @return 参数值
     */
    String getSysParam(String category, String code);

    /**
     * 设置系统参数
     *
     * @param category 分类
     * @param code     编码
     * @param desc     描述
     * @param value    参数值
     */
    void setSysParam(String category, String code, String desc, String value);

    /**
     * 获取仓库地址
     *
     * @return
     */
    String getRegistryUrl();

    /**
     * 设置仓库连接地址
     *
     * @param registryUrl 仓库地址
     */
    void setRegistryUrl(String registryUrl);

    /**
     * 获取kubernetes 连接配置文件
     *
     * @return
     */
    String getKubeconfig();

    /**
     * 设置kubernetes连接配置文件
     *
     * @param kubeconfig kubernetes连接配置文件
     */
    void setKubeconfig(String kubeconfig);

    /**
     * 获取系统参数列表
     *
     * @return
     */
    List<SysParam> listParams();
}
