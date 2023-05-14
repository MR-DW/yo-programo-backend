
package com.portfolio.mr.Controller;

import com.portfolio.mr.Dto.dtoProyectos;
import com.portfolio.mr.Entity.Proyectos;
import com.portfolio.mr.Security.Controller.Mensaje;
import com.portfolio.mr.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins= {"http://localhost:4200",}, allowedHeaders = "*")
public class CProyectos {
    
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list= sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
            
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyectos eliminada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombreProyectos())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getDescripcionProyectos())){
            return new ResponseEntity(new Mensaje("La Descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(sProyectos.existsByNombreProyectos(dtoproyectos.getNombreProyectos())){
            return new ResponseEntity(new Mensaje ("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = new Proyectos(
        //Proyectos proyectos = new Proyectos(
                dtoproyectos.getNombreProyectos(), dtoproyectos.getDescripcionProyectos() , dtoproyectos.getUrlProyectos()
        );

        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyectos creada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No ixiste el id"), HttpStatus.NOT_FOUND);
           
        }
        if(sProyectos.existsByNombreProyectos(dtoproyectos.getNombreProyectos()) && sProyectos.getByNombreProyectos(dtoproyectos.getNombreProyectos()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyectos.getNombreProyectos())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getUrlProyectos())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getDescripcionProyectos())){
            return new ResponseEntity(new Mensaje("La Descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        
        proyectos.setNombreProyectos(dtoproyectos.getNombreProyectos());
        proyectos.setDescripcionProyectos(dtoproyectos.getDescripcionProyectos());
        
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyectos Actualizada"), HttpStatus.OK);
    }
    
}
