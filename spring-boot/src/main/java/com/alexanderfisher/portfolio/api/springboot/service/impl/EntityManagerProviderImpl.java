package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.springboot.service.EntityManagerProvider;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
public class EntityManagerProviderImpl implements EntityManagerProvider {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public EntityManagerProviderImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("portfolio-api");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
