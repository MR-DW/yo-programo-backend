
package com.portfolio.mr.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoProyectos {
    
    @NotBlank
    private String nombreProyectos;
    @NotBlank
    private String descripcionProyectos;
    @NotBlank
    private String urlProyectos;
    
    //Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreProyectos, String descripcionProyectos, String urlProyectos) {
        this.nombreProyectos = nombreProyectos;
        this.descripcionProyectos = descripcionProyectos;
        this.urlProyectos = urlProyectos;
    }
    
    //GyS

    public String getNombreProyectos() {
        return nombreProyectos;
    }

    public void setNombreProyectos(String nombreProyectos) {
        this.nombreProyectos = nombreProyectos;
    }

    public String getDescripcionProyectos() {
        return descripcionProyectos;
    }

    public void setDescripcionProyectos(String descripcionProyectos) {
        this.descripcionProyectos = descripcionProyectos;
    }

    public String getUrlProyectos() {
        return urlProyectos;
    }

    public void setUrlProyectos(String urlProyectos) {
        this.urlProyectos = urlProyectos;
    }
    
    
}
