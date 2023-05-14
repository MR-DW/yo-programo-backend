
package com.portfolio.mr.Repository;

import com.portfolio.mr.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByNombreProyectos(String nombreProyectos);
    public boolean existsByNombreProyectos(String nombreProyectos);
    
}
