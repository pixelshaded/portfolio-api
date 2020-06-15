package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.springboot.service.EntityManagerProvider;
import com.alexanderfisher.portfolio.api.springboot.service.EnvironmentConstants;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntityManagerProviderImpl implements EntityManagerProvider {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public EntityManagerProviderImpl() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("javax.persistence.jdbc.url", EnvironmentConstants.getRequiredEnvironmentVariable(EnvironmentConstants.DATABASE_URL));
        map.put("javax.persistence.jdbc.user", EnvironmentConstants.getRequiredEnvironmentVariable(EnvironmentConstants.DATABASE_USER));
        map.put("javax.persistence.jdbc.password", EnvironmentConstants.getRequiredEnvironmentVariable(EnvironmentConstants.DATABASE_PASSWORD));

        entityManagerFactory = Persistence.createEntityManagerFactory("portfolio-api", map);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
