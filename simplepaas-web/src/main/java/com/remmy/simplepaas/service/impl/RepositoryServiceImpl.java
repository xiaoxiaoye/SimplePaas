package com.remmy.simplepaas.service.impl;

import com.remmy.simplepaas.model.Repository;
import com.remmy.simplepaas.model.RepositoryExample;
import com.remmy.simplepaas.mapper.RepositoryMapper;
import com.remmy.simplepaas.service.RepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yejiaxin
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {
    private final RepositoryMapper repositoryMapper;

    public RepositoryServiceImpl(RepositoryMapper repositoryMapper) {
        this.repositoryMapper = repositoryMapper;
    }

    @Override
    public List<Repository> listRepository() {
        return repositoryMapper.selectByExample(null);
    }

    @Override
    public List<Repository> getRepositoryByName(String name) {
        RepositoryExample cond = new RepositoryExample();
        cond.or().andNameEqualTo(name);

        return repositoryMapper.selectByExample(cond);
    }
}
