package com.taller.taller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.taller.taller.Model.Servidor;
import com.taller.taller.Repository.ServidorRepository;

@Service
public class ServidorService {
    
    @Autowired
    private ServidorRepository repository;

    public void add(Servidor nuevo) {
        repository.save(nuevo);
    }

    public List<Servidor> getAll() {
        return repository.findAll();
    }

    public Servidor getById(Integer id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
    
    public void edit(Servidor editado) {
        repository.findById(editado.getId()).orElseThrow(RuntimeException::new);
        repository.save(editado);
    }

    public ResponseEntity delete(Integer id) {
        repository.findById(id).orElseThrow(RuntimeException::new);
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Primer Inciso
    public List<Servidor> servidoresMasDe1App(Specification<Servidor> servidores) {
        List<Servidor> data = repository.findAll(servidores);
        return data;
    }


    //Tercer inciso
    public List<Servidor> servidoresBusqueda(Specification<Servidor> servidores) {
        return repository.findAll(servidores);
    }
}
