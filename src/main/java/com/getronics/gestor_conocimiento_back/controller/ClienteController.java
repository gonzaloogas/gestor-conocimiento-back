package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.exception.ClienteNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import com.getronics.gestor_conocimiento_back.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Cliente> crearCliente(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Cliente>> listarClientes(){
        return new ResponseEntity<>(clienteService.listarClientes(),HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<Cliente>> listarClientePorId(@PathVariable("id") Long id) throws ClienteNotFoundException {
        return new ResponseEntity<>(clienteService.listarClientePorId(id),HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@Valid @RequestBody Cliente cliente, @PathVariable Long id) throws ClienteNotFoundException {

        return new ResponseEntity<>(clienteService.actualizarCliente(cliente,id),HttpStatus.OK);
    }

}