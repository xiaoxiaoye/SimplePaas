package com.remmy.simplepaas.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NodeStatus {
    // 节点名称
    private String name;
    // 节点IP地址
    private String ip;
    // cpu总量
    private long cpuTotal;
    // cpu request分配量
    private long cpuRequest;
    // cpu limit分配量
    private long cpuLimit;
    // 内存总量
    private long memoryTotal;
    // 内存 request分配量
    private long memoryRequest;
    // 内存 limit分配量
    private long memoryLimit;
    // 容器总数
    private int containerTotal;
    // 容器异常数
    private int containerException;
    // 容器数上限
    private int containerLimit;
    // 镜像占用磁盘大小
    private long imageDiskTotalByte;
    // 镜像数目
    private int imageTotal;
    // 主机状态
    private Boolean isHealth;
    // 错误信息
    private String errMsg;
}
