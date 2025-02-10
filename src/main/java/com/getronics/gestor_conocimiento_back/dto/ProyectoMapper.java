package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.Proyecto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProyectoMapper {

    ProyectoMapper mapper = Mappers.getMapper(ProyectoMapper.class);

    ProyectoDTO aDTO(Proyecto proyecto);
    Proyecto aEntidad(ProyectoDTO proyectoDTO);

    List<ProyectoDTO> aListaDTO(List<Proyecto> proyectos);
    List<Proyecto> aListaEntidad(List<ProyectoDTO> proyectoDTOs);

}
