package com.alexanderfisher.portfolio.api.springboot.service;

import javax.persistence.EntityManager;

public interface EntityManagerProvider {
    EntityManager getEntityManager();
}