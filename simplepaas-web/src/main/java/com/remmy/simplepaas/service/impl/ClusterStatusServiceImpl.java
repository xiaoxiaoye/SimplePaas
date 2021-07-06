package com.remmy.simplepaas.service.impl;

import com.remmy.simplepaas.client.kubernetes.KubeClient;
import com.remmy.simplepaas.dto.ClusterStatus;
import com.remmy.simplepaas.dto.ModuleStatus;
import com.remmy.simplepaas.dto.NodeStatus;
import com.remmy.simplepaas.service.ClusterStatusService;
import io.kubernetes.client.custom.Quantity;
import io.kubernetes.client.openapi.models.*;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author yejiaxin
 */
@Service
public class ClusterStatusServiceImpl implements ClusterStatusService {
    private final KubeClient kubeClient;

    public ClusterStatusServiceImpl(KubeClient kubeClient) {
        this.kubeClient = kubeClient;
    }

    @Override
    public ClusterStatus getClusterStatus() throws Exception {
        List<V1Pod> podList = kubeClient.listPods();
        List<V1Node> nodeList = kubeClient.listNodes();
        ClusterStatus clusterStatus = ClusterStatus.builder()
                .nodeTotal(nodeList.size())
                .podTotal(podList.size())
                .build();

        parseNodeStatus(nodeList, clusterStatus);
        parseModuleStatus(podList, clusterStatus);
        parsePodStatus(podList, clusterStatus);
        return clusterStatus;
    }

    private void parsePodStatus(List<V1Pod> podList, ClusterStatus clusterStatus) {
        for (V1Pod pod : podList) {
            boolean isRunning = podIsRunning(pod);
            if (!isRunning) {
                clusterStatus.setPodException(clusterStatus.getPodException() + 1);
            }

            String podSpecNodeName = pod.getSpec().getNodeName();
            if (!clusterStatus.getNodeStatuses().containsKey(podSpecNodeName)) {
                continue;
            }
            NodeStatus nodeStatus = clusterStatus.getNodeStatuses().get(podSpecNodeName);
            nodeStatus.setContainerTotal(nodeStatus.getContainerTotal() + 1);
            if (!isRunning) {
                nodeStatus.setContainerException(nodeStatus.getContainerException() + 1);
            }

            long cpuLimit = 0;
            long cpuRequest = 0;
            long memoryLimit = 0;
            long memoryRequest = 0;
            List<V1Container> containers = pod.getSpec().getContainers();
            for (V1Container container : containers) {
                Map<String, Quantity> limits = container.getResources().getLimits();
                Map<String, Quantity> requests = container.getResources().getRequests();
                if (limits != null && limits.get("cpu") != null) {
                    cpuLimit += limits.get("cpu").getNumber().longValue();
                }
                if (requests != null && requests.get("cpu") != null) {
                    cpuRequest += requests.get("cpu").getNumber().longValue();
                }
                if (limits != null && limits.get("memory") != null) {
                    memoryLimit += limits.get("memory").getNumber().longValue();
                }
                if (requests != null && requests.get("memory") != null) {
                    memoryRequest += requests.get("memory").getNumber().longValue();
                }
            }
            nodeStatus.setCpuLimit(nodeStatus.getCpuLimit() + cpuLimit);
            nodeStatus.setCpuRequest(nodeStatus.getCpuRequest() + cpuRequest);
            nodeStatus.setMemoryLimit(nodeStatus.getMemoryLimit() + memoryLimit);
            nodeStatus.setMemoryRequest(nodeStatus.getMemoryRequest() + memoryRequest);
        }
    }

    private void parseModuleStatus(List<V1Pod> podList, ClusterStatus clusterStatus) {
        Map<String, ModuleStatus> moduleStatusMap = new HashMap<>();
        for (V1Pod pod : podList) {
            Map<String, String> labels = pod.getMetadata().getLabels();
            if (labels == null) {
                continue;
            }
            if (labels.containsKey("tier") && labels.get("tier").equals("control-plane") && labels.containsKey("component")) {
                String moduleName = labels.get("component");
                ModuleStatus moduleStatus = moduleStatusMap.get(moduleName);
                if (moduleStatus == null) {
                    moduleStatus = new ModuleStatus();
                    moduleStatus.setName(moduleName);
                    moduleStatusMap.put(moduleName, moduleStatus);
                }
                moduleStatus.setTotal(moduleStatus.getTotal() + 1);
                if (!podIsRunning(pod)) {
                    moduleStatus.setException(moduleStatus.getException() + 1);
                }
            }
        }
        clusterStatus.setModuleStatuses(moduleStatusMap);
    }

    private void parseNodeStatus(List<V1Node> nodeList, ClusterStatus clusterStatus) {
        Map<String, NodeStatus> nodeStatusMap = new HashMap<>();
        for (V1Node node : nodeList) {
            String nodeName = node.getMetadata().getName();
            NodeStatus nodeStatus = nodeStatusMap.get(nodeName);
            if (nodeStatus == null) {
                nodeStatus = NodeStatus.builder().name(nodeName).isHealth(true).errMsg("").build();
                nodeStatusMap.put(nodeName, nodeStatus);
            }

            parseNodeHealth(node, nodeStatus);

            V1NodeStatus v1NodeStatus = node.getStatus();
            // 地址信息
            for (V1NodeAddress address : v1NodeStatus.getAddresses()) {
                if (address.getType().equals("Hostname")) {
                    nodeStatus.setName(address.getAddress());
                }
                if (address.getType().equals("InternalIP")) {
                    nodeStatus.setIp(address.getAddress());
                }
            }

            // 镜像
            int imageTotal = 0;
            long imageDiskTotal = 0;
            for (V1ContainerImage image : v1NodeStatus.getImages()) {
                imageDiskTotal += image.getSizeBytes();
                imageTotal++;
            }
            nodeStatus.setImageTotal(imageTotal);
            nodeStatus.setImageDiskTotalByte(imageDiskTotal);

            //计算资源
            Map<String, Quantity> resources = v1NodeStatus.getAllocatable();
            if (resources != null) {
                for (Map.Entry<String, Quantity> resource : resources.entrySet()) {
                    if (resource.getKey().equals("cpu")) {
                        nodeStatus.setCpuTotal(resource.getValue().getNumber().longValue());
                    }

                    if (resource.getKey().equals("memory")) {
                        nodeStatus.setMemoryTotal(resource.getValue().getNumber().longValue());
                    }

                    if (resource.getKey().equals("pods")) {
                        nodeStatus.setContainerLimit(resource.getValue().getNumber().intValue());
                    }
                }
            }
        }
        clusterStatus.setNodeStatuses(nodeStatusMap);
    }

    private void parseNodeHealth(V1Node node, NodeStatus nodeStatus) {
        List<V1NodeCondition> conditions = node.getStatus().getConditions();
        for (V1NodeCondition condition : conditions) {
            String conditionType = condition.getType();
            String conditionStatus = condition.getStatus();
            Set<String> pressureConditions = new HashSet<>(Arrays.asList("MemoryPressure", "DiskPressure", "PIDPressure"));
            if (pressureConditions.contains(conditionType) && "True".equals(conditionStatus)
                    || ("Ready".equals(conditionType) && !"True".equals(conditionStatus))) {
                nodeStatus.setIsHealth(false);
                nodeStatus.setErrMsg(condition.getMessage());
                return;
            }
        }
    }

    private boolean podIsRunning(V1Pod pod) {
        V1PodStatus podStatus = pod.getStatus();
        if (podStatus == null || podStatus.getPhase() == null) {
            return false;
        }

        return "Running".equals(podStatus.getPhase());
    }
}
