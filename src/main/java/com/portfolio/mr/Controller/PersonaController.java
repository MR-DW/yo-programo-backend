
package com.portfolio.mr.Controller;

import com.portfolio.mr.Entity.Persona;
import com.portfolio.mr.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @GetMapping("/traer/{id}")
    public Persona getPersonaById(@PathVariable Long id){
        return ipersonaService.getPersona(id);
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    //URL:PUERTO/personas/editar/4/nombre&apellido&img
    @PutMapping("/editar/{id}")
    public Persona editPersona(
            @PathVariable Long id, 
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("imagen") String nuevaImg,
            @RequestParam("profesion") String nuevaProfesion,
            @RequestParam("edad") String nuevaEdad){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        persona.setImg(nuevaProfesion);
        persona.setImg(nuevaEdad);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
}
