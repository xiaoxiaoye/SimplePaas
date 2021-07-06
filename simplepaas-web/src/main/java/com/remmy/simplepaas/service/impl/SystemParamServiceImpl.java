package com.remmy.simplepaas.service.impl;

import com.remmy.simplepaas.mapper.SysParamMapper;
import com.remmy.simplepaas.model.SysParam;
import com.remmy.simplepaas.model.SysParamExample;
import com.remmy.simplepaas.service.SystemParamService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yejiaxin
 */
@Service
public class SystemParamServiceImpl implements SystemParamService {
    private final SysParamMapper mapper;

    public SystemParamServiceImpl(SysParamMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getSysParam(String category, String code) {
        SysParamExample cond = new SysParamExample();
        cond.or().andParamCategoryEqualTo(category).andParamCodeEqualTo(code);

        List<SysParam> result = mapper.selectByExample(cond);

        return result.get(0).getParamValue();
    }

    @Override
    public void setSysParam(String category, String code, String desc, String value) {
        SysParam sysParam = new SysParam();
        sysParam.setParamCategory(category);
        sysParam.setParamName(desc);
        sysParam.setParamCode(code);
        sysParam.setParamValue(value);

        SysParamExample cond = new SysParamExample();
        cond.or().andParamCategoryEqualTo(category).andParamCodeEqualTo(code);
        List<SysParam> result = mapper.selectByExample(cond);
        if (result.size() == 0) {
            mapper.insert(sysParam);
            return;
        }
        mapper.updateByExampleSelective(sysParam, cond);
    }

    /**
     * 获取仓库地址
     *
     * @return
     */
    @Override
    public String getRegistryUrl() {
        return getSysParam("REGISTRY", "REGISTRY_URL");
    }

    /**
     * 设置仓库连接地址
     *
     * @param registryUrl 仓库地址
     */
    @Override
    public void setRegistryUrl(String registryUrl) {
        this.setSysParam("REGISTRY", "REGISTRY_URL", null, registryUrl);
    }

    /**
     * 获取kubernetes 连接配置文件
     *
     * @return
     */
    @Override
    public String getKubeconfig() {
        return getSysParam("KUBERNETES", "KUBERNETES_CONFIG");
    }

    /**
     * 设置kubernetes连接配置文件
     *
     * @param kubeconfig kubernetes连接配置文件
     */
    @Override
    public void setKubeconfig(String kubeconfig) {
        setSysParam("KUBERNETES", "KUBERNETES_CONFIG", null, kubeconfig);
    }

    /**
     * 获取系统参数列表
     *
     * @return
     */
    @Override
    public List<SysParam> listParams() {
        return mapper.selectByExample(null);
    }
}
