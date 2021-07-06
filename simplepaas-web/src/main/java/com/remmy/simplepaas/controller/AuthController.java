package com.remmy.simplepaas.controller;

import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yejiaxin
 */
@Api(tags = "用户认证",  description = "用户认证")
@RestController()
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/token")
    @ApiOperation(value = "获取token", notes = "基于JWT 根据用户名/密码创建token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "admin"),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123456"),
    })
    public RespBean createToken(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createJwt(authentication);
        return RespBean.ok("success", "Bearer " + jwt);
    }
}
