package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import com.getronics.gestor_conocimiento_back.service.CatalogoHabilidadTecnologicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilidadesTecnologicas")
@CrossOrigin(origins = "http://localhost:3000")
public class CatalogoHabilidadesController {

    @Autowired
    private CatalogoHabilidadTecnologicaService catalogoHabilidadTecnologicaService;

    @PostMapping("/crear")
    public ResponseEntity<CatalogoConocimiento> crearHabilidad(@Valid @RequestBody CatalogoConocimiento habilidad){        ;

        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.crearHabilidadTecnologica(habilidad), HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<CatalogoConocimiento>> listarHabilidades(@PathVariable("id") Long id){  ;
        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.listarHabilidadTecnologicaPorId(id), HttpStatus.CREATED);
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<CatalogoConocimiento>> listarHabilidades(){
        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.listarHabilidades(),HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CatalogoConocimiento> actualizarHabilidad(CatalogoConocimiento habilidadTecnologica, Long id ){

        return null;
    }
}
