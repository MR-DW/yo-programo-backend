package com.portfolio.mr.Controller;

import com.portfolio.mr.Dto.dtoSkills;
import com.portfolio.mr.Entity.skills;
import com.portfolio.mr.Security.Controller.Mensaje;
import com.portfolio.mr.Service.SSkills;
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
@CrossOrigin(origins = {"http://localhost:4200", }, allowedHeaders = "*")
@RequestMapping("/skills")
public class CSkills {

    @Autowired
    SSkills sSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<skills>> list() {
        List<skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills) {
        if (StringUtils.isBlank(dtoskills.getNombreSkills())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existsByNombreSkills(dtoskills.getNombreSkills())) {
            return new ResponseEntity(new Mensaje("Esa nombre Skills existe"), HttpStatus.BAD_REQUEST);
        }
        skills varskills = new skills(dtoskills.getNombreSkills(), dtoskills.getPorcentajeSkills());
        sSkills.save(varskills);

        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole ('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        }
        skills varskill = sSkills.getOne(id).get();
        return new ResponseEntity(varskill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole ('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills) {
        //Validamos si existe el id
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de habilidades
        if (sSkills.existsByNombreSkills(dtoskills.getNombreSkills()) && sSkills.getByNombreSkills(dtoskills.getNombreSkills()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skills ya existe"), HttpStatus.BAD_REQUEST);
        }

        //Campo no puede estar vacío
        if (StringUtils.isBlank(dtoskills.getNombreSkills())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
 

        //setea nombre y porcentaje
        skills varskills = sSkills.getOne(id).get();
        varskills.setNombreSkills(dtoskills.getNombreSkills());
        varskills.setPorcentajeSkills(dtoskills.getPorcentajeSkills());

        sSkills.save(varskills);

        return new ResponseEntity(new Mensaje("Skills actualizada"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        sSkills.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

}
