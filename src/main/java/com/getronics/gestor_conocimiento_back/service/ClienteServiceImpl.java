package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.ClienteNotFoundException;
import com.getronics.gestor_conocimiento_back.exception.HabilidadNotFoundException;
import com.getronics.gestor_conocimiento_back.exception.ProfesionalNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> listarClientePorId(Long id) throws ClienteNotFoundException {
        return Optional.ofNullable(clienteRepository.findById(id).
                orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado")));
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void eliminarClientePorId(Long id) {

    }

    @Override
    public Cliente actualizarCliente(Cliente cliente, Long id) throws ClienteNotFoundException {

        Cliente clienteBD = clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
        clienteBD.setActivo(cliente.getActivo());
        clienteBD.setRubro(cliente.getRubro());
        clienteBD.setRazonSocial(cliente.getRazonSocial());
        return clienteRepository.save(clienteBD);
    }
}
