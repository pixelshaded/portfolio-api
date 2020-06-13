package com.alexanderfisher.portfolio.api.springboot.service;

import org.hibernate.SessionFactory;

public interface SessionFactoryProvider {
    SessionFactory getSessionFactory();
}