package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.dto.ClienteDTO;
import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/crear")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<ClienteDTO> crearCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.crearCliente(clienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/listarTodos")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return new ResponseEntity<>(clienteService.listarClientes(),HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<Optional<ClienteDTO>> listarClientePorId(@PathVariable("id") Long id) throws DataNotFoundException {
        return new ResponseEntity<>(clienteService.listarClientePorId(id),HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<ClienteDTO> actualizarCliente(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Long id) throws DataNotFoundException {

        return new ResponseEntity<>(clienteService.actualizarCliente(clienteDTO,id),HttpStatus.OK);
    }
}