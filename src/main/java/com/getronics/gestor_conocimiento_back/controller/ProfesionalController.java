package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import com.getronics.gestor_conocimiento_back.service.ProfesionalHabilidadService;
import com.getronics.gestor_conocimiento_back.service.ProfesionalIdiomaService;
import com.getronics.gestor_conocimiento_back.service.ProfesionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesional")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfesionalController {

    @Autowired
    private ProfesionalService profesionalService;
    private ProfesionalIdiomaService idiomaService;
    private ProfesionalHabilidadService habilidadService;

    @PostMapping("/crear")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<Profesional> crearProfesional(@Valid @RequestBody Profesional profesional) throws DataNotFoundException {
        return new ResponseEntity<>(profesionalService.crearProfesional(profesional), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<Profesional> actualizarProfesional(@Valid @RequestBody Profesional profesional,@PathVariable Long id) throws DataNotFoundException {
        return new ResponseEntity<>(profesionalService.actualizarProfesional(profesional, id),HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    @PreAuthorize("hasRole('profesional_client_role') or hasRole('administrador_client_role') or hasRole('operador_client_role')")
    public ResponseEntity<Optional<Profesional>> listarProfesionalPorId(@PathVariable("id") Long id) throws DataNotFoundException {
        return new ResponseEntity<>(profesionalService.listarProfesionalPorId(id),HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    @PreAuthorize("hasRole('operador_client_role') or hasRole('administrador_client_role')")
    public ResponseEntity<List<Profesional>> listarProfesional(){
        return new ResponseEntity<>(profesionalService.listarProfesionales(),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('administrador_client_role')")
    public ResponseEntity<String> eliminarProfesionalPorId(@PathVariable("id") Long id){
        profesionalService.eliminarProfesionalPorId(id);
        return new ResponseEntity<>("Profesional eliminado con exito",HttpStatus.OK);
    }
}
