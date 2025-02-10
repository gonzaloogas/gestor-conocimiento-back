package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.PublicacionesLogrosAcademicosProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublicacionesLogrosAcademicosProfesionalMapper {

    PublicacionesLogrosAcademicosProfesionalMapper mapper = Mappers.getMapper(PublicacionesLogrosAcademicosProfesionalMapper.class);

    PublicacionesLogrosAcademicosProfesionalDTO aDTO(PublicacionesLogrosAcademicosProfesional publicacionesLogrosAcademicosProfesional);
    PublicacionesLogrosAcademicosProfesional aEntidad(PublicacionesLogrosAcademicosProfesionalDTO publicacionesLogrosAcademicosProfesionalDTO);

    List<PublicacionesLogrosAcademicosProfesionalDTO> aListaDTO(List<PublicacionesLogrosAcademicosProfesional> publicacionesLogrosAcademicosProfesionales);
    List<PublicacionesLogrosAcademicosProfesional> aListaEntidad(List<PublicacionesLogrosAcademicosProfesionalDTO> publicacionesLogrosAcademicosProfesionalDTOs);

}
