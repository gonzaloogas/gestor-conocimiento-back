package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.repository.ProfesionalHabilidadRepository;
//import com.getronics.gestor_conocimiento_back.util.JwtExtract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

//Para buscar el nombre de la persona en el jwt

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HabilidadProfesionalServiceImpl implements HabilidadProfesionalService {

    //Para el log
    private static final Logger logger =LogManager.getLogger(HabilidadProfesionalServiceImpl.class);



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
