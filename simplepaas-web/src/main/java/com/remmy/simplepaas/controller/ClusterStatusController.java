package com.remmy.simplepaas.controller;

import com.remmy.simplepaas.dto.ClusterStatus;
import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.service.ClusterStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "工作平台",  description = "集群监控")
public class ClusterStatusController {
    private final ClusterStatusService statusService;

    public ClusterStatusController(ClusterStatusService statusService) {
        this.statusService = statusService;
    }

    @ApiOperation("集群状态")
    @GetMapping("/cluster/status")
    public RespBean getClusterStatus() throws Exception {
        ClusterStatus clusterStatus = statusService.getClusterStatus();
        return RespBean.ok("success", clusterStatus);
    }
}
