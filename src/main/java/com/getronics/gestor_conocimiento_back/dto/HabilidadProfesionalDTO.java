package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getronics.gestor_conocimiento_back.model.NivelCompetenicia;
import com.getronics.gestor_conocimiento_back.model.TipoHabilidad;
import lombok.Data;

@Data
public class HabilidadProfesionalDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;

    private String habilidad;
    private TipoHabilidad tipoHabilidad;
    private String aniosExperiencia;
    private NivelCompetenicia nivelCompetencia;

}
