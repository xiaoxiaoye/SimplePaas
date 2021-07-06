package com.remmy.simplepaas.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author yejiaxin
 */
@Data
@Builder
public class ModuleHealth {
    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否健康
     */
    private Boolean health;

    /**
     * 相关信息
     */
    private String message;
}
