package com.taller.taller.Service.Specify;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;
import com.taller.taller.Model.Aplicacion;
import com.taller.taller.Model.Servidor;
import com.taller.taller.Model.MetaModels.Application_;
import com.taller.taller.Model.MetaModels.Servidor_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class ServerSpecify {

    public static Specification<Servidor> buscarPrimerInciso() {
        return new Specification<Servidor>() {
            @Override
            public Predicate toPredicate(Root<Servidor> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                    
                    Subquery<Integer> subquery = query.subquery(Integer.class);
                    Root<Aplicacion> subqueryRoot = subquery.from(Aplicacion.class);
                    subquery.select(subqueryRoot.get(Application_.APPLICATION_SERVER));
                    subquery.groupBy(subqueryRoot.get(Application_.APPLICATION_SERVER));
                    subquery.having(builder.gt(builder.count(subqueryRoot.get(Application_.APPLICATION_SERVER)), 1));
                    
                    return root.get(Servidor_.SERVIDOR_ID).in(subquery);
                    //SELECT idservidor FROM servidor WHERE idservidor IN (SELECT idservidor FROM aplicaciones WHERE COUNT(idservidor) > 1 GROUP BY idservidor);
            }
        };
    }
    
}
