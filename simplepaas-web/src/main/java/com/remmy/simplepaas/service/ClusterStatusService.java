package com.remmy.simplepaas.service;

import com.remmy.simplepaas.dto.ClusterStatus;

/**
 * @author yejiaxin
 */
public interface ClusterStatusService {
    /**
     * 获取集群状态
     * @return 集群状态
     * @throws Exception
     */
    ClusterStatus getClusterStatus() throws Exception;
}
