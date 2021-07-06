package com.remmy.simplepaas;

import com.remmy.simplepaas.config.SearchConfig;
import com.remmy.simplepaas.security.IgnoreUrlsConfig;
import com.remmy.simplepaas.security.JwtConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yejiaxin
 */
@SpringBootApplication
@EnableConfigurationProperties({JwtConfig.class, IgnoreUrlsConfig.class, SearchConfig.class})
@EnableScheduling
@EnableCaching
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableDiscoveryClient
public class SimplepaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplepaasApplication.class, args);
    }
}
