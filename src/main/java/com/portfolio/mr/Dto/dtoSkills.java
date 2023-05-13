
package com.portfolio.mr.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoSkills {
    
    @NotBlank
    private String nombreSkills;
    @NotBlank
    private int porcentajeSkills;
    
    
    //Constructor

    public dtoSkills() {
    }

    public dtoSkills(String nombreSkills, int porcentajeSkills) {
        this.nombreSkills = nombreSkills;
        this.porcentajeSkills = porcentajeSkills;
    }
    
    //GyS

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
