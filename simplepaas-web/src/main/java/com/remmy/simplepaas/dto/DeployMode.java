package com.remmy.simplepaas.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 部署模式
 * @author yejiaxin
 */
public enum DeployMode {
    /**
     * Deployment
     */
    DEPLOYMENT("deployment"),
    /**
     * Pod
     */
    POD("pod"),
    /**
     * Daemonset
     */
    DAEMONSET("daemonset"),

    NONE("none")
    ;

    private final String mode;

    DeployMode(String mode) {
        this.mode = mode;
    }

    @JsonValue
    public String getMode() {
        return mode;
    }
}
