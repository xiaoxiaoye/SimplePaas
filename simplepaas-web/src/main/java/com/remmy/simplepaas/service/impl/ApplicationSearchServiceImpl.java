package com.remmy.simplepaas.service.impl;

import cn.hutool.core.util.URLUtil;
import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.service.ApplicationSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author yejiaxin
 */
@Service
public class ApplicationSearchServiceImpl implements ApplicationSearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationSearchServiceImpl.class);

    private static final String SEARCH_PATH = "/application/search";
    private static final String CREATE_PATH = "/application/create";
    private static final String DELETE_PATH = "/application/delete";

    @Value("${search.url}")
    private String url;

    private final RestTemplate restTemplate;

    public ApplicationSearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RespBean search(String keyword) {
        String actionUrl = URLUtil.completeUrl(url, SEARCH_PATH);
        actionUrl += "?keyword="+keyword;
        LOGGER.info("search app from {}", actionUrl);
        RespBean resp = restTemplate.getForObject(actionUrl, RespBean.class);
        return resp;
    }

    @Override
    public void create(Integer id) {
        String actionUrl = URLUtil.completeUrl(url, CREATE_PATH);
        actionUrl += "?id="+id;
        restTemplate.postForObject(actionUrl, null, RespBean.class);
    }

    @Override
    public void delete(Integer id) {
        String actionUrl = URLUtil.completeUrl(url, DELETE_PATH);
        actionUrl += "?id="+id;
        restTemplate.delete(actionUrl);
    }
}
