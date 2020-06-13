package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity_;
import com.alexanderfisher.portfolio.api.springboot.api.CategoriesApiDelegate;
import com.alexanderfisher.portfolio.api.hibernate.entities.CategoriesEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.CategoriesEntity_;
import com.alexanderfisher.portfolio.api.models.Category;
import com.alexanderfisher.portfolio.api.models.Project;
import com.alexanderfisher.portfolio.api.springboot.service.EntityToModelConverter;
import com.alexanderfisher.portfolio.api.springboot.service.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesApiDelegateImpl implements CategoriesApiDelegate {

    private final SessionFactoryProvider sessionFactoryProvider;

    public CategoriesApiDelegateImpl(SessionFactoryProvider sessionFactoryProvider) {
        this.sessionFactoryProvider = sessionFactoryProvider;
    }

    @Override
    public ResponseEntity<List<Project>> categoriesCategoryIdProjectsGet(Integer categoryId) {
        Session session = sessionFactoryProvider.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProjectsEntity> criteriaQuery = criteriaBuilder.createQuery(ProjectsEntity.class);
        Root<ProjectsEntity> root = criteriaQuery.from(ProjectsEntity.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(ProjectsEntity_.categoriesEntity), categoryId));
        Transaction transaction = session.beginTransaction();
        List<ProjectsEntity> projectsEntities = session.createQuery(criteriaQuery).getResultList();
        transaction.commit();
        session.close();

        List<Project> categories = projectsEntities.stream()
                .map(EntityToModelConverter::toProject)
                .collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Category>> categoriesGet() {
        Session session = sessionFactoryProvider.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CategoriesEntity> criteriaQuery = criteriaBuilder.createQuery(CategoriesEntity.class);
        criteriaQuery.from(CategoriesEntity.class);
        Transaction transaction = session.beginTransaction();
        List<CategoriesEntity> categoriesEntities = session.createQuery(criteriaQuery).getResultList();
        transaction.commit();
        session.close();

        List<Category> categories = categoriesEntities.stream()
            .map(EntityToModelConverter::toCategory)
            .collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}