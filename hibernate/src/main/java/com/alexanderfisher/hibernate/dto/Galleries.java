package com.alexanderfisher.hibernate.dto;
// Generated by Hibernate Tools 5.4.17.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Galleries generated by hbm2java
 */
public class Galleries  implements java.io.Serializable {


     private Integer id;
     private Images images;
     private String title;
     private String slug;
     private Set projectses = new HashSet(0);
     private Set imageses = new HashSet(0);

    public Galleries() {
    }

	
    public Galleries(String title, String slug) {
        this.title = title;
        this.slug = slug;
    }
    public Galleries(Images images, String title, String slug, Set projectses, Set imageses) {
       this.images = images;
       this.title = title;
       this.slug = slug;
       this.projectses = projectses;
       this.imageses = imageses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Images getImages() {
        return this.images;
    }
    
    public void setImages(Images images) {
        this.images = images;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSlug() {
        return this.slug;
    }
    
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public Set getProjectses() {
        return this.projectses;
    }
    
    public void setProjectses(Set projectses) {
        this.projectses = projectses;
    }
    public Set getImageses() {
        return this.imageses;
    }
    
    public void setImageses(Set imageses) {
        this.imageses = imageses;
    }




}

