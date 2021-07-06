package com.remmy.simplepaas.mapper;

import com.remmy.simplepaas.model.UmsRoleResourceRelation;
import com.remmy.simplepaas.model.UmsRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsRoleResourceRelationMapper {
    long countByExample(UmsRoleResourceRelationExample example);

    int deleteByExample(UmsRoleResourceRelationExample example);

    int insert(UmsRoleResourceRelation record);

    int insertSelective(UmsRoleResourceRelation record);

    List<UmsRoleResourceRelation> selectByExample(UmsRoleResourceRelationExample example);

    int updateByExampleSelective(@Param("record") UmsRoleResourceRelation record, @Param("example") UmsRoleResourceRelationExample example);

    int updateByExample(@Param("record") UmsRoleResourceRelation record, @Param("example") UmsRoleResourceRelationExample example);
}