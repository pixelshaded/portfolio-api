package com.alexanderfisher.impl;

import com.alexanderfisher.api.CategoriesApiDelegate;
import com.alexanderfisher.models.Category;
import com.alexanderfisher.models.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoriesApiDelegateImpl implements CategoriesApiDelegate {

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
        Category category = new Category();
        category.setId(1);
        category.setTitle("Examples");
        category.setSlug("examples");
        category.setSubtitle("Examples for samples.");
        category.setDescription("So we can test all the things.");
        return new ResponseEntity<>(Arrays.asList(category), HttpStatus.OK);
    }
}