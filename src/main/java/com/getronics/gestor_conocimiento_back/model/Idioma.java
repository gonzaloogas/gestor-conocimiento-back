package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Idiomas")
@Data
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "codigo_iso")
    private String codigoISO;
}
