package com.getronics.gestor_conocimiento_back.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdiomaDTO {

    private Long id;
    private String nombre;
    private String nivelDominio;
    private Long profesionalId;
}
