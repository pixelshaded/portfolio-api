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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UsersEntity generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="portfolio"
    , uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="username")} 
)
public class UsersEntity  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String salt;
     private String password;
     private String email;
     private boolean isActive;
     private Set<RolesEntity> rolesEntities = new HashSet<RolesEntity>(0);

    public UsersEntity() {
    }

	
    public UsersEntity(String username, String salt, String password, String email, boolean isActive) {
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
    }
    public UsersEntity(String username, String salt, String password, String email, boolean isActive, Set<RolesEntity> rolesEntities) {
       this.username = username;
       this.salt = salt;
       this.password = password;
       this.email = email;
       this.isActive = isActive;
       this.rolesEntities = rolesEntities;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="username", unique=true, nullable=false, length=25)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="salt", nullable=false, length=32)
    public String getSalt() {
        return this.salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }

    
    @Column(name="password", nullable=false, length=88)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", unique=true, nullable=false, length=60)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="isActive", nullable=false)
    public boolean isIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_role", catalog="portfolio", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="role_id", nullable=false, updatable=false) })
    public Set<RolesEntity> getRolesEntities() {
        return this.rolesEntities;
    }
    
    public void setRolesEntities(Set<RolesEntity> rolesEntities) {
        this.rolesEntities = rolesEntities;
    }




}


