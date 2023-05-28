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

import com.taller.taller.Model.Servidor;
import com.taller.taller.Model.MetaModels.Servidor_;
import com.taller.taller.Repository.ServidorRepository;
import com.taller.taller.Service.ServidorService;
import com.taller.taller.Service.Specify.ServerSpecify;


@RestController
@RequestMapping("/servidor")
public class ServiceController {
    
    @Autowired
    private ServidorService servidorService;

    @Autowired
    private ServidorRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Servidor> getAll() {
        return servidorService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Servidor getServer(@PathVariable Integer id) {
        Servidor server = servidorService.getById(id);
        return server;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postService(@RequestBody Servidor servidor) throws URISyntaxException {
        servidorService.add(servidor);
        return ResponseEntity.created(new URI("/servidor/" + servidor.getId())).body(servidor);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putService(@PathVariable Integer id, @RequestBody Servidor servidor) {
        servidorService.edit(servidor);
        return ResponseEntity.ok(servidor);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteService(@PathVariable Integer id) {
        return servidorService.delete(id);
    }


    @GetMapping(path = "/primerInciso", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Servidor> obtenerServidoresPrimerInciso() {
        Specification<Servidor> respuestaQuery = ServerSpecify.buscarPrimerInciso();
        return servidorService.servidoresBusqueda(respuestaQuery);
    }
}
