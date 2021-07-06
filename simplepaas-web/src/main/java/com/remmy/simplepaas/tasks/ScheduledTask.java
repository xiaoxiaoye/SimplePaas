package com.remmy.simplepaas.tasks;

import com.remmy.simplepaas.client.kubernetes.KubeClient;
import com.remmy.simplepaas.service.ApplicationService;
import com.remmy.simplepaas.service.ImageCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yejiaxin
 */
@Component
public class ScheduledTask {
    @Autowired
    private KubeClient kubeClient;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ImageCacheService cacheService;


    //    @Scheduled(fixedRate = 2000)
    public void updateApplicationStatus() throws Exception {
        applicationService.updateApplicationStatus();
    }

//    @Scheduled(fixedRate = 2000)
    public void refreshImageCache() {
        cacheService.refreshCache();
    }
}
