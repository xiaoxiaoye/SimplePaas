package com.remmy.simplepaas.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author yejiaxin
 */
@Data
@Builder
public class RepositoryStatus {
    /**
     * 仓库名称
     */
    private String name;
    /**
     * 仓库镜像数量
     */
    private Long count;
    /**
     * 仓库镜像磁盘占用大小
     */
    private Long diskSize;
    /**
     * 仓库服务是否健康
     */
    private Boolean isHealth;
    /**
     * 仓库地址
     */
    private String address;
}
