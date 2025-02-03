package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.repository.ProfesionalHabilidadRepository;
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

    //Para buscar el nombre de la persona que accede al método
    private String getAuthenticatedUserNameFromJwt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            // Aquí se obtiene el claim "name" del JWT, si está disponible
            return jwt.getClaim("name");  // Usa el nombre del claim que contiene el nombre real del usuario
        }
        return "Desconocido";
    }

    @Autowired
    ProfesionalHabilidadRepository profesionalHabilidadRepository;

    @Override
    public HttpStatusCode agregarHabilidad() {

        String name = getAuthenticatedUserNameFromJwt();
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
