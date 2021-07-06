package com.remmy.simplepaas.security;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yejiaxin
 */
@ConfigurationProperties(prefix = "jwt.config")
@Data
public class JwtConfig {
    /**
     * jwt 加密key, 默认为remmy
     */
    private String key = "remmy";

    /**
     * jwt 过期时间, 默认为10分钟
     */
    private Long ttl = 60000L;
}
