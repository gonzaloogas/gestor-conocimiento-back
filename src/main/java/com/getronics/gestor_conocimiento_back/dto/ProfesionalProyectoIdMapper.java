package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.ProfesionalProyectoId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfesionalProyectoIdMapper {

    ProfesionalProyectoIdMapper mapper = Mappers.getMapper(ProfesionalProyectoIdMapper.class);

    ProfesionalProyectoIdDTO aDTO(ProfesionalProyectoId profesionalProyectoId);
    ProfesionalProyectoId aEntidad(ProfesionalProyectoIdDTO profesionalProyectoIdDTO);

    List<ProfesionalProyectoIdDTO> aListaDTO(List<ProfesionalProyectoId> profesionalProyectoIds);
    List<ProfesionalProyectoId> aListaEntidad(List<ProfesionalProyectoIdDTO> profesionalProyectoIdDTOs);

}
