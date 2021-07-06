package com.remmy.simplepaas.search.service.impl;

import com.remmy.simplepaas.search.dao.EsApplicationDao;
import com.remmy.simplepaas.search.domain.EsApplication;
import com.remmy.simplepaas.search.repository.EsApplicationRepository;
import com.remmy.simplepaas.search.service.EsApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author yejiaxin
 */

@Service
public class EsApplicationServiceImpl implements EsApplicationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsApplicationServiceImpl.class);

    private final EsApplicationRepository esApplicationRepository;

    private final EsApplicationDao esApplicationDao;

    public EsApplicationServiceImpl(EsApplicationRepository esApplicationRepository, EsApplicationDao esApplicationDao) {
        this.esApplicationRepository = esApplicationRepository;
        this.esApplicationDao = esApplicationDao;
    }

    @Override
    public int importAll() {
        List<EsApplication> esApplications = esApplicationDao.listAllEsApplication(null);
        Iterator<EsApplication> iterator = esApplicationRepository.saveAll(esApplications).iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    @Override
    public List<EsApplication> search(String keyword) {
        LOGGER.info("search by keyword {}", keyword);
        return esApplicationRepository.findByNameContainsOrCommandContainsOrImageContains(keyword, keyword, keyword, null).getContent();
    }

    @Override
    public EsApplication create(Long id) {
        List<EsApplication> apps = esApplicationDao.listAllEsApplication(id);
        if (!apps.isEmpty()) {
            esApplicationRepository.save(apps.get(0));
        }
        return apps.get(0);
    }

    @Override
    public void delete(Long id) {
        esApplicationRepository.deleteById(id);
    }
}
