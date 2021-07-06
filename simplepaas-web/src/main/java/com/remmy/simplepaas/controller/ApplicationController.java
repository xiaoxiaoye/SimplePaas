package com.remmy.simplepaas.controller;

import com.github.pagehelper.PageInfo;
import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationStatus;
import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 应用管理
 *
 * @author yejiaxin
 */
@RestController
@Api(tags = "应用管理", description = "应用管理")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @ApiOperation(value = "创建或更新应用", notes = "创建或更新应用")
    @PostMapping("/application")
    public RespBean createOrUpdateApplication(@RequestBody ApplicationDefine application) {
        applicationService.applyApplication(application);
        return RespBean.ok("success");
    }

    @ApiOperation(value = "删除应用", notes = "删除应用")
    @DeleteMapping("/application")
    public RespBean deleteApplication(@RequestParam Integer appId) {
        applicationService.deleteApplication(appId);
        return RespBean.ok("success");
    }

    @ApiOperation(value = "获取应用状态", notes = "获取应用状态")
    @GetMapping("/application/status")
    public RespBean getApplicationStatus(@RequestParam Integer appId) throws Exception {
        ApplicationStatus applicationStatus = applicationService.getApplicationStatus(appId);
        return RespBean.ok("success", applicationStatus);
    }

    @ApiOperation(value = "查询应用列表", notes = "查询应用列表")
    @GetMapping("/application")
    public RespBean listApplication(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<ApplicationDefine> applicationDefineList = applicationService.listApplicationPage(pageNum, pageSize);
        return RespBean.ok("success", applicationDefineList);
    }

    @ApiOperation(value = "查询单个应用配置", notes = "查询单个应用配置")
    @GetMapping("/application/{appId}")
    public RespBean getApplication(@PathVariable Integer appId) {
        ApplicationDefine applicationDefine = applicationService.getApplication(appId);
        return RespBean.ok("success", applicationDefine);
    }

    @ApiOperation(value = "应用发布", notes = "应用发布到k8s集群")
    @PostMapping("/application/publish/{appId}")
    public RespBean publishApplication(@PathVariable Integer appId, @RequestParam Integer target) throws Exception {
        applicationService.publishApplication(appId, target);
        return RespBean.ok("successs");
    }

    @ApiOperation(value = "应用下线", notes = "应用从k8s集群下线")
    @PostMapping("/application/offline/{appId}")
    public RespBean offlineApplication(@PathVariable Integer appId) throws Exception {
        applicationService.offlineApplication(appId);
        return RespBean.ok("success");
    }
}
