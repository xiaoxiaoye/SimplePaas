package com.remmy.simplepaas.dto;

/**
 * @author yejiaxin
 */

public enum RepositoryType {
    /**
     * 官方仓库
     */
    V2("V2"),
    /**
     * Harbor仓库
     */
    HARBOR("Harbor");

    private final String type;

    RepositoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
