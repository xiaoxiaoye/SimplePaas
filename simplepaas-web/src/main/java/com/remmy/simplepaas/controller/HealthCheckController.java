package com.remmy.simplepaas.controller;

import com.remmy.simplepaas.client.kubernetes.KubeClient;
import com.remmy.simplepaas.common.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yejiaxin
 */
@Api(value = "健康检查", description = "健康检查")
@RestController
public class HealthCheckController {
    private final KubeClient kubeClient;

    public HealthCheckController(KubeClient kubeClient) {
        this.kubeClient = kubeClient;
    }

    public RespBean moduleHealth() {
        boolean kubeHealth = kubeClient.health();
        return null;
    }
}
