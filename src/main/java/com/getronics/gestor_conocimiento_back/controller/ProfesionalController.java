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
    public ResponseEntity<Profesional> crearProfesional(@Valid @RequestBody Profesional profesional) throws ClienteNotFoundException {
        IdiomaProfesional idioma = new IdiomaProfesional();
        return new ResponseEntity<>(profesionalService.crearProfesional(profesional), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesional> actualizarProfesional(@Valid @RequestBody Profesional profesional,@PathVariable Long id) throws ProfesionalNotFoundException, HabilidadNotFoundException, FormacionAcademicaNotFoundException, IdiomaNotFoundException, ClienteNotFoundException {

        return new ResponseEntity<>(profesionalService.actualizarProfesional(profesional, id),HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<Profesional>> listarProfesionalPorId(@PathVariable("id") Long id) throws ProfesionalNotFoundException {
        return new ResponseEntity<>(profesionalService.listarProfesionalPorId(id),HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Profesional>> listarProfesional(){
        return new ResponseEntity<>(profesionalService.listarProfesionales(),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarProfesionalPorId(@PathVariable("id") Long id){
        profesionalService.eliminarProfesionalPorId(id);
        return new ResponseEntity<>("Profesional eliminado con exito",HttpStatus.OK);
    }

}
