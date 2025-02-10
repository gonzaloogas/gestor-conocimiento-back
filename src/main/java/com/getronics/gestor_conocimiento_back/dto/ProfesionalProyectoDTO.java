package com.getronics.gestor_conocimiento_back.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfesionalProyectoDTO {


    private ProfesionalProyectoIdDTO id;
    private ProfesionalDTO profesional;
    private ProyectoDTO proyecto;
    private Long porcentajeParticipacion;

    private LocalDate ingresoAlProyecto;

}
