package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.FormacionAcademicaProfesionalDTO;
import com.getronics.gestor_conocimiento_back.dto.FormacionAcademicaProfesionalMapper;
import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import com.getronics.gestor_conocimiento_back.repository.FormacionAcademicaRepository;
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

import java.util.Optional;

@Service
public class FormacionAcademicaServiceImpl implements FormacionAcademicaService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(FormacionAcademicaServiceImpl.class);

    @Autowired
    private JwtExtract jwtExtract;

    @Autowired
    private FormacionAcademicaRepository formacionAcademicaRepo;

    public FormacionAcademicaProfesionalDTO crearFormacionAcademica(FormacionAcademicaProfesionalDTO formacionAcademicaDTO){

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó la Formacion Academica: {}", name, formacionAcademicaDTO);


        FormacionAcademicaProfesional entidadAGuardar = FormacionAcademicaProfesionalMapper.mapper.aEntidad(formacionAcademicaDTO);


        FormacionAcademicaProfesional entidadGuardada = formacionAcademicaRepo.save(entidadAGuardar);

        return FormacionAcademicaProfesionalMapper.mapper.aDTO(entidadGuardada);
    }

    @Override
    public Optional<FormacionAcademicaProfesionalDTO> listarFormacionAcademicaPorId(Long id) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó la Formacion Academica con id: {}", name, id);

        return formacionAcademicaRepo.findById(id)
                .map(FormacionAcademicaProfesionalMapper.mapper::aDTO);
    }
}
