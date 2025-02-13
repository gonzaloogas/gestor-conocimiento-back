package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.repository.ClienteRepository;
//import com.getronics.gestor_conocimiento_back.util.JwtExtract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt


//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(ClienteServiceImpl.class);



    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {



        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> listarClientePorId(Long id) throws DataNotFoundException {



        return Optional.ofNullable(clienteRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Cliente no encontrado")));
    }

    @Override
    public List<Cliente> listarClientes() {



        return clienteRepository.findAll();
    }

    @Override
    public void eliminarClientePorId(Long id) {

    }

    @Override
    public Cliente actualizarCliente(Cliente cliente, Long id) throws DataNotFoundException {



        Cliente clienteBD = clienteRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Cliente no encontrado"));
        clienteBD.setActivo(cliente.getActivo());
        clienteBD.setRubro(cliente.getRubro());
        clienteBD.setRazonSocial(cliente.getRazonSocial());



        return clienteRepository.save(clienteBD);
    }
}
