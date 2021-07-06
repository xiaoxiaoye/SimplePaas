package com.remmy.simplepaas.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationDefineExample;
import com.remmy.simplepaas.model.ApplicationStatus;
import com.remmy.simplepaas.model.ApplicationStatusExample;
import com.remmy.simplepaas.client.kubernetes.KubeController;
import com.remmy.simplepaas.common.Status;
import com.remmy.simplepaas.exception.BaseException;
import com.remmy.simplepaas.mapper.ApplicationDefineMapper;
import com.remmy.simplepaas.mapper.ApplicationStatusMapper;
import com.remmy.simplepaas.service.ApplicationSearchService;
import com.remmy.simplepaas.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yejiaxin
 */
@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {
    private final KubeController kubeController;
    private final ApplicationDefineMapper applicationDefineMapper;
    private final ApplicationStatusMapper statusMapper;

    @Autowired
    private ApplicationSearchService searchService;

    public ApplicationServiceImpl(ApplicationDefineMapper applicationDefineMapper,
                              KubeController kubeController, ApplicationStatusMapper statusMapper) {
        this.applicationDefineMapper = applicationDefineMapper;
        this.kubeController = kubeController;
        this.statusMapper = statusMapper;
    }

    /**
     * 创建或更新应用配置
     *
     * @param app 应用定义
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "application", key = "#app.id", beforeInvocation = true)
    @Override
    public void applyApplication(ApplicationDefine app) {
        app.setCreateTime(new Date());
        if (app.getId() == null) {
            applicationDefineMapper.insert(app);
            return;
        }
        ApplicationDefineExample cond = new ApplicationDefineExample();
        cond.or().andIdEqualTo(app.getId());
        List<ApplicationDefine> applicationList = applicationDefineMapper.selectByExample(cond);
        if (applicationList.size() == 0) {
            applicationDefineMapper.insert(app);
            return;
        }
        applicationDefineMapper.updateByExample(app, cond);
        searchService.create(app.getId());
    }

    /**
     * 删除应用
     *
     * @param appId 应用id
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CacheEvict("application")
    @Override
    public void deleteApplication(int appId) {
        ApplicationDefineExample cond = new ApplicationDefineExample();
        cond.or().andIdEqualTo(appId);

        applicationDefineMapper.deleteByExample(cond);
        searchService.delete(appId);
    }

    /**
     * 获取应用状态
     *
     * @param appId 应用id
     */
    @Override
    public ApplicationStatus getApplicationStatus(int appId) throws Exception {
        ApplicationDefine app = getApplication(appId);
        if (app == null) {
            return null;
        }

        return kubeController.status(app);
    }

    /**
     * 获取应用列表
     *
     * @return 应用列表
     */
    @Override
    public List<ApplicationDefine> listApplication() {
        return applicationDefineMapper.selectByExample(null);
    }

    /**
     * 获取应用分页列表
     *
     * @param pageNum  分页序号
     * @param pageSize 分页大小
     * @return 应用分页列表
     */
    @Override
    public PageInfo<ApplicationDefine> listApplicationPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationDefine> apps = applicationDefineMapper.selectByExample(null);
        return new PageInfo<>(apps);
    }

    /**
     * 查询应用定义
     *
     * @param appId 应用id
     * @return 应用配置详情
     */
    @Cacheable("application")
    @Override
    public ApplicationDefine getApplication(int appId) {
        ApplicationDefineExample cond = new ApplicationDefineExample();
        cond.or().andIdEqualTo(appId);
        List<ApplicationDefine> apps = applicationDefineMapper.selectByExample(cond);
        if (apps.size() == 0) {
            throw new BaseException(Status.APP_NOT_FOUND);
        }
        return apps.get(0);
    }

    /**
     * 应用发布
     *
     * @param appId 应用id
     * @throws Exception
     */
    @Override
    public void publishApplication(int appId, int target) throws Exception {
        ApplicationDefine app = getApplication(appId);
        if (app.getTarget() != target) {
            app.setTarget(target);
            applyApplication(app);
        }
        kubeController.apply(app);
    }

    /**
     * 应用下线
     *
     * @param appId
     * @throws Exception
     */
    @Override
    public void offlineApplication(int appId) throws Exception {
        ApplicationDefine app = getApplication(appId);
        app.setTarget(0);
        applyApplication(app);
        kubeController.delete(app);
    }

    /**
     * 更新应用状态
     */
    @Override
    public void updateApplicationStatus() throws Exception {
        List<ApplicationDefine> applicationDefineList = applicationDefineMapper.selectByExample(null);

        int threadNum = Math.min(applicationDefineList.size(), 20);
        int queueLimit = Math.min(applicationDefineList.size(), 200);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadNum, threadNum, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueLimit), new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(Thread.currentThread().getThreadGroup(), r,
                        "application-status-" + threadNumber.getAndIncrement(),
                        0);
            }
        });
        List<Future> results = new LinkedList<>();
        for (ApplicationDefine app : applicationDefineList) {
            Future result = threadPoolExecutor.submit(() -> {
                try {
                    ApplicationStatus status = kubeController.status(app);
                    ApplicationStatusExample cond = new ApplicationStatusExample();
                    cond.or().andAppIdEqualTo(app.getId());
                    statusMapper.updateByExample(status, cond);
                } catch (Exception e) {
                    log.error("update app[{}]'s status failed!", app.getId(), e);
                }
            });
            results.add(result);
        }
        for (Future future : results) {
            future.get();
        }
        threadPoolExecutor.shutdownNow();
    }
}
