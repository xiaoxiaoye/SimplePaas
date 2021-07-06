package com.remmy.simplepaas.utils;

import com.remmy.simplepaas.common.Status;
import com.remmy.simplepaas.security.JwtConfig;
import com.remmy.simplepaas.exception.SecurityException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yejiaxin
 */
@Slf4j
@Component
public class JwtUtil {
    private final String JWT_KEY;
    private final long JWT_TTL;


    private final StringRedisTemplate redisTemplate;

    public JwtUtil(JwtConfig config, StringRedisTemplate redisTemplate) {
        JWT_KEY = config.getKey();
        JWT_TTL = config.getTtl();
        this.redisTemplate = redisTemplate;
    }

    public String createJwt(Authentication authentication) {
        Date now = new Date();
        Date expiration = new Date(System.currentTimeMillis() + JWT_TTL);
        UserDetails user = (UserDetails) authentication.getPrincipal();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, JWT_KEY)
                .claim("authorities", user.getAuthorities());
        String jwt = jwtBuilder.compact();
        redisTemplate.opsForValue().set("security:jwt:" + user.getUsername(), jwt, JWT_TTL, TimeUnit.MILLISECONDS);
        return jwt;
    }

    public String getJwtFromRequest(HttpServletRequest request) {
        String bearToken = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(bearToken) && bearToken.startsWith("Bearer ")) {
            return bearToken.substring(7);
        }
        return null;
    }

    public Claims parseJwt(String jwt) {
            try {
                Claims claims = Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(jwt).getBody();
                String redisKey = "security:jwt:"+claims.getSubject();
                Long expire = redisTemplate.getExpire(redisKey);
                if (Objects.isNull(expire) || expire <= 0) {
                    throw new SecurityException(Status.TOKEN_EXPIRED);
                }
                return claims;
            } catch (ExpiredJwtException e) {
                log.error("token 证书已失效");
                throw new SecurityException(Status.TOKEN_EXPIRED);
            } catch (UnsupportedJwtException e) {
                log.error("不支持的token");
                throw new SecurityException(Status.TOKEN_PARSE_ERROR);
            }
//        throw new SecurityException(Status.TOKEN_EXPIRED);
    }

    public String getUsernameFromJwt(String jwt) {
        Claims claims = parseJwt(jwt);
        return claims.getSubject();
    }
}
