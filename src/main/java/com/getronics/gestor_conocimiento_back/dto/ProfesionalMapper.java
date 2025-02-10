package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.Profesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ProfesionalMapper {

    ProfesionalMapper mapper = Mappers.getMapper(ProfesionalMapper.class);

    ProfesionalDTO aDTO(Profesional profesional);

    Profesional aEntidad(ProfesionalDTO profesionalDTO);

    List<ProfesionalDTO> aListaDTO(List<Profesional> profesionales);
    List<Profesional> aListaEntidad(List<ProfesionalDTO> profesionalDTOs);
}
