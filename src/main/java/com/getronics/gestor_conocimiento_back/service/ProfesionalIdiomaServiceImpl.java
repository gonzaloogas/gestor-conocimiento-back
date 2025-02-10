package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.IdiomaDTO;
import com.getronics.gestor_conocimiento_back.dto.IdiomaMapper;
import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import com.getronics.gestor_conocimiento_back.repository.ProfesionalIdiomaRepository;
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
import java.util.Optional;

@Service
public class ProfesionalIdiomaServiceImpl implements ProfesionalIdiomaService {

    //Para el log
    private static final Logger logger =LogManager.getLogger(ProfesionalIdiomaServiceImpl.class);

    @Autowired
    private JwtExtract jwtExtract;

    private ProfesionalIdiomaRepository idiomaRepository;

    @Override
    public IdiomaDTO crearIdioma(IdiomaDTO idiomaDTO) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó el idioma: {}", name, idiomaDTO);

        IdiomaProfesional entidadAGuardar = IdiomaMapper.mapper.aEntidad(idiomaDTO);

        IdiomaProfesional entidadGuardada = idiomaRepository.save(entidadAGuardar);

        return IdiomaMapper.mapper.aDTO(entidadGuardada);
    }

    @Override
    public Optional<IdiomaDTO> listarIdiomaPorId(Long id) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó el idioma con el id: {}", name, id);

        return idiomaRepository.findById(id)
                .map(IdiomaMapper.mapper::aDTO);
    }

    @Override
    public List<IdiomaDTO> listarIdiomas() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó todos los idiomas", name);

        return IdiomaMapper.mapper.aListaDTO(idiomaRepository.findAll());
    }
}
