package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReferenciaProfesionalDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;

    private String nombreReferente;

    private String cargo;

    private String empresa;

    private String telefonoContacto;

    private String relacionCandidato;



}
