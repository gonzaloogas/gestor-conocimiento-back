package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="formacion_academica")
public class FormacionAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "El campo no puede ser nulo")
    @NotEmpty(message = "El valor del campo no puede ser vacío")
    private String carrera;

    @NotNull (message = "El campo no puede ser nulo")
    @NotEmpty(message = "El valor del campo no puede ser vacío")
    private String institucion;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Profesional profesional;


}
