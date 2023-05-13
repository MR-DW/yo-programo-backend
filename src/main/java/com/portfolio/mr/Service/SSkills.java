
package com.portfolio.mr.Service;

import com.portfolio.mr.Entity.skills;
import com.portfolio.mr.Repository.RSkills;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
    
    @Autowired
    RSkills rSkills;
    
    public List<skills> list(){
        return rSkills.findAll();
    }
    
    public Optional<skills> getOne(int id){
        return rSkills.findById(id);
    }
    
    public Optional<skills> getByNombreSkills(String nombreSkills){
        return rSkills.findByNombreSkills(nombreSkills);
    }
    
    public void save(skills skill){
        rSkills.save(skill);
    }
    
    public void delete(int id){
        rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }
    
    public boolean existsByNombreSkills(String nombreSkills){
        return rSkills.existsByNombreSkills(nombreSkills);
    }
    
}
