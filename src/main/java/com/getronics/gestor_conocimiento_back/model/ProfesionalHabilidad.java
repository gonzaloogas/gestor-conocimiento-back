package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="profesional_habilidad")
public class ProfesionalHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profesional_id")
    @JsonBackReference
    private Profesional profesional;

    private String habilidadTecnologica;

    private String nivelCompetencia;
}
