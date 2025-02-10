package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.ReferenciaProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReferenciaProfesionalMapper {

    ReferenciaProfesionalMapper mapper = Mappers.getMapper(ReferenciaProfesionalMapper.class);

    ReferenciaProfesionalDTO aDTO(ReferenciaProfesional referenciaProfesional);
    ReferenciaProfesional aEntidad(ReferenciaProfesionalDTO referenciaProfesionalDTO);

    List<ReferenciaProfesionalDTO> aListaDTO(List<ReferenciaProfesional> referenciaProfesionales);
    List<ReferenciaProfesional> aListaEntidad(List<ReferenciaProfesionalDTO> referenciaProfesionalDTOs);

}
