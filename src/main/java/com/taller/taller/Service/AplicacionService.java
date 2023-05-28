package com.taller.taller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taller.taller.Model.Aplicacion;
import com.taller.taller.Repository.AplicacionRepository;

@Service
public class AplicacionService {
    
    @Autowired
    private AplicacionRepository aplicacionRepository;

    public void add(Aplicacion nuevo) {
        aplicacionRepository.save(nuevo);
    }

    public List<Aplicacion> getAll() {
        return aplicacionRepository.findAll();
    }

    public Aplicacion getById(Integer id) {
        return aplicacionRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    
    public void edit(Aplicacion editado) {
        aplicacionRepository.findById(editado.getId()).orElseThrow(RuntimeException::new);
        aplicacionRepository.save(editado);
    }

    public ResponseEntity delete(Integer id) {
        aplicacionRepository.findById(id).orElseThrow(RuntimeException::new);
        aplicacionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Método del primer inciso
    public List<Aplicacion> getAllByName(Specification<Aplicacion> busqueda) {
        /*
         * El specification devuelve la ID de las aplicaciones cuyas ID del servidor se encuentren dentro del
         * subquery. Se usa el método findAll con la búsqueda para que tenga en cuenta que necesita la lista de
         * las ID de este filtro y se devuelve dicha lista.
         */
        List<Aplicacion> aplicaciones = aplicacionRepository.findAll(busqueda);
        return aplicaciones;
    }

    public List<Aplicacion> obtenerSegundoInciso(Specification<Aplicacion> busqueda) {
        List<Aplicacion> aplicacions = aplicacionRepository.findAll(busqueda);
        return aplicacions;
    }
}
