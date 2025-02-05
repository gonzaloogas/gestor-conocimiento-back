package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.repository.ClienteRepository;
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
public class ClienteServiceImpl implements ClienteService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(ClienteServiceImpl.class);

    @Autowired
    private JwtExtract jwtExtract;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó al cliente {}", name, cliente);

        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> listarClientePorId(Long id) throws DataNotFoundException {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó al cliente con id: {}", name, id);

        return Optional.ofNullable(clienteRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Cliente no encontrado")));
    }

    @Override
    public List<Cliente> listarClientes() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó a todos los clientes.", name);

        return clienteRepository.findAll();
    }

    @Override
    public void eliminarClientePorId(Long id) {

    }

    @Override
    public Cliente actualizarCliente(Cliente cliente, Long id) throws DataNotFoundException {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("(ANTES) {} Actualizó al Cliente con id : {}, Cliente:  {}", name, id, cliente);

        Cliente clienteBD = clienteRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Cliente no encontrado"));
        clienteBD.setActivo(cliente.getActivo());
        clienteBD.setRubro(cliente.getRubro());
        clienteBD.setRazonSocial(cliente.getRazonSocial());

        logger.info("(DESPUES) {} Actualizó al Cliente con id : {}, Cliente:  {}", name, id, clienteBD);

        return clienteRepository.save(clienteBD);
    }
}
