package com.alexanderfisher.portfolio.api.springboot.service.impl;

import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity;
import com.alexanderfisher.portfolio.api.models.Project;
import com.alexanderfisher.portfolio.api.models.ProjectGallery;
import com.alexanderfisher.portfolio.api.springboot.api.ProjectsApiDelegate;
import com.alexanderfisher.portfolio.api.springboot.service.EntityManagerProvider;
import com.alexanderfisher.portfolio.api.springboot.service.EntityToModelConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectsApiDelegateImpl implements ProjectsApiDelegate {

    private final EntityManagerProvider entityManagerProvider;

    public ProjectsApiDelegateImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public ResponseEntity<List<Project>> getProjects() {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectsEntity> criteriaQuery = criteriaBuilder.createQuery(ProjectsEntity.class);
        criteriaQuery.from(ProjectsEntity.class);
        List<ProjectsEntity> projectsEntities = entityManager.createQuery(criteriaQuery).getResultList();

        List<Project> categories = projectsEntities.stream()
                .map(EntityToModelConverter::toProject)
                .collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectGallery> getProjectGallery(Integer projectId) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        ProjectsEntity projectsEntity = entityManager.find(ProjectsEntity.class, projectId);

        ProjectGallery projectGallery = EntityToModelConverter.toProjectGallery(projectsEntity);

        return new ResponseEntity<>(projectGallery, HttpStatus.OK);
    }
}