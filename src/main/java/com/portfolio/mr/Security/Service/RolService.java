
package com.portfolio.mr.Security.Service;

import com.portfolio.mr.Security.Entity.Rol;
import com.portfolio.mr.Security.Enums.RolNombre;
import com.portfolio.mr.Security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
    
    
}
