package com.remmy.simplepaas.controller;

import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.model.SysParam;
import com.remmy.simplepaas.service.SystemParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yejiaxin
 */
@Api(tags = "系统参数", description = "系统参数配置")
@RestController
public class SystemParamController {
    private final SystemParamService systemParamService;

    public SystemParamController(SystemParamService systemParamService) {
        this.systemParamService = systemParamService;
    }

    @ApiOperation(value = "查询系统参数", notes = "查询系统参数")
    @GetMapping("/config/params")
    public RespBean getSystemParam(@RequestParam String category, @RequestParam String code) {
        String value = systemParamService.getSysParam(category, code);
        return RespBean.ok("success", value);
    }

    @ApiOperation(value = "设置系统参数", notes = "设置系统参数")
    @PostMapping("/config/params")
    public RespBean setSystemParam(@RequestBody SysParam sysParam) {
        systemParamService.setSysParam(sysParam.getParamCategory(),
                sysParam.getParamCode(),
                sysParam.getParamName(),
                sysParam.getParamValue());
        return RespBean.ok("success");
    }

    @ApiOperation(value = "系统参数列表", notes = "查询所有系统参数")
    @GetMapping("/config/params/all")
    public RespBean listSystemParams() {
        List<SysParam> paramList = systemParamService.listParams();
        return RespBean.ok("success", paramList);
    }

    @ApiOperation(value = "查询kubernetes客户端配置", notes = "查询kubernetes客户端配置")
    @GetMapping("/config/params/kubeconfig")
    public RespBean getKubeconfig() {
        return RespBean.ok("success", systemParamService.getKubeconfig());
    }

    @ApiOperation(value = "更新kubernetes客户端配置", notes = "更新kubernetes客户端配置")
    @PostMapping("/config/params/kubeconfig")
    public RespBean setKubeconfig(@RequestBody String kubeconfig) {
        systemParamService.setKubeconfig(kubeconfig);
        return RespBean.ok("success");
    }

    @ApiOperation(value = "查询仓库地址", notes = "仓库地址")
    @GetMapping("/config/params/registry")
    public RespBean getRegistryUrl() {
        return RespBean.ok("success", systemParamService.getRegistryUrl());
    }

    @ApiOperation(value = "更新仓库地址", notes = "仓库地址")
    @PostMapping("/config/params/registry")
    public RespBean setRegistryUrl(@RequestBody String registryUrl) {
        systemParamService.setRegistryUrl(registryUrl);
        return RespBean.ok("success");
    }
}
