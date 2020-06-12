package com.alexanderfisher.hibernate.dto;
// Generated by Hibernate Tools 5.4.17.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name="categories"
    ,catalog="portfolio"
    , uniqueConstraints = @UniqueConstraint(columnNames="slug") 
)
public class Categories  implements java.io.Serializable {


     private Integer id;
     private String slug;
     private String title;
     private String subtitle;
     private String description;
     private Set<Projects> projectses = new HashSet<Projects>(0);

    public Categories() {
    }

	
    public Categories(String slug, String title, String subtitle, String description) {
        this.slug = slug;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }
    public Categories(String slug, String title, String subtitle, String description, Set<Projects> projectses) {
       this.slug = slug;
       this.title = title;
       this.subtitle = subtitle;
       this.description = description;
       this.projectses = projectses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="slug", unique=true, nullable=false, length=128)
    public String getSlug() {
        return this.slug;
    }
    
    public void setSlug(String slug) {
        this.slug = slug;
    }

    
    @Column(name="title", nullable=false, length=60)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="subtitle", nullable=false, length=100)
    public String getSubtitle() {
        return this.subtitle;
    }
    
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    
    @Column(name="description", nullable=false)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categories")
    public Set<Projects> getProjectses() {
        return this.projectses;
    }
    
    public void setProjectses(Set<Projects> projectses) {
        this.projectses = projectses;
    }




}


