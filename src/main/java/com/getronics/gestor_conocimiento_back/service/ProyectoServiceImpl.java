package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Proyecto;
import com.getronics.gestor_conocimiento_back.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt


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
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {



        return proyectoRepository.save(proyecto);
    }

    @Override
    public Optional<Proyecto> listarProyectoPorId(Long id) throws DataNotFoundException {



        return proyectoRepository.findById(id);
    }

    @Override
    public List<Proyecto> listarProyectos() {



        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto actualizarProyecto(Proyecto proyecto, Long id) throws DataNotFoundException {

        Proyecto proyectoDB = proyectoRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Proyecto no encontrado"));



        proyectoDB.setNombre(proyecto.getNombre());
        proyectoDB.setDescripcion(proyecto.getDescripcion());
        proyectoDB.setFechaInicio(proyecto.getFechaInicio());
        proyectoDB.setFechaFin(proyecto.getFechaFin());
        proyectoDB.setEstado(proyecto.getEstado());
        proyectoDB.setCliente(proyecto.getCliente());




        return proyectoRepository.save(proyectoDB);
    }

    @Override
    public void deleteProyecto(Long id) {



        proyectoRepository.deleteById(id);
    }
}
