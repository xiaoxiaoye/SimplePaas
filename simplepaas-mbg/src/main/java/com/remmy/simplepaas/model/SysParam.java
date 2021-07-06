package com.remmy.simplepaas.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SysParam implements Serializable {
    private Integer paramId;

    private String paramCode;

    private String paramName;

    private String paramValue;

    private String paramCategory;

    private static final long serialVersionUID = 1L;

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamCategory() {
        return paramCategory;
    }

    public void setParamCategory(String paramCategory) {
        this.paramCategory = paramCategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paramId=").append(paramId);
        sb.append(", paramCode=").append(paramCode);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramValue=").append(paramValue);
        sb.append(", paramCategory=").append(paramCategory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}