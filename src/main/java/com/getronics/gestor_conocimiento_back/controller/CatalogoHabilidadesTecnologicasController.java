package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimientoTecnologica;
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
public class CatalogoHabilidadesTecnologicasController {

    @Autowired
    private CatalogoHabilidadTecnologicaService catalogoHabilidadTecnologicaService;

    @PostMapping("/crear")
    public ResponseEntity<CatalogoConocimientoTecnologica> crearHabilidad(@Valid @RequestBody CatalogoConocimientoTecnologica habilidad){        ;

        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.crearHabilidadTecnologica(habilidad), HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<CatalogoConocimientoTecnologica>> listarHabilidades(@PathVariable("id") Long id){  ;
        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.listarHabilidadTecnologicaPorId(id), HttpStatus.CREATED);
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<CatalogoConocimientoTecnologica>> listarHabilidades(){
        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.listarHabilidades(),HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CatalogoConocimientoTecnologica> actualizarHabilidad(CatalogoConocimientoTecnologica habilidadTecnologica, Long id ){

        return null;
    }
}
