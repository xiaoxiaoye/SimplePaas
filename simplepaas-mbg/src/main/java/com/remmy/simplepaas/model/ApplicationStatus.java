package com.remmy.simplepaas.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ApplicationStatus implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "应用id")
    private Integer appId;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "应用目标实例数")
    private Integer targetNum;

    @ApiModelProperty(value = "应用可用实例数")
    private Integer availableNum;

    @ApiModelProperty(value = "应用配置已更新数量")
    private Integer updateNum;

    @ApiModelProperty(value = "应用实际实例数")
    private Integer readyNum;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getTargetNum() {
        return targetNum;
    }

    public void setTargetNum(Integer targetNum) {
        this.targetNum = targetNum;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(Integer availableNum) {
        this.availableNum = availableNum;
    }

    public Integer getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(Integer updateNum) {
        this.updateNum = updateNum;
    }

    public Integer getReadyNum() {
        return readyNum;
    }

    public void setReadyNum(Integer readyNum) {
        this.readyNum = readyNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", appName=").append(appName);
        sb.append(", targetNum=").append(targetNum);
        sb.append(", availableNum=").append(availableNum);
        sb.append(", updateNum=").append(updateNum);
        sb.append(", readyNum=").append(readyNum);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}