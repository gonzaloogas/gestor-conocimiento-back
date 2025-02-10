package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.CertificacionProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CertificacionProfesionalMapper {

    CertificacionProfesionalMapper mapper = Mappers.getMapper(CertificacionProfesionalMapper.class);

    CertificacionProfesionalDTO aDTO(CertificacionProfesional catalogoConocimiento);
    CertificacionProfesional aEntidad(CertificacionProfesionalDTO catalogoConocimientoDTO);

    List<CertificacionProfesionalDTO> aListaDTO(List<CertificacionProfesional> catalogoConocimientos);
    List<CertificacionProfesional> aListaEntidad(List<CatalogoConocimientoDTO> catalogoConocimientoDTOs);

}
