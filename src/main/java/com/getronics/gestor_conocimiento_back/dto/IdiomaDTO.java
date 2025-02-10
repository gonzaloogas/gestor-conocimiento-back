package com.getronics.gestor_conocimiento_back.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdiomaDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;
    private String nombre;
    private String nivelDominio;

}
