package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienciaLaboralProfesionalDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;

    private String empresa;

    private String cargo;

    private String descripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;


}
