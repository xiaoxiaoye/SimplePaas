package com.remmy.simplepaas.mapper;

import com.remmy.simplepaas.model.ApplicationStatus;
import com.remmy.simplepaas.model.ApplicationStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplicationStatusMapper {
    long countByExample(ApplicationStatusExample example);

    int deleteByExample(ApplicationStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationStatus record);

    int insertSelective(ApplicationStatus record);

    List<ApplicationStatus> selectByExample(ApplicationStatusExample example);

    ApplicationStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicationStatus record, @Param("example") ApplicationStatusExample example);

    int updateByExample(@Param("record") ApplicationStatus record, @Param("example") ApplicationStatusExample example);

    int updateByPrimaryKeySelective(ApplicationStatus record);

    int updateByPrimaryKey(ApplicationStatus record);
}