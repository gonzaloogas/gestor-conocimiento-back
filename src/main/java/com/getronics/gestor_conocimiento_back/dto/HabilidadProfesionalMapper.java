package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.HabilidadProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HabilidadProfesionalMapper {

    HabilidadProfesionalMapper mapper = Mappers.getMapper(HabilidadProfesionalMapper.class);

    HabilidadProfesionalDTO aDTO(HabilidadProfesional habilidadProfesional);
    HabilidadProfesional aEntidad(HabilidadProfesionalDTO habilidadProfesionalDTO);

    List<HabilidadProfesionalDTO> aListaDTO(List<HabilidadProfesional> habilidadProfesionales);
    List<HabilidadProfesional> aListaEntidad(List<HabilidadProfesionalDTO> habilidadProfesionalDTOs);


}
