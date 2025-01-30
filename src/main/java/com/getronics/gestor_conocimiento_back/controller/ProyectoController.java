package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.exception.DataNotFoundException;
import com.getronics.gestor_conocimiento_back.model.Cliente;
import com.getronics.gestor_conocimiento_back.model.Proyecto;
import com.getronics.gestor_conocimiento_back.service.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @PostMapping("/crear")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<Proyecto> crearProyecto(@Valid @RequestBody Proyecto proyecto){
        return new ResponseEntity<Proyecto>(proyectoService.crearProyecto(proyecto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<Proyecto> actualizarProyecto(@Valid @RequestBody Proyecto proyecto,@PathVariable Long id) throws DataNotFoundException {
        return new ResponseEntity<>(proyectoService.actualizarProyecto(proyecto, id),HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<List<Proyecto>> listarProyectos(){
        return new ResponseEntity<>(proyectoService.listarProyectos(),HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<Optional<Proyecto>> listarProyecto(@PathVariable Long id) throws DataNotFoundException {
        return new ResponseEntity<>(proyectoService.listarProyectoPorId(id),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("('administrador_client_role')")
    public ResponseEntity<String> eliminarProyectoPorId(@PathVariable("id") Long id) throws DataNotFoundException {
        proyectoService.deleteProyecto(id);
        return new ResponseEntity<>("Profesional eliminado con exito",HttpStatus.OK);
    }

}
