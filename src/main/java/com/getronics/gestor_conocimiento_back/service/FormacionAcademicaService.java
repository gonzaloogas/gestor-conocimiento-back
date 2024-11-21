package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.FormacionAcademica;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FormacionAcademicaService {

    public FormacionAcademica crearFormacionAcademica(FormacionAcademica formacionAcademica);

    public Optional<FormacionAcademica> listarFormacionAcademicaPorId(Long id);

}
