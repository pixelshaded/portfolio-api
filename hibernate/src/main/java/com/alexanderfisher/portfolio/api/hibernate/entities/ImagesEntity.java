package com.alexanderfisher.portfolio.api.hibernate.entities;
// Generated by Hibernate Tools 5.4.17.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ImagesEntity generated by hbm2java
 */
@Entity
@Table(name="images"
    ,catalog="portfolio"
)
public class ImagesEntity  implements java.io.Serializable {


     private Integer id;
     private GalleriesEntity galleriesEntity;
     private String filename;
     private String alt;
     private Set<GalleriesEntity> galleriesEntities = new HashSet<GalleriesEntity>(0);

    public ImagesEntity() {
    }

	
    public ImagesEntity(String filename, String alt) {
        this.filename = filename;
        this.alt = alt;
    }
    public ImagesEntity(GalleriesEntity galleriesEntity, String filename, String alt, Set<GalleriesEntity> galleriesEntities) {
       this.galleriesEntity = galleriesEntity;
       this.filename = filename;
       this.alt = alt;
       this.galleriesEntities = galleriesEntities;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gallery_id")
    public GalleriesEntity getGalleriesEntity() {
        return this.galleriesEntity;
    }
    
    public void setGalleriesEntity(GalleriesEntity galleriesEntity) {
        this.galleriesEntity = galleriesEntity;
    }

    
    @Column(name="filename", nullable=false)
    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    
    @Column(name="alt", nullable=false)
    public String getAlt() {
        return this.alt;
    }
    
    public void setAlt(String alt) {
        this.alt = alt;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="imagesEntity")
    public Set<GalleriesEntity> getGalleriesEntities() {
        return this.galleriesEntities;
    }
    
    public void setGalleriesEntities(Set<GalleriesEntity> galleriesEntities) {
        this.galleriesEntities = galleriesEntities;
    }




}


