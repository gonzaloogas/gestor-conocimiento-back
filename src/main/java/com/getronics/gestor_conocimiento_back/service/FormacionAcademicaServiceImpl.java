package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import com.getronics.gestor_conocimiento_back.repository.FormacionAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@Service
public class FormacionAcademicaServiceImpl implements FormacionAcademicaService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(FormacionAcademicaServiceImpl.class);

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
    private FormacionAcademicaRepository formacionAcademicaRepo;

    public FormacionAcademicaProfesional crearFormacionAcademica(FormacionAcademicaProfesional formacionAcademica){

        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} creó la Formacion Academica: {}", name, formacionAcademica);

        return formacionAcademicaRepo.save(formacionAcademica);
    }

    @Override
    public Optional<FormacionAcademicaProfesional> listarFormacionAcademicaPorId(Long id) {

        String name = getAuthenticatedUserNameFromJwt();
        logger.info("{} buscó la Formacion Academica con id: {}", name, id);

        return formacionAcademicaRepo.findById(id);
    }
}
