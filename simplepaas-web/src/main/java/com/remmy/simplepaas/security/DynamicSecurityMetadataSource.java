package com.remmy.simplepaas.security;

import cn.hutool.core.util.URLUtil;
import com.remmy.simplepaas.mapper.UmsResourceMapper;
import com.remmy.simplepaas.model.UmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author yejiaxin
 */
@Component
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static final Map<String, ConfigAttribute> configAttributeMap = new HashMap<>();
    @Autowired
    private UmsResourceMapper resourceMapper;

    @PostConstruct
    public void loadResource() {
        List<UmsResource> resources = resourceMapper.selectByExample(null);
        for (UmsResource resource : resources) {
            configAttributeMap.put(resource.getUrl(), new SecurityConfig(resource.getId() + ":" + resource.getName()));
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (configAttributeMap.isEmpty()) {
            loadResource();
        }
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        String url = ((FilterInvocation)o).getRequestUrl();
        String path = URLUtil.getPath(url);
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String pattern : configAttributeMap.keySet()) {
            if (pathMatcher.match(pattern, path)) {
                configAttributes.add(configAttributeMap.get(pattern));
            }
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
