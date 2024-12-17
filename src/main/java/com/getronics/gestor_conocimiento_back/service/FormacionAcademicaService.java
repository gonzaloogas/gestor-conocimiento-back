package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FormacionAcademicaService {

    public FormacionAcademicaProfesional crearFormacionAcademica(FormacionAcademicaProfesional formacionAcademica);

    public Optional<FormacionAcademicaProfesional> listarFormacionAcademicaPorId(Long id);

}
