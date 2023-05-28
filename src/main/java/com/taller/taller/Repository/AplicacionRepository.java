package com.taller.taller.Repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.taller.taller.Model.Aplicacion;
import com.taller.taller.Model.Servidor;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion, Integer>, JpaSpecificationExecutor<Aplicacion>{
    
    
}
