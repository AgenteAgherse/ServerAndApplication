package com.taller.taller.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servidor")
@Data
@NoArgsConstructor
public class Servidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservidor")
    private Integer id;
    

    @Column(name = "ip")
    private String ip;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "memoria")
    private String memoria;

    @Column(name = "disco")
    private String disco;

    @Column(name = "procesador")
    private String procesador;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "sistemaoperativo")
    private String sistemaoperativo;

    

}
