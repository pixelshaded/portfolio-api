package com.alexanderfisher.hibernate.entities;
// Generated by Hibernate Tools 5.4.17.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BlacklistedIpsEntity generated by hbm2java
 */
@Entity
@Table(name="blacklisted_ips"
    ,catalog="portfolio"
)
public class BlacklistedIpsEntity  implements java.io.Serializable {


     private Integer id;
     private String address;
     private int attempts;

    public BlacklistedIpsEntity() {
    }

    public BlacklistedIpsEntity(String address, int attempts) {
       this.address = address;
       this.attempts = attempts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="address", nullable=false)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="attempts", nullable=false)
    public int getAttempts() {
        return this.attempts;
    }
    
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }




}

