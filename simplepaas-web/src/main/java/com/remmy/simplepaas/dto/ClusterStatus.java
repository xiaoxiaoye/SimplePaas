package com.remmy.simplepaas.dto;

import lombok.*;

import java.util.Map;

/**
 * @author yejiaxin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClusterStatus {
    /**
     * 节点总数
     */
    private int nodeTotal;
    /**
     * 节点异常数
     */
    private int nodeException;
    /**
     * pod实例总数
     */
    private int podTotal;
    /**
     * pod实例异常数
     */
    private int podException;
    /**
     * 组件监控
     */
    private Map<String, ModuleStatus> moduleStatuses;
    /**
     * 节点信息
     */
    private Map<String, NodeStatus> nodeStatuses;
}
