package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    private String nombres;

    @Column(name="apellido_paterno")
    private String aPaterno;

    @Column(name="apellido_materno")
    private String aMaterno;

    @Column(name="anio_experiencia")
    private Integer anioExperiencia;

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
