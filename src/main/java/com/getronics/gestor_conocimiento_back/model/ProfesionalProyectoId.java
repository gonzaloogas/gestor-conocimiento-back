package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesionalProyectoId implements Serializable {
    private Long profesionalId;
    private Long proyectoId;

}
