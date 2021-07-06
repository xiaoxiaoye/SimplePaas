package com.remmy.simplepaas.mapper;

import com.remmy.simplepaas.model.UmsUser;
import com.remmy.simplepaas.model.UmsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsUserMapper {
    long countByExample(UmsUserExample example);

    int deleteByExample(UmsUserExample example);

    int insert(UmsUser record);

    int insertSelective(UmsUser record);

    List<UmsUser> selectByExample(UmsUserExample example);

    int updateByExampleSelective(@Param("record") UmsUser record, @Param("example") UmsUserExample example);

    int updateByExample(@Param("record") UmsUser record, @Param("example") UmsUserExample example);
}