package com.taller.taller.Service.Specify;

import org.springframework.data.jpa.domain.Specification;

import com.mysql.cj.xdevapi.Expression;
import com.taller.taller.Model.Aplicacion;
import com.taller.taller.Model.Servidor;
import com.taller.taller.Model.MetaModels.Application_;
import com.taller.taller.Model.MetaModels.Servidor_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class ApplicationSpecify {
    
    public static Specification<Aplicacion> buscarPorNombre(String nombre) {
        return new Specification<Aplicacion>() {

            @Override
            public Predicate toPredicate(Root<Aplicacion> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
                        return criteriaBuilder.equal(root.get(Application_.APPLICATION_NAME), nombre);
            }
        };
    }

    public static Specification<Aplicacion> segundoInciso(String SO) {
        return new Specification<Aplicacion>() {

            @Override
            public Predicate toPredicate(Root<Aplicacion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //Obtener las identificaciones de los servidores por el nombre del sistema operativo.
                Subquery<Integer> subquery = query.subquery(Integer.class);
                Root<Servidor> subRoot = subquery.from(Servidor.class);
                subquery.where(criteriaBuilder.equal(subRoot.get(Servidor_.SERVIDOR_SO), SO));
                //Se filtra para obtener solamente el ID
                subquery.select(subRoot.get(Servidor_.SERVIDOR_ID));
                
                //Se envía la información de las ID que se encuentren listados dentro del subquery.
                return root.get(Application_.APPLICATION_SERVER).in(subquery);
            }
        };
    }

    
}
