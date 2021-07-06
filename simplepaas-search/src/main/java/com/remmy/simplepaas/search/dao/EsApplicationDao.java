package com.remmy.simplepaas.search.dao;

import com.remmy.simplepaas.search.domain.EsApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yejiaxin
 */
@Mapper
public interface EsApplicationDao {
    /**
     * 查询所有应用配置
     * @param id 应用id
     * @return 应用列表
     */
    List<EsApplication> listAllEsApplication(@Param("id") Long id);
}
