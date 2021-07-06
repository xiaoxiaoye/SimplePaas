package com.remmy.simplepaas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yejiaxin
 */
@Data
@ConfigurationProperties(prefix = "search")
public class SearchConfig {
    private String[] uris;
}
