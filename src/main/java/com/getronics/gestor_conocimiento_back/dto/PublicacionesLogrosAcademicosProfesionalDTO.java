package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PublicacionesLogrosAcademicosProfesionalDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;

    private String tituloPublicacion;

    private String descripcion;

    private LocalDate fechaPublicacion;

    private String medioPublicacion;

    private String enlacePublicacion;

    private ProfesionalDTO profesional;

}
