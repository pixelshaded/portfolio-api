package com.alexanderfisher.portfolio.api.springboot.service;

import com.alexanderfisher.portfolio.api.hibernate.entities.CategoriesEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity;
import com.alexanderfisher.portfolio.api.models.Category;
import com.alexanderfisher.portfolio.api.models.Project;

public class EntityToModelConverter {
    public static Category toCategory(CategoriesEntity categoriesEntity) {
        Category category = new Category();
        category.setId(categoriesEntity.getId());
        category.setTitle(categoriesEntity.getTitle());
        category.setSlug(categoriesEntity.getSlug());
        category.setSubtitle(categoriesEntity.getSubtitle());
        category.setDescription(categoriesEntity.getDescription());
        return category;
    }

    public static Project toProject(ProjectsEntity projectsEntity) {
        Project project = new Project();
        project.setId(projectsEntity.getId());
        project.setCategoryId(projectsEntity.getCategoriesEntity().getId());
        project.setTitle(projectsEntity.getTitle());
        project.setSlug(projectsEntity.getSlug());
        project.setSubtitle(projectsEntity.getSubtitle());
        project.setIntro(projectsEntity.getIntro());
        project.setContent(projectsEntity.getContent());
        project.setSubcontent(projectsEntity.getSubcontent());
        project.setTagline(projectsEntity.getTagline());
        return project;
    }
}
