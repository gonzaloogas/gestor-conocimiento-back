package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.CatalogoConocimientoDTO;
import com.getronics.gestor_conocimiento_back.dto.CatalogoConocimientoMapper;
import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import com.getronics.gestor_conocimiento_back.repository.CatalogoHabilidadRepository;
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
public class CatalogoHablidadTecnologicaServiceImpl implements CatalogoHabilidadTecnologicaService{

    @Autowired
    private JwtExtract jwtExtract;

    //Para el log
    private static final Logger logger =LogManager.getLogger(CatalogoHablidadTecnologicaServiceImpl.class);

    @Autowired
    private CatalogoHabilidadRepository habilidadTecnologicaRepository;

    @Override
    public CatalogoConocimientoDTO crearHabilidadTecnologica(CatalogoConocimientoDTO habilidadTecnologicaDTO) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó la Habilidad Tecnoligica {}", name, habilidadTecnologicaDTO);


        CatalogoConocimiento entidadAGuardar = CatalogoConocimientoMapper.mapper.aEntidad(habilidadTecnologicaDTO);


        CatalogoConocimiento entidadGuardada = habilidadTecnologicaRepository.save(entidadAGuardar);


        return CatalogoConocimientoMapper.mapper.aDTO(entidadGuardada);
    }

    @Override
    public Optional<CatalogoConocimientoDTO> listarHabilidadTecnologicaPorId(Long id) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó la Habilidad Tecnoligica con el id: {}", name, id);

        //Si findById(id) devuelve Optional.of(entidad), se ejecuta aDTO(entidad) y devuelve Optional.of(dto)
        return habilidadTecnologicaRepository.findById(id)
                .map(CatalogoConocimientoMapper.mapper::aDTO);
    }

    @Override
    public List<CatalogoConocimientoDTO> listarHabilidades() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó todas las Habilidades Tecnoligicas {}", name);
        return CatalogoConocimientoMapper.mapper.aListaDTO(habilidadTecnologicaRepository.findAll());
    }
}
