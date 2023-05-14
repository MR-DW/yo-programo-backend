
package com.portfolio.mr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyectos;
    private String descripcionProyectos;
    private String urlProyectos;
    
    //Constructores

    public Proyectos() {
    }

    public Proyectos(String nombreProyectos, String descripcionProyectos, String urlProyectos) {
        this.nombreProyectos = nombreProyectos;
        this.descripcionProyectos = descripcionProyectos;
        this.urlProyectos = urlProyectos;
    }
    
    //GyS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProyectos() {
        return nombreProyectos;
    }

    public void setNombreProyectos(String nombreProyecto) {
        this.nombreProyectos = nombreProyectos;
    }

    public String getDescripcionProyectos() {
        return descripcionProyectos;
    }

    public void setDescripcionProyectos(String descripcionProyecto) {
        this.descripcionProyectos = descripcionProyectos;
    }

    public String getUrlProyectos() {
        return urlProyectos;
    }

    public void setUrlProyectos(String urlProyecto) {
        this.urlProyectos = urlProyectos;
    }
    
}
