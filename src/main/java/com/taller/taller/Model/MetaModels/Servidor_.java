package com.taller.taller.Model.MetaModels;

import java.util.List;

import com.taller.taller.Model.Aplicacion;
import com.taller.taller.Model.Servidor;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Servidor.class)
public abstract class Servidor_ {
    public static volatile SingularAttribute<Servidor, Integer> id;
    public static volatile SingularAttribute<Servidor, String> ip;
    public static volatile SingularAttribute<Servidor, String> memoria;
    public static volatile SingularAttribute<Servidor, String> disco;
    public static volatile SingularAttribute<Servidor, String> procesador;
    public static volatile SingularAttribute<Servidor, String> ubicacion;
    public static volatile SingularAttribute<Servidor, String> sistemaoperativo;
    public static final String SERVIDOR_ID = "id";
    public static final String SERVIDOR_IP = "ip";
    public static final String SERVIDOR_MEMORIA = "memoria";
    public static final String SERVIDOR_DISCO = "disco";
    public static final String SERVIDOR_PROCESADOR = "procesador";
    public static final String SERVIDOR_UBICACION = "ubicacion";
    public static final String SERVIDOR_SO = "sistemaoperativo";
}
