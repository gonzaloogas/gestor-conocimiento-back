package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.ProyectoDTO;
import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.model.Proyecto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProyectoService {

    /*
    public Cliente crearCliente(Cliente cliente);

    public Optional<Cliente> listarClientePorId(Long id) throws DataNotFoundException;

    public List<Cliente> listarClientes();

    public void eliminarClientePorId(Long id);

    public Cliente actualizarCliente(Cliente cliente, Long id) throws DataNotFoundException;
    * */

    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO);

    public Optional<ProyectoDTO> listarProyectoPorId(Long id) throws DataNotFoundException;

    public List<ProyectoDTO> listarProyectos();

    public ProyectoDTO actualizarProyecto(ProyectoDTO proyectoDTO, Long id) throws DataNotFoundException;

    public void deleteProyecto(Long id) throws DataNotFoundException;
}
