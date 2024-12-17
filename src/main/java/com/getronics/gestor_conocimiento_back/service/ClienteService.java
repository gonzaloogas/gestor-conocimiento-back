package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);

    public Optional<Cliente> listarClientePorId(Long id) throws ClienteNotFoundException;

    public List<Cliente> listarClientes();

    public void eliminarClientePorId(Long id);

    public Cliente actualizarCliente(Cliente cliente, Long id) throws ClienteNotFoundException;

}
