package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.springboot.service.AppConfigProvider;
import com.alexanderfisher.portfolio.api.springboot.service.EntityManagerProvider;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntityManagerProviderImpl implements EntityManagerProvider {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public EntityManagerProviderImpl(AppConfigProvider appConfigProvider) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("javax.persistence.jdbc.url", appConfigProvider.getDatabaseUrl());
        map.put("javax.persistence.jdbc.user", appConfigProvider.getDatabaseUser());
        map.put("javax.persistence.jdbc.password", appConfigProvider.getDatabasePassword());

        entityManagerFactory = Persistence.createEntityManagerFactory("portfolio-api", map);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
