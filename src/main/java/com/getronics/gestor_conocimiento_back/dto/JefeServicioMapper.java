package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.JefeServicio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ProfesionalMapper.class)
public interface JefeServicioMapper {

    JefeServicioMapper mapper = Mappers.getMapper(JefeServicioMapper.class);

    @Mapping(source = "profesionalesAsignados", target = "profesionalesAsignados")
    JefeServicioDTO aDTO(JefeServicio jefeServicio);

    @Mapping(source = "profesionalesAsignados", target = "profesionalesAsignados")
    JefeServicio aEntidad(JefeServicioDTO jefeServicioDTO);

    List<JefeServicioDTO> aListaDTO(List<JefeServicio> jefesServicios);
    List<JefeServicio> aListaEntidad(List<JefeServicioDTO> jefesServicioDTOs);
}
