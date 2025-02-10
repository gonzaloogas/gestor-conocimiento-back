package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.ExperienciaLaboralProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExperienciaLaboralProfesionalMapper {

    ExperienciaLaboralProfesionalMapper mapper = Mappers.getMapper(ExperienciaLaboralProfesionalMapper.class);

    ExperienciaLaboralProfesionalDTO aDTO(ExperienciaLaboralProfesional experienciaLaboralProfesional);
    ExperienciaLaboralProfesional aEntidad(ExperienciaLaboralProfesionalDTO experienciaLaboralProfesionalDTO);

    List<ExperienciaLaboralProfesionalDTO> aListaDTO(List<ExperienciaLaboralProfesional> experienciaLaboralProfesionales);
    List<ExperienciaLaboralProfesional> aListaEntidad(List<ExperienciaLaboralProfesionalDTO> experienciaLaboralProfesionalDTOs);
}
