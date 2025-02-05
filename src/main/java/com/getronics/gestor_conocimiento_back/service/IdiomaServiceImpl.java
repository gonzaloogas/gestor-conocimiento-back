package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import com.getronics.gestor_conocimiento_back.repository.CatalogoIdiomaRepository;
import com.getronics.gestor_conocimiento_back.util.JwtExtract;
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

    @Autowired
    private JwtExtract jwtExtract;

    @Autowired
    private CatalogoIdiomaRepository idiomaRepository;

    @Override
    public List<CatalogoIdioma> listarIdiomas() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó todos los idiomas", name);

        return idiomaRepository.findAll();
    }
}
