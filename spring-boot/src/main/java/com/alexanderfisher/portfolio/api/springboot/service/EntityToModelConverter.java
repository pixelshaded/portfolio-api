package com.alexanderfisher.portfolio.api.springboot.service;

import com.alexanderfisher.portfolio.api.hibernate.entities.CategoriesEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.GalleriesEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.ImagesEntity;
import com.alexanderfisher.portfolio.api.hibernate.entities.ProjectsEntity;
import com.alexanderfisher.portfolio.api.models.*;

import java.util.stream.Collectors;

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

    public static Gallery toGallery(GalleriesEntity galleriesEntity) {
        Gallery gallery = new Gallery();
        gallery.setId(galleriesEntity.getId());
        if (galleriesEntity.getImagesEntity() != null) {
            gallery.setCoverId(galleriesEntity.getImagesEntity().getId());
        }
        gallery.setTitle(galleriesEntity.getTitle());
        gallery.setSlug(galleriesEntity.getSlug());
        return gallery;
    }

    public static Image toImage(ImagesEntity imagesEntity) {
        Image image = new Image();
        image.setId(imagesEntity.getId());
        image.setGalleryId(imagesEntity.getGalleriesEntity().getId());
        image.setAlt(imagesEntity.getAlt());
        image.setFilename(imagesEntity.getFilename());
        return image;
    }

    public static ProjectGallery toProjectGallery(ProjectsEntity projectEntity) {
        ProjectGallery projectGallery = new ProjectGallery();
        projectGallery.setGallery(toGallery(projectEntity.getGalleriesEntity()));
        projectGallery.setImages(projectEntity
            .getGalleriesEntity()
            .getImagesEntities()
            .stream()
            .map(EntityToModelConverter::toImage)
            .collect(Collectors.toList())
        );
        return projectGallery;
    }
}
