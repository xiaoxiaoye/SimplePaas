package com.remmy.simplepaas.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Repository implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "仓库名称")
    private String name;

    @ApiModelProperty(value = "仓库状态 0-异常 1-正常")
    private Byte status;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "仓库IP地址")
    private String host;

    @ApiModelProperty(value = "仓库端口")
    private Integer port;

    @ApiModelProperty(value = "http/https")
    private String protocol;

    private String password;

    @ApiModelProperty(value = "V2/Harbor")
    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", username=").append(username);
        sb.append(", host=").append(host);
        sb.append(", port=").append(port);
        sb.append(", protocol=").append(protocol);
        sb.append(", password=").append(password);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}