package com.getronics.gestor_conocimiento_back.service;

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
    public Proyecto crearProyecto(Proyecto proyecto) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó el proyecto {}", name, proyecto);

        return proyectoRepository.save(proyecto);
    }

    @Override
    public Optional<Proyecto> listarProyectoPorId(Long id) throws DataNotFoundException {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó el proyecto con el id: {}", name, id);

        return proyectoRepository.findById(id);
    }

    @Override
    public List<Proyecto> listarProyectos() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} buscó todos los proyectos", name);

        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto actualizarProyecto(Proyecto proyecto, Long id) throws DataNotFoundException {

        Proyecto proyectoDB = proyectoRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Proyecto no encontrado"));

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("(ANTES) {} actualizó el Proyecto con id: {}, Proyecto: {}", name, id, proyecto);

        proyectoDB.setNombre(proyecto.getNombre());
        proyectoDB.setDescripcion(proyecto.getDescripcion());
        proyectoDB.setFechaInicio(proyecto.getFechaInicio());
        proyectoDB.setFechaFin(proyecto.getFechaFin());
        proyectoDB.setEstado(proyecto.getEstado());
        proyectoDB.setCliente(proyecto.getCliente());


        logger.info("(DESPUES) {} actualizó el Proyecto con id: {}, Proyecto: {}", name, id, proyectoDB);

        return proyectoRepository.save(proyectoDB);
    }

    @Override
    public void deleteProyecto(Long id) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("(ANTES) {} eliminó el Proyecto con id: {}", name, id);

        proyectoRepository.deleteById(id);
    }
}
