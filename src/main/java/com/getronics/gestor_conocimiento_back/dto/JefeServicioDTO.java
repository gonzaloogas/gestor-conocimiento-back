package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.Profesional;
import lombok.Data;

import java.util.List;

@Data
public class JefeServicioDTO {

    private Long id;
    List<ProfesionalDTO> profesionalesAsignados;
}
