package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "publicaciones_logros_academicos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionesLogrosAcademicosProfesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_publicacion")
    @NotEmpty(message = "El campo titulo publicacion no debe ser vacio o nulo")
    private String tituloPublicacion;

    @NotEmpty(message = "El campo descripcion no debe ser vacio o nulo")
    private String descripcion;

    @Column(name = "fecha_publicacion")
    @NotEmpty(message = "El campo fecha de publicacion no debe ser vacio o nulo")
    private LocalDate fechaPublicacion;

    @Column(name = "medio_publicacion")
    @NotEmpty(message = "El campo medio de publicacion no debe ser vacio o nulo")
    private String medioPublicacion;

    @Column(name = "enlace_publicacion")
    @NotEmpty(message = "El campo enlace de publicacion no debe ser vacio o nulo")
    private String enlacePublicacion;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Profesional profesional;
}
