package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "profesional_proyecto")
public class ProfesionalProyecto implements Serializable {

    @EmbeddedId
    private ProfesionalProyectoId id;

    @ManyToOne
    @MapsId("profesionalId")
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;

    @ManyToOne
    @MapsId("proyectoId")
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    private Long porcentajeParticipacion;

    private LocalDate ingresoAlProyecto;

}
