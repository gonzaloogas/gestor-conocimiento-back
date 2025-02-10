package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.RedesSocialesPortafolioProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RedesSocialesPortafolioProfesionalMapper {

    RedesSocialesPortafolioProfesionalMapper mapper = Mappers.getMapper(RedesSocialesPortafolioProfesionalMapper.class);

    RedesSocialesPortafolioProfesionalDTO aDTO(RedesSocialesPortafolioProfesional redesSocialesPortafolioProfesional);
    RedesSocialesPortafolioProfesional aEntidad(RedesSocialesPortafolioProfesionalDTO redesSocialesPortafolioProfesionalDTO);

    List<RedesSocialesPortafolioProfesionalDTO> aListaDTO(List<RedesSocialesPortafolioProfesional> redesSocialesPortafolioProfesionales);
    List<RedesSocialesPortafolioProfesional> aListaEntidad(List<RedesSocialesPortafolioProfesionalDTO> redesSocialesPortafolioProfesionalDTOs);

}
