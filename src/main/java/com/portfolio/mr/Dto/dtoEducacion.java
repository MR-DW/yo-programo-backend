
package com.portfolio.mr.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {
    
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEd;
    
    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String descripcionEd) {
        this.nombreEdu = nombreEdu;
        this.descripcionEd = descripcionEd;
    }
    
    //GyS

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }
    
    
}
