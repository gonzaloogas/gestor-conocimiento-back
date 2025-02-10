package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IdiomaMapper {

    IdiomaMapper mapper = Mappers.getMapper(IdiomaMapper.class);

    IdiomaDTO aDTO(IdiomaProfesional idiomaProfesional);
    IdiomaProfesional aEntidad(IdiomaDTO idiomaDTO);

    List<IdiomaDTO> aListaDTO(List<IdiomaProfesional> IdiomasProfesional);
    List<IdiomaProfesional> aListaEntidad(List<IdiomaDTO> IdiomasProfesionalDTOs);


}
