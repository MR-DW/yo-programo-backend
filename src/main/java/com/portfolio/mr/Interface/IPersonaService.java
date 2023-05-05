
package com.portfolio.mr.Interface;

import com.portfolio.mr.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de persona
    public List<Persona> getPersona();
    
    //Traer una persona por ID
    public Persona getPersona(Long id);
    
    //guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
