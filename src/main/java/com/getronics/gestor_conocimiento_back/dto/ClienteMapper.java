package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO aDTO(Cliente cliente);

    Cliente aEntidad(ClienteDTO clienteDTO);

    List<ClienteDTO> aListaDTO(List<Cliente> clientes);
    List<Cliente> aListaEntidad(List<ClienteDTO> clienteDTOs);
}