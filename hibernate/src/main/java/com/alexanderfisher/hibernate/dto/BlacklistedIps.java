package com.alexanderfisher.hibernate.dto;
// Generated by Hibernate Tools 5.4.17.Final



/**
 * BlacklistedIps generated by hbm2java
 */
public class BlacklistedIps  implements java.io.Serializable {


     private Integer id;
     private String address;
     private int attempts;

    public BlacklistedIps() {
    }

    public BlacklistedIps(String address, int attempts) {
       this.address = address;
       this.attempts = attempts;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAttempts() {
        return this.attempts;
    }
    
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }




}

