package com.taller.taller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.taller.taller.Model.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Integer>, JpaSpecificationExecutor<Servidor>{
    
}
