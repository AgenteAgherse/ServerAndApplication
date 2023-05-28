package com.taller.taller.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aplicacion")
@Data
@NoArgsConstructor
public class Aplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaplicacion")
    private Integer id;
    

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "version")
    private String version;

    @Column(name = "idservidor")
    private Integer idservidor;

}
