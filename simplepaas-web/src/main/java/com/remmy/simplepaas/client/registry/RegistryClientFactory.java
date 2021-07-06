package com.remmy.simplepaas.client.registry;

import com.remmy.simplepaas.dto.RepositoryType;
import com.remmy.simplepaas.service.impl.RepositoryServiceImpl;
import com.remmy.simplepaas.service.impl.SystemParamServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejiaxin
 */
@Component
public class RegistryClientFactory {
    public final Map<RepositoryType, RegistryClient> cacheClient = new HashMap<>();

    public RegistryClientFactory(@Qualifier("clientTemplate") RestTemplate restTemplate, RepositoryServiceImpl repositoryService, ThreadPoolTaskExecutor executor, SystemParamServiceImpl systemParamService) {
        cacheClient.put(RepositoryType.V2, new RegistryClientV2Impl(restTemplate, repositoryService, executor, systemParamService));
        cacheClient.put(RepositoryType.HARBOR, new RegistryClientHarborImpl(restTemplate, repositoryService, executor, systemParamService));
    }

    public RegistryClient getClient(RepositoryType repositoryType) {
        return cacheClient.get(repositoryType);
    }
}
