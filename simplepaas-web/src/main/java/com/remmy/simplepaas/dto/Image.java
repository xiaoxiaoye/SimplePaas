package com.remmy.simplepaas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @author yejiaxin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {
    /**
     * 镜像id
     */
    private String id;

    /**
     * 镜像名称
     */
    private String name;

    /**
     * 镜像版本
     */
    private String version;

    /**
     * 镜像大小
     */
    private int size;

    /**
     * 创建时间
     */
    private Date createTime;
}
