package com.remmy.simplepaas.client.registry;

import com.remmy.simplepaas.dto.Image;
import com.remmy.simplepaas.dto.RepositoryStatus;
import com.remmy.simplepaas.service.impl.RepositoryServiceImpl;
import com.remmy.simplepaas.service.impl.SystemParamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RegistryClientHarborImpl implements RegistryClient {
    private final RestTemplate rTemplate;
    private final RepositoryServiceImpl registryService;
    private final ThreadPoolTaskExecutor executor;
    private final SystemParamServiceImpl systemParamService;

    public RegistryClientHarborImpl(RestTemplate rTemplate, RepositoryServiceImpl registryService, ThreadPoolTaskExecutor executor, SystemParamServiceImpl systemParamService) {
        this.rTemplate = rTemplate;
        this.registryService = registryService;
        this.executor = executor;
        this.systemParamService = systemParamService;
    }

    @Override
    public RepositoryStatus getInfo() throws Exception {
        return null;
    }

    @Override
    public List<Image> listImages() throws Exception {
        return null;
    }

    @Override
    public void deleteByTag(String name, String tag) {

    }

    @Override
    public boolean health() {
        return false;
    }
}
