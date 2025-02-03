package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import com.getronics.gestor_conocimiento_back.repository.CatalogoHabilidadRepository;
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
import java.util.Optional;

@Service
public class CatalogoHablidadTecnologicaServiceImpl implements CatalogoHabilidadTecnologicaService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(CatalogoHablidadTecnologicaServiceImpl.class);

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
    private CatalogoHabilidadRepository habilidadTecnologicaRepository;

    @Override
    public CatalogoConocimiento crearHabilidadTecnologica(CatalogoConocimiento habilidadTecnologica) {

        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} creó la Habilidad Tecnoligica {}", name, habilidadTecnologica);

        return habilidadTecnologicaRepository.save(habilidadTecnologica);
    }

    @Override
    public Optional<CatalogoConocimiento> listarHabilidadTecnologicaPorId(Long id) {

        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} buscó la Habilidad Tecnoligica con el id: {}", name, id);

        return habilidadTecnologicaRepository.findById(id);
    }

    @Override
    public List<CatalogoConocimiento> listarHabilidades() {

        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} buscó todas las Habilidades Tecnoligicas {}", name);
        return habilidadTecnologicaRepository.findAll();
    }
}
