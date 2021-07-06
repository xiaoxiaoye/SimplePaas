package com.remmy.simplepaas.mapper;

import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplicationDefineMapper {
    long countByExample(ApplicationDefineExample example);

    int deleteByExample(ApplicationDefineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationDefine record);

    int insertSelective(ApplicationDefine record);

    List<ApplicationDefine> selectByExample(ApplicationDefineExample example);

    ApplicationDefine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicationDefine record, @Param("example") ApplicationDefineExample example);

    int updateByExample(@Param("record") ApplicationDefine record, @Param("example") ApplicationDefineExample example);

    int updateByPrimaryKeySelective(ApplicationDefine record);

    int updateByPrimaryKey(ApplicationDefine record);
}