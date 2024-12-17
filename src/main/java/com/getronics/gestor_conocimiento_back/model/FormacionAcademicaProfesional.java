package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="formacion_academica")
public class FormacionAcademicaProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "El campo carrera no puede ser nulo")
    @NotEmpty(message = "El valor del campo carrera no puede ser vacío")
    private String carrera;

    @NotNull (message = "El campo institución no puede ser nulo")
    @NotEmpty(message = "El valor del campo institución no puede ser vacío")
    private String institucion;

    @NotNull (message = "El campo año inicio no puede ser nulo")
    @Column(name = "anio_inicio")
    private Year anioInicio;

    @Column(name = "anio_fin")
    private Year anioFin;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Profesional profesional;

}
