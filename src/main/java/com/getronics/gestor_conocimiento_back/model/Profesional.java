package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="profesionales")
public class Profesional  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo nombres no puede ser nulo")
    @NotEmpty(message = "El valor del campo nombres no puede ser vacío")
    private String nombres;

    @NotNull (message = "El campo apellido paterno no puede ser nulo")
    @NotEmpty(message = "El valor del campo apellido paterno no puede ser vacío")
    @Column(name="apellido_paterno")
    private String aPaterno;

    @NotNull (message = "El campo apellido materno no puede ser nulo")
    @NotEmpty(message = "El valor del campo apellido materno no puede ser vacío")
    @Column(name="apellido_materno")
    private String aMaterno;

    @NotNull (message = "El campo años de experiencia no puede ser nulo")
    @Column(name="anio_experiencia")
    private Integer anioExperiencia;

    @NotNull (message = "El campo nivel experiencia no puede ser nulo")
    @NotEmpty(message = "El valor del campo nivel experiencia no puede ser vacío")
    private String nivelExperiencia;

    @OneToMany(targetEntity = ProfesionalHabilidad.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true)
    @JsonManagedReference
    private List<ProfesionalHabilidad> habilidadesProfesional;// = new ArrayList<>();

    @OneToMany(targetEntity = FormacionAcademica.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true)
    @JsonManagedReference
    private List<FormacionAcademica> formacionAcademicaProfesional;// = new ArrayList<>();

    @OneToMany(targetEntity = ProfesionalIdioma.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true)
    @JsonManagedReference
    private List<ProfesionalIdioma> idiomasProfesional;// = new ArrayList<>();

}
