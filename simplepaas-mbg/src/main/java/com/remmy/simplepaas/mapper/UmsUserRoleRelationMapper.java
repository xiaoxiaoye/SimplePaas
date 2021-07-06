package com.remmy.simplepaas.mapper;

import com.remmy.simplepaas.model.UmsUserRoleRelation;
import com.remmy.simplepaas.model.UmsUserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsUserRoleRelationMapper {
    long countByExample(UmsUserRoleRelationExample example);

    int deleteByExample(UmsUserRoleRelationExample example);

    int insert(UmsUserRoleRelation record);

    int insertSelective(UmsUserRoleRelation record);

    List<UmsUserRoleRelation> selectByExample(UmsUserRoleRelationExample example);

    int updateByExampleSelective(@Param("record") UmsUserRoleRelation record, @Param("example") UmsUserRoleRelationExample example);

    int updateByExample(@Param("record") UmsUserRoleRelation record, @Param("example") UmsUserRoleRelationExample example);
}