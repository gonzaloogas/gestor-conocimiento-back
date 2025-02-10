package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.ProfesionalProyecto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfesionalProyectoMapper {

    ProfesionalProyectoMapper mapper = Mappers.getMapper(ProfesionalProyectoMapper.class);

    ProfesionalProyectoDTO aDTO(ProfesionalProyecto profesionalProyecto);
    ProfesionalProyecto aEntidad(ProfesionalProyectoDTO profesionalProyectoDTO);

    List<ProfesionalProyectoDTO> aListaDTO(List<ProfesionalProyecto> profesionalProyectos);
    List<ProfesionalProyecto> aListaEntidad(List<ProfesionalProyectoDTO> profesionalProyectoDTOs);

}
