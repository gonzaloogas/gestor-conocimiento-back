package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import com.getronics.gestor_conocimiento_back.repository.FormacionAcademicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@Service
public class FormacionAcademicaServiceImpl implements FormacionAcademicaService {

    //Para el log
    private static final Logger logger =LogManager.getLogger(FormacionAcademicaServiceImpl.class);



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
