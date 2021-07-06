package com.remmy.simplepaas.mapper;

import com.remmy.simplepaas.model.InstanceStatus;
import com.remmy.simplepaas.model.InstanceStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InstanceStatusMapper {
    long countByExample(InstanceStatusExample example);

    int deleteByExample(InstanceStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InstanceStatus record);

    int insertSelective(InstanceStatus record);

    List<InstanceStatus> selectByExample(InstanceStatusExample example);

    InstanceStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InstanceStatus record, @Param("example") InstanceStatusExample example);

    int updateByExample(@Param("record") InstanceStatus record, @Param("example") InstanceStatusExample example);

    int updateByPrimaryKeySelective(InstanceStatus record);

    int updateByPrimaryKey(InstanceStatus record);
}