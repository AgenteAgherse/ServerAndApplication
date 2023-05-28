package com.taller.taller.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.taller.Model.Aplicacion;
import com.taller.taller.Service.AplicacionService;
import com.taller.taller.Service.Specify.ApplicationSpecify;


@RestController
@RequestMapping("servidor/aplicacion")
public class AplicacionController {

    @Autowired
    private AplicacionService AplicacionService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Aplicacion> getAll() {
        List<Aplicacion> datos =  AplicacionService.getAll();
        return datos;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aplicacion getApplication(@PathVariable Integer id) {
        Aplicacion data = AplicacionService.getById(id);
        return data;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postApplication(@RequestBody Aplicacion Aplicacion) throws URISyntaxException {
        AplicacionService.add(Aplicacion);
        return ResponseEntity.created(new URI("/Aplicacion/" + Aplicacion.getId())).body(Aplicacion);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putApplication(@PathVariable Integer id, @RequestBody Aplicacion Aplicacion) {
        AplicacionService.edit(Aplicacion);
        return ResponseEntity.ok(Aplicacion);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteApplication(@PathVariable Integer id) {
        return AplicacionService.delete(id);
    }
    


    //Método para el primer inciso.
    @GetMapping(path = "name/{name}")
    public List<Aplicacion> getAllByName(@PathVariable String name) {
        Specification<Aplicacion> specification = ApplicationSpecify.buscarPorNombre(name);
        return AplicacionService.getAllByName(specification);
    }

    //Método para el Segundo inciso
    @GetMapping(path = "SO/{sistema}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Aplicacion> getAllBySistema(@PathVariable String sistema) {
        Specification<Aplicacion> datos = ApplicationSpecify.segundoInciso(sistema);
        return AplicacionService.obtenerSegundoInciso(datos);
    }
}
