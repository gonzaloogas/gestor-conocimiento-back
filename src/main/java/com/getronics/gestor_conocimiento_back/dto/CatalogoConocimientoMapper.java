package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CatalogoConocimientoMapper {

    CatalogoConocimientoMapper mapper = Mappers.getMapper(CatalogoConocimientoMapper.class);

    CatalogoConocimientoDTO aDTO(CatalogoConocimiento catalogoConocimiento);
    CatalogoConocimiento aEntidad(CatalogoConocimientoDTO catalogoConocimientoDTO);

    List<CatalogoConocimientoDTO> aListaDTO(List<CatalogoConocimiento> catalogoConocimientos);
    List<CatalogoConocimiento> aListaEntidad(List<CatalogoConocimientoDTO> catalogoConocimientoDTOs);

}

