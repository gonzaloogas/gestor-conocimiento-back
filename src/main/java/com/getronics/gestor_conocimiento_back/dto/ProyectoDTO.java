package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.EstadoProyecto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProyectoDTO {
    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private EstadoProyecto estado;

    private ClienteDTO cliente;



}
