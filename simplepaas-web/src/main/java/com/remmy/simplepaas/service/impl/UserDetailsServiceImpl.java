package com.remmy.simplepaas.service.impl;

import com.remmy.simplepaas.dao.UmsUserRoleRelationDao;
import com.remmy.simplepaas.mapper.UmsUserMapper;
import com.remmy.simplepaas.model.UmsResource;
import com.remmy.simplepaas.model.UmsUser;
import com.remmy.simplepaas.model.UmsUserExample;
import com.remmy.simplepaas.dto.UserDetailImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yejiaxin
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UmsUserMapper userMapper;
    private final UmsUserRoleRelationDao userRoleRelationDao;

    public UserDetailsServiceImpl(UmsUserMapper userMapper, UmsUserRoleRelationDao userRoleRelationDao) {
        this.userMapper = userMapper;
        this.userRoleRelationDao = userRoleRelationDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsUserExample cond = new UmsUserExample();
        cond.or().andUsernameEqualTo(username);
        List<UmsUser> users = userMapper.selectByExample(cond);
        if (users.size()==0){
            throw new UsernameNotFoundException("not found");
        }
        UmsUser user = users.get(0);
        List<UmsResource> resources = userRoleRelationDao.getUserResource(user.getId());
        return new UserDetailImpl(users.get(0), resources);
    }
}
