package com.getronics.gestor_conocimiento_back.dto;


import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FormacionAcademicaProfesionalMapper {

    FormacionAcademicaProfesionalMapper mapper = Mappers.getMapper(FormacionAcademicaProfesionalMapper.class);

    FormacionAcademicaProfesionalDTO aDTO(FormacionAcademicaProfesional formacionAcademicaProfesional);
    FormacionAcademicaProfesional aEntidad(FormacionAcademicaProfesionalDTO formacionAcademicaProfesionalDTO);

    List<FormacionAcademicaProfesionalDTO> aListaDTO(List<FormacionAcademicaProfesional> formacionAcademicaProfesionales);
    List<FormacionAcademicaProfesional> aListaEntidad(List<FormacionAcademicaProfesionalDTO> formacionAcademicaProfesionalDTOs);


}
