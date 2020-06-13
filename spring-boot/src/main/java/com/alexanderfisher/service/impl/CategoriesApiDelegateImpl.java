package com.alexanderfisher.service.impl;

import com.alexanderfisher.api.CategoriesApiDelegate;
import com.alexanderfisher.hibernate.entities.CategoriesEntity;
import com.alexanderfisher.models.Category;
import com.alexanderfisher.models.Project;
import com.alexanderfisher.service.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        Project project = new Project();
        project.setId(1);
        project.setCategoryId(categoryId);
        project.setTitle("An example project");
        project.setSlug("an-example-project");
        project.setSubtitle("Examples for testing.");
        project.setIntro("Welcome to the example.");
        project.setTagline("I can has example?");
        project.setContent("<div>some content html dawg</div>");
        project.setSubcontent("<div>some sub content html dawg</div>");
        return new ResponseEntity<>(Arrays.asList(project), HttpStatus.OK);
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

        List<Category> categories = categoriesEntities.stream().map(dto -> {
            Category category = new Category();
            category.setId(dto.getId());
            category.setTitle(dto.getTitle());
            category.setSlug(dto.getSlug());
            category.setSubtitle(dto.getSubtitle());
            category.setDescription(dto.getDescription());
            return category;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}