package com.getronics.gestor_conocimiento_back.service;




import com.getronics.gestor_conocimiento_back.dto.ClienteDTO;
import com.getronics.gestor_conocimiento_back.dto.ClienteMapper;
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
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó al cliente {}", name, clienteDTO);


        Cliente entidadAGuardar = ClienteMapper.mapper.aEntidad(clienteDTO);

        Cliente entidadGuardada = clienteRepository.save(entidadAGuardar);

        return ClienteMapper.mapper.aDTO(entidadGuardada);

    }

    @Override
    public Optional<ClienteDTO> listarClientePorId(Long id) throws DataNotFoundException {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó al cliente con id: {}", name, id);

        return Optional.ofNullable(clienteRepository.findById(id)
                .map(ClienteMapper.mapper::aDTO)
                .orElseThrow(() -> new DataNotFoundException("Cliente no encontrado")));
    }

    @Override
    public List<ClienteDTO> listarClientes() {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("{} creó a todos los clientes.", name);

        return ClienteMapper.mapper.aListaDTO(clienteRepository.findAll());
    }

    @Override
    public void eliminarClientePorId(Long id) {

    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO, Long id) throws DataNotFoundException {

        String name = jwtExtract.getAuthenticatedUserNameFromJwt("name");
        logger.info("(ANTES) {} Actualizó al Cliente con id : {}, Cliente:  {}", name, id, clienteDTO);

        Cliente clienteBD = clienteRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Cliente no encontrado"));
        clienteBD.setActivo(clienteDTO.getActivo());
        clienteBD.setRubro(clienteDTO.getRubro());
        clienteBD.setRazonSocial(clienteDTO.getRazonSocial());

        Cliente clienteActualizado = clienteRepository.save(clienteBD);

        logger.info("(DESPUES) {} Actualizó al Cliente con id : {}, Cliente:  {}", name, id, clienteActualizado);

        return ClienteMapper.mapper.aDTO(clienteActualizado);
    }
}
