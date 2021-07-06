package com.remmy.simplepaas.client.kubernetes;

import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.JSON;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Node;
import io.kubernetes.client.openapi.models.V1NodeList;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.PatchUtils;
import io.kubernetes.client.util.labels.EqualityMatcher;
import io.kubernetes.client.util.labels.LabelSelector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yejiaxin
 */
@Component
@Slf4j
public class KubeClient {
    private static final String NOT_FOUND = "Not Found";
    private final KubeClientConfig config;

    public KubeClient(KubeClientConfig config) {
        this.config = config;
    }

    public boolean health(){
        try {
            int count = config.apiClient().getHttpClient().connectionPool().connectionCount();
            log.info("connection pool count:{}", count);
            return count > 0;
        } catch (IOException e) {
            log.error("kubeclient health check failed!", e);
        }
        return false;
    }

    public List<V1Pod> listPods() throws Exception {
        CoreV1Api coreV1Api = config.kubeCoreV1Api();
        V1PodList podList = coreV1Api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
        return podList.getItems();
    }

    public List<V1Pod> listPods(Map<String, String> labels) throws Exception {
        EqualityMatcher[] matcherList = new EqualityMatcher[labels.size()];
        int index=0;
        for (Map.Entry<String, String> entry : labels.entrySet()) {
            matcherList[index++] = EqualityMatcher.equal(entry.getKey(), entry.getValue());
        }
        LabelSelector selector = LabelSelector.and(matcherList);

        V1PodList podList = config.kubeCoreV1Api().listPodForAllNamespaces(null, null,  null, selector.toString(), null, null,null, null,null);
        return podList.getItems();
    }

    public void createPod(V1Pod pod) throws Exception {
        assert pod.getMetadata() != null && pod.getMetadata().getName() != null;
        CoreV1Api coreV1Api = config.kubeCoreV1Api();
        coreV1Api.createNamespacedPod(pod.getMetadata().getNamespace(), pod, null, null, null);
    }

    public V1Pod getPod(String name, String namespace) throws IOException, ApiException {
        return config.kubeCoreV1Api().readNamespacedPod(name, namespace, null, null, null);
    }

    public void updatePod(V1Pod pod) throws IOException, ApiException {
        assert pod.getMetadata() != null && pod.getMetadata().getName() != null;
        JSON json = new JSON();
        String patchString = json.serialize(pod);
        CoreV1Api coreV1Api = config.kubeCoreV1Api();
        V1Pod res = PatchUtils.patch(V1Pod.class, () -> {
            return coreV1Api.patchNamespacedPodCall(
                    pod.getMetadata().getName(),
                    pod.getMetadata().getNamespace(),
                    new V1Patch(patchString),
                    null, null, null, null, null
            );
        }, V1Patch.PATCH_FORMAT_STRATEGIC_MERGE_PATCH, coreV1Api.getApiClient());
    }

    public void deletePod(V1Pod pod) throws Exception {
        assert pod.getMetadata() != null && pod.getMetadata().getName() != null;
        config.kubeCoreV1Api().deleteNamespacedPod(pod.getMetadata().getName(), pod.getMetadata().getNamespace(), null, null, null, null, null, null);
    }

    public void applyPod(V1Pod pod) throws Exception {
        assert pod.getMetadata() != null && pod.getMetadata().getName() != null;
        try {
            V1Pod oldPod = getPod(pod.getMetadata().getName(), pod.getMetadata().getNamespace());
            if (oldPod == null) {
                createPod(pod);
            }
            updatePod(pod);
        } catch (ApiException e) {
            if (NOT_FOUND.equals(e.getMessage())) {
                createPod(pod);
                return;
            }
            throw e;
        }
    }

    public List<V1Node> listNodes() throws Exception {
        CoreV1Api coreV1Api = config.kubeCoreV1Api();
        V1NodeList nodeList = coreV1Api.listNode(null, null, null, null, null, null, null, null, null);
        return nodeList.getItems();
    }
}
