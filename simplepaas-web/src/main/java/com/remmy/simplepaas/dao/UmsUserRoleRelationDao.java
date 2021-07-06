package com.remmy.simplepaas.dao;

import com.remmy.simplepaas.model.UmsResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yejiaxin
 */
@Mapper
public interface UmsUserRoleRelationDao {
    /**
     * 获取用户资源列表
     * @param userId 用户id
     * @return 资源列表
     */
    List<UmsResource> getUserResource(Long userId);
}
