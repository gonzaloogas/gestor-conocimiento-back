package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.repository.ProfesionalHabilidadRepository;
import com.getronics.gestor_conocimiento_back.util.JwtExtract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

//Para buscar el nombre de la persona en el jwt
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfesionalHabilidadServiceImpl implements  ProfesionalHabilidadService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(ProfesionalHabilidadServiceImpl.class);

    @Autowired
    JwtExtract jwtExtract;

    @Autowired
    ProfesionalHabilidadRepository profesionalHabilidadRepository;

    @Override
    public HttpStatusCode agregarHabilidad() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} agrego una Habilidad.", name);

        return null;
    }
/*
    @Override
    public ProfesionalHabilidad agregarHabilidad() {
        return profesionalHabilidadRepository.agregarHabilidad();
    }

 */
}
