package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity;
import com.alexanderfisher.portfolio.api.models.Project;
import com.alexanderfisher.portfolio.api.models.ProjectGallery;
import com.alexanderfisher.portfolio.api.springboot.api.ProjectsApiDelegate;
import com.alexanderfisher.portfolio.api.springboot.service.EntityToModelConverter;
import com.alexanderfisher.portfolio.api.springboot.service.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectsApiDelegateImpl implements ProjectsApiDelegate {

    private final SessionFactoryProvider sessionFactoryProvider;

    public ProjectsApiDelegateImpl(SessionFactoryProvider sessionFactoryProvider) {
        this.sessionFactoryProvider = sessionFactoryProvider;
    }

    @Override
    public ResponseEntity<List<Project>> projectsGet() {
        Session session = sessionFactoryProvider.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProjectsEntity> criteriaQuery = criteriaBuilder.createQuery(ProjectsEntity.class);
        criteriaQuery.from(ProjectsEntity.class);
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
    public ResponseEntity<ProjectGallery> projectsProjectIdGalleryGet(Integer projectId) {
        Session session = sessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ProjectsEntity projectsEntity = session.get(ProjectsEntity.class, projectId);

        ProjectGallery projectGallery = EntityToModelConverter.toProjectGallery(projectsEntity);

        transaction.commit();
        session.close();

        return new ResponseEntity<>(projectGallery, HttpStatus.OK);
    }
}