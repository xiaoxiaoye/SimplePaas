package com.remmy.simplepaas.client.kubernetes.convert;

import com.remmy.simplepaas.client.kubernetes.KubeClient;
import com.remmy.simplepaas.dto.DeployMode;
import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationStatus;
import com.remmy.simplepaas.model.InstanceStatus;
import com.remmy.simplepaas.utils.CopyUtil;
import com.remmy.simplepaas.utils.TemplateParser;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodCondition;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yejiaxin
 */
@Component
public class PodConverter implements Converter {
    private final KubeClient kubeClient;
    private final TemplateParser templateParser;

    private final String podTemplate;

    public PodConverter(KubeClient client, TemplateParser templateParser) {
        this.templateParser = templateParser;
        this.kubeClient = client;
        try {
            ClassPathResource resource = new ClassPathResource("kubernetes/pod.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            podTemplate = reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApplicationStatus status(ApplicationDefine app) throws Exception {
        List<V1Pod> instances = listAppInstances(app);
        int readyNum = 0;
        List<InstanceStatus> instanceStatuses = new LinkedList<>();
        for (V1Pod instance : instances) {
            if (instance.getMetadata() == null || instance.getStatus() == null || instance.getSpec() == null) {
                continue;
            }
            InstanceStatus instanceStatus = new InstanceStatus();
            instanceStatus.setAppId(app.getId());
            instanceStatus.setAppName(instance.getMetadata().getName());
            instanceStatus.setNodeIp(instance.getStatus().getHostIP());
            instanceStatus.setNodeName(instance.getSpec().getNodeName());
            instanceStatus.setHealth((byte) 0);
            if (podIsReady(instance)) {
                readyNum++;
                instanceStatus.setHealth((byte) 1);
            }
            instanceStatuses.add(instanceStatus);
        }
        ApplicationStatus applicationStatus = new ApplicationStatus();
        applicationStatus.setAppId(app.getId());
        applicationStatus.setAppName(app.getName());
        applicationStatus.setTargetNum(app.getTarget());
        applicationStatus.setUpdateNum(instances.size());
        applicationStatus.setAvailableNum(readyNum);
        applicationStatus.setReadyNum(instances.size());
        return applicationStatus;
    }

    private boolean podIsReady(V1Pod pod) {
        if (pod.getStatus() == null || pod.getStatus().getConditions() == null) {
            return false;
        }
        List<V1PodCondition> conditions = pod.getStatus().getConditions();
        for (V1PodCondition condition : conditions) {
            if ("ContainersReady".equals(condition.getType()) && "False".equals(condition.getStatus())) {
                return false;
            }
            if ("Ready".equals(condition.getType()) && "False".equals(condition.getStatus())) {
                return false;
            }
        }
        return true;
    }

    private List<V1Pod> listAppInstances(ApplicationDefine app) throws Exception {
        Map<String, String> labels = new HashMap<>();
        labels.put("app-id", app.getId().toString());
        return kubeClient.listPods(labels);
    }

    private void sortPodInstance(List<V1Pod> podList) {
        podList.sort(new Comparator<V1Pod>() {
            @Override
            public int compare(V1Pod o1, V1Pod o2) {
                if (o1.getMetadata() == null || o1.getMetadata().getName() == null
                        || o2.getMetadata() == null || o2.getMetadata().getName() == null) {
                    return 0;
                }
                return o1.getMetadata().getName().compareTo(o2.getMetadata().getName());
            }
        }.reversed());
    }

    @Override
    public void apply(ApplicationDefine app) throws Exception {
        List<V1Pod> instances = listAppInstances(app);
        int designCount = app.getTarget();
        int diff = designCount - instances.size();
        // 目标实例数比实际实例数小，增加实例
        if (diff > 0) {
            V1Pod pod = convert(app);
            for (int i = instances.size(); i < designCount; i++) {
                V1Pod podCopy = (V1Pod) CopyUtil.deepCopy(pod, pod.getClass());
                podCopy.getMetadata().setName(app.getName() + "-" + i);
                kubeClient.applyPod(podCopy);
            }
            return;
        }
        // 目标实例数比实际实例数大，缩减实例
        if (diff < 0) {
            sortPodInstance(instances);
            for (int i = 0; i < -diff; i++) {
                kubeClient.deletePod(instances.get(i));
            }
        }
    }

    @Override
    public void delete(ApplicationDefine app) throws Exception {
        List<V1Pod> instances = listAppInstances(app);
        for (V1Pod instance : instances) {
            kubeClient.deletePod(instance);
        }
    }

    @Override
    public String getDeployMode() {
        return DeployMode.POD.getMode();
    }

    public V1Pod convert(ApplicationDefine app) throws Exception {
        String podJson = templateParser.parse(this.podTemplate, app);
        return Configuration.getDefaultApiClient().getJSON().deserialize(podJson, V1Pod.class);
    }
}
