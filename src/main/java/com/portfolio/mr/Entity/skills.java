
package com.portfolio.mr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreSkills;
    private int porcentajeSkills;
    
            //Constructor

    public skills() {
    }

    public skills(String nombreSkills, int porcentajeSkills) {
        this.nombreSkills = nombreSkills;
        this.porcentajeSkills = porcentajeSkills;
    }
    
    //GyS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSkills() {
        return nombreSkills;
    }

    public void setNombreSkills(String nombreSkills) {
        this.nombreSkills = nombreSkills;
    }

    public int getPorcentajeSkills() {
        return porcentajeSkills;
    }

    public void setPorcentajeSkills(int porcentajeSkills) {
        this.porcentajeSkills = porcentajeSkills;
    }
    
    
}
