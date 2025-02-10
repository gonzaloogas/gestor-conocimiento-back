package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CatalogoIdiomaMapper {

    CatalogoIdiomaMapper mapper = Mappers.getMapper(CatalogoIdiomaMapper.class);

    CatalogoIdiomaDTO catalogoIdiomaToCatalogoIdiomaDTO(CatalogoIdioma catalogoIdioma);

    CatalogoIdioma catalogoIdiomaDTOToCatalogoIdioma(CatalogoIdiomaDTO catalogoIdiomaDTO);

    List<CatalogoIdiomaDTO> toDTOList(List<CatalogoIdioma> catalogoIdiomas);
}
