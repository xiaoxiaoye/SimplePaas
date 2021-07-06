package com.remmy.simplepaas.search.repository;

import com.remmy.simplepaas.search.domain.EsApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yejiaxin
 */
public interface EsApplicationRepository extends ElasticsearchRepository<EsApplication, Long> {
    /**
     * 模糊搜索
     * @param name 应用名称
     * @param command 启动命令
     * @param image 镜像
     * @param page 分页
     * @return 应用列表
     */
    Page<EsApplication> findByNameContainsOrCommandContainsOrImageContains(String name, String command, String image, Pageable page);
}
