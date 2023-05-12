
package com.portfolio.mr.Repository;

import com.portfolio.mr.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByNombreEdu(String nombreE);
    public boolean existsByNombreEdu(String nombreEdu);
    
}
