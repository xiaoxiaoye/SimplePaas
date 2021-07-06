package com.remmy.simplepaas.search.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yejiaxin
 */
@Data
@Document(indexName = "simplepaas-application", type = "_doc",replicas = 0)
public class EsApplication implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Keyword)
    private String deployMode;

    @Field(type = FieldType.Keyword)
    private String command;

    @Field(type = FieldType.Keyword)
    private String image;

    private String pullPolicy;

    private Integer target;

    private Date createTime;
}
