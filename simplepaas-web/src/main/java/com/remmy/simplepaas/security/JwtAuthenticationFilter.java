package com.remmy.simplepaas.security;

import com.remmy.simplepaas.common.Status;
import com.remmy.simplepaas.dto.UserDetailImpl;
import com.remmy.simplepaas.exception.SecurityException;
import com.remmy.simplepaas.service.impl.UserDetailsServiceImpl;
import com.remmy.simplepaas.utils.JwtUtil;
import com.remmy.simplepaas.utils.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yejiaxin
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final ResponseUtil responseUtil;

    private List<AntPathRequestMatcher> matchers = new ArrayList<>();

    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsServiceImpl, ResponseUtil responseUtil, IgnoreUrlsConfig ignoreUrlsConfig) {
        this.jwtUtil = jwtUtil;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.responseUtil = responseUtil;
        for (String path : ignoreUrlsConfig.getUrls()) {
            matchers.add(new AntPathRequestMatcher(path));
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isIgnore(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 如果基于form 表单的页面认证已经成功，不要再基于jwt认证一次
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.isAuthenticated()) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        String jwt = jwtUtil.getJwtFromRequest(request);
        if (StringUtils.isNotBlank(jwt)) {
            try {
                String username = jwtUtil.getUsernameFromJwt(jwt);
                UserDetailImpl user = (UserDetailImpl) userDetailsServiceImpl.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                filterChain.doFilter(request, response);
            } catch (SecurityException e) {
                responseUtil.renderJson(response, e);
            }
        } else {
            responseUtil.renderJson(response, Status.TOKEN_EXPIRED);
        }
    }

    private boolean isIgnore(HttpServletRequest request) {
        return matchers.stream().anyMatch(matcher -> matcher.matches(request));
    }
}
