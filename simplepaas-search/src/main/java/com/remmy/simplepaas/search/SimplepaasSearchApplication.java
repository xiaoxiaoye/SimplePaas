package com.remmy.simplepaas.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yejiaxin
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SimplepaasSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplepaasSearchApplication.class, args);
    }

}
