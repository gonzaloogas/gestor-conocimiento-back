package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import com.getronics.gestor_conocimiento_back.repository.FormacionAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormacionAcademicaServiceImpl implements FormacionAcademicaService{

    @Autowired
    private FormacionAcademicaRepository formacionAcademicaRepo;

    public FormacionAcademicaProfesional crearFormacionAcademica(FormacionAcademicaProfesional formacionAcademica){
        return formacionAcademicaRepo.save(formacionAcademica);
    }

    @Override
    public Optional<FormacionAcademicaProfesional> listarFormacionAcademicaPorId(Long id) {
        return formacionAcademicaRepo.findById(id);
    }
}
