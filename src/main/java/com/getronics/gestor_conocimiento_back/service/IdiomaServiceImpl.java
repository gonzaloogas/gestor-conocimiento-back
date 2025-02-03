package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import com.getronics.gestor_conocimiento_back.repository.CatalogoIdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IdiomaService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(IdiomaServiceImpl.class);

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
    private CatalogoIdiomaRepository idiomaRepository;

    @Override
    public List<CatalogoIdioma> listarIdiomas() {

        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} buscó todos los idiomas", name);

        return idiomaRepository.findAll();
    }
}
