package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "referencia_profesional")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferenciaProfesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo nombre del referente no puede ser vacio o nulo")
    private String nombreReferente;

    @NotEmpty(message = "El campo cargo no puede ser vacio o nulo")
    private String cargo;

    @NotEmpty(message = "El campo nombre de la empresa no puede ser vacio o nulo")
    private String empresa;

    @NotEmpty(message = "El campo telefono de contacto no puede ser vacio o nulo")
    private String telefonoContacto;

    @NotEmpty(message = "El campo relacion con el candidato no puede ser vacio o nulo")
    private String relacionCandidato;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Profesional profesional;
}
