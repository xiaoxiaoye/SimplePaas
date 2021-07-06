package com.remmy.simplepaas.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author yejiaxin
 */
@Configuration
public class CommonConfig {

    @Bean
    @LoadBalanced
    @Primary
    public RestTemplate template() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier("clientTemplate")
    public RestTemplate clientTemplate() {
        return new RestTemplate();
    }
}
