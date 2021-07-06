package com.remmy.simplepaas.dto;

import com.remmy.simplepaas.model.UmsResource;
import com.remmy.simplepaas.model.UmsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yejiaxin
 */
public class UserDetailImpl implements UserDetails {
    private final UmsUser user;
    private final List<UmsResource> resources;

    public UserDetailImpl(UmsUser user, List<UmsResource> resources) {
        this.user = user;
        this.resources = resources;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resources.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == 1;
    }
}
