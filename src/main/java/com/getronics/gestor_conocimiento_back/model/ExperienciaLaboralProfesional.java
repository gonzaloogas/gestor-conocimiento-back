package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="experiencia_laboral")
public class ExperienciaLaboralProfesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty (message = "El valro del campo empresa no debe ser vacio ni nulo")
    private String empresa;

    @NotEmpty (message = "El valro del campo cargo no debe ser vacio ni nulo")
    private String cargo;

    @NotEmpty (message = "El valro del campo descripcion no debe ser vacio ni nulo")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Profesional profesional;

}
