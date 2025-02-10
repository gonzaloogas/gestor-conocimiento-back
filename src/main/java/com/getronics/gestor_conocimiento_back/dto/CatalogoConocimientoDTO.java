package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getronics.gestor_conocimiento_back.model.TipoHabilidad;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CatalogoConocimientoDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private TipoHabilidad tipo;

}