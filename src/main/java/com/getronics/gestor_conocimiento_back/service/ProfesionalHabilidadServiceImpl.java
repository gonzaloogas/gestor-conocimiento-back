package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.repository.ProfesionalHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

public class ProfesionalHabilidadServiceImpl implements  ProfesionalHabilidadService{

    @Autowired
    ProfesionalHabilidadRepository profesionalHabilidadRepository;

    @Override
    public HttpStatusCode agregarHabilidad() {
        return null;
    }
/*
    @Override
    public ProfesionalHabilidad agregarHabilidad() {
        return profesionalHabilidadRepository.agregarHabilidad();
    }

 */
}
