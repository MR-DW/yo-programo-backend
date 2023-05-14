
package com.portfolio.mr.Service;

import com.portfolio.mr.Entity.Proyectos;
import com.portfolio.mr.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SProyectos {
    
    @Autowired
    RProyectos rProyectos;
    
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyectos(String nombreProyectos){
        return rProyectos.findByNombreProyectos(nombreProyectos);
    }
    
    public void save(Proyectos proyectos){
        rProyectos.save(proyectos);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existsByNombreProyectos(String nombreProyectos){
        return rProyectos.existsByNombreProyectos(nombreProyectos);
    }
}
