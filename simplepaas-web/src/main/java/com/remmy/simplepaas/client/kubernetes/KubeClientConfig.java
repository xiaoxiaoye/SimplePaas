package com.remmy.simplepaas.client.kubernetes;

import com.remmy.simplepaas.service.impl.SystemParamServiceImpl;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * kubernetes客户端
 *
 * @author yejiaxin
 */

@Component
public class KubeClientConfig {
    private final SystemParamServiceImpl systemParamService;
    private CoreV1Api coreV1Api;
    private ApiClient apiClient;
    private ExtensionsV1beta1Api extensionsV1beta1Api;

    public KubeClientConfig(SystemParamServiceImpl systemParamService) throws IOException {
        this.systemParamService = systemParamService;
        updateClient();
    }

    public void updateClient() throws IOException {
        String kubeconfigContext = systemParamService.getKubeconfig();
        if (StringUtils.isNotBlank(kubeconfigContext)) {
            this.apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new StringReader(kubeconfigContext))).build();
        } else {
            String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
            this.apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
        }

        this.coreV1Api = new CoreV1Api(apiClient);
        this.extensionsV1beta1Api = new ExtensionsV1beta1Api(apiClient());
    }

    public ApiClient apiClient() throws IOException {
        return this.apiClient;
    }

    public CoreV1Api kubeCoreV1Api() throws IOException {
        return this.coreV1Api;
    }

    public ExtensionsV1beta1Api extensionsV1beta1Api() throws IOException {
        return this.extensionsV1beta1Api;
    }
}
