
package com.portfolio.mr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String descripcionExp;
    
    //Constructor 

    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripExp;
    }
    
    //GyS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripExp() {
        return descripcionExp;
    }

    public void setDescripExp(String descripExp) {
        this.descripcionExp = descripExp;
    }
    
    
    
}
