package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class CatalogoIdiomaDTO {
    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;
    private String nombre;
    private String codigoISO;
}