package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.ClienteMapper;
import com.getronics.gestor_conocimiento_back.dto.ProyectoDTO;
import com.getronics.gestor_conocimiento_back.dto.ProyectoMapper;
import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Proyecto;
import com.getronics.gestor_conocimiento_back.repository.ProyectoRepository;
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
public class ProyectoServiceImpl implements ProyectoService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(ProyectoServiceImpl.class);

    @Autowired
    JwtExtract jwtExtract;


    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó el proyecto {}", name, proyectoDTO);

        Proyecto entidadAGuardar = ProyectoMapper.mapper.aEntidad(proyectoDTO);
        Proyecto entidadGuardada = proyectoRepository.save(entidadAGuardar);

        return ProyectoMapper.mapper.aDTO(entidadGuardada);
    }

    @Override
    public Optional<ProyectoDTO> listarProyectoPorId(Long id) throws DataNotFoundException {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó el proyecto con el id: {}", name, id);

        return proyectoRepository.findById(id)
                .map(ProyectoMapper.mapper::aDTO);
    }

    @Override
    public List<ProyectoDTO> listarProyectos() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó todos los proyectos", name);

        return ProyectoMapper.mapper.aListaDTO(proyectoRepository.findAll());
    }

    @Override
    public ProyectoDTO actualizarProyecto(ProyectoDTO proyectoDTO, Long id) throws DataNotFoundException {

        Proyecto proyectoDB = proyectoRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Proyecto no encontrado"));

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("(ANTES) {} actualizó el Proyecto con id: {}, Proyecto: {}", name, id, proyectoDTO);

        proyectoDB.setNombre(proyectoDTO.getNombre());
        proyectoDB.setDescripcion(proyectoDTO.getDescripcion());
        proyectoDB.setFechaInicio(proyectoDTO.getFechaInicio());
        proyectoDB.setFechaFin(proyectoDTO.getFechaFin());
        proyectoDB.setEstado(proyectoDTO.getEstado());
        proyectoDB.setCliente(ClienteMapper.mapper.aEntidad(proyectoDTO.getCliente()));


        Proyecto proyectoActualizado = proyectoRepository.save(proyectoDB);

        logger.info("(DESPUES) {} actualizó el Proyecto con id: {}, Proyecto: {}", name, id, proyectoDB);

        return ProyectoMapper.mapper.aDTO(proyectoActualizado);
    }

    @Override
    public void deleteProyecto(Long id) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("(ANTES) {} eliminó el Proyecto con id: {}", name, id);

        proyectoRepository.deleteById(id);
    }
}
