package com.taller.taller.Model.MetaModels;


import com.taller.taller.Model.Aplicacion;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aplicacion.class)
public abstract class Application_ {
    public static volatile SingularAttribute<Aplicacion, Integer> id;
    public static volatile SingularAttribute<Aplicacion, String> nombre;
    public static volatile SingularAttribute<Aplicacion, String> version;
    public static volatile SingularAttribute<Aplicacion, Integer> idservidor;

    public static final String APPLICATION_ID = "id";
    public static final String APPLICATION_NAME = "nombre";
    public static final String APPLICATION_VERSION = "version";
    public static final String APPLICATION_SERVER = "idservidor";
    
}