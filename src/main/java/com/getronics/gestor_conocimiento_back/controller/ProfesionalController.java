package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.model.ProfesionalIdioma;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import com.getronics.gestor_conocimiento_back.service.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesional")
public class ProfesionalController {

    @Autowired
    private ProfesionalService profesionalService;

    @PostMapping("/crear")
    public ResponseEntity<Profesional> crearEmpleado(@RequestBody Profesional profesional){
        ProfesionalIdioma idioma = new ProfesionalIdioma();
        return new ResponseEntity<>(profesionalService.crearProfesional(profesional), HttpStatus.CREATED);
    }
    
    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<Profesional>> listarProfesionalPorId(@PathVariable("id") Long id){
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
