package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.ClienteDTO;
import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {

    public ClienteDTO crearCliente(ClienteDTO clienteDTO);

    public Optional<ClienteDTO> listarClientePorId(Long id) throws DataNotFoundException;

    public List<ClienteDTO> listarClientes();

    public void eliminarClientePorId(Long id);

    public ClienteDTO actualizarCliente(ClienteDTO cliente, Long id) throws DataNotFoundException;

}
