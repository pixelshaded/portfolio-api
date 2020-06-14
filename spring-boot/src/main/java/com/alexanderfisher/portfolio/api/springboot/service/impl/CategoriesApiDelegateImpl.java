package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity_;
import com.alexanderfisher.portfolio.api.springboot.api.CategoriesApiDelegate;
import com.alexanderfisher.portfolio.api.hibernate.entities.CategoriesEntity;
import com.alexanderfisher.portfolio.api.models.Category;
import com.alexanderfisher.portfolio.api.models.Project;
import com.alexanderfisher.portfolio.api.springboot.service.EntityManagerProvider;
import com.alexanderfisher.portfolio.api.springboot.service.EntityToModelConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesApiDelegateImpl implements CategoriesApiDelegate {

    private final EntityManagerProvider entityManagerFactoryProvider;

    public CategoriesApiDelegateImpl(EntityManagerProvider entityManagerFactoryProvider) {
        this.entityManagerFactoryProvider = entityManagerFactoryProvider;
    }

    @Override
    public ResponseEntity<List<Project>> getCategoryProjects(Integer categoryId) {
        EntityManager entityManager = entityManagerFactoryProvider.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectsEntity> criteriaQuery = criteriaBuilder.createQuery(ProjectsEntity.class);
        Root<ProjectsEntity> root = criteriaQuery.from(ProjectsEntity.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(ProjectsEntity_.categoriesEntity), categoryId));
        List<ProjectsEntity> projectsEntities = entityManager.createQuery(criteriaQuery).getResultList();

        List<Project> categories = projectsEntities.stream()
            .map(EntityToModelConverter::toProject)
            .collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        EntityManager entityManager = entityManagerFactoryProvider.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoriesEntity> criteriaQuery = criteriaBuilder.createQuery(CategoriesEntity.class);
        criteriaQuery.from(CategoriesEntity.class);
        List<CategoriesEntity> categoriesEntities = entityManager.createQuery(criteriaQuery).getResultList();

        List<Category> categories = categoriesEntities.stream()
            .map(EntityToModelConverter::toCategory)
            .collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}