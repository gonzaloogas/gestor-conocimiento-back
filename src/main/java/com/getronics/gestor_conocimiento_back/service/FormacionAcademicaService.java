package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.FormacionAcademicaProfesionalDTO;
import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FormacionAcademicaService {

    public FormacionAcademicaProfesionalDTO crearFormacionAcademica(FormacionAcademicaProfesionalDTO formacionAcademicaDTO);

    public Optional<FormacionAcademicaProfesionalDTO> listarFormacionAcademicaPorId(Long id);

}
