package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.model.HabilidadTecnologica;
import com.getronics.gestor_conocimiento_back.service.HabilidadTecnologicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilidadesTecnologicas")
public class HabilidadesTecnologicasController {

    @Autowired
    private HabilidadTecnologicaService habilidadTecnologicaService;

    @PostMapping("/crear")
    public ResponseEntity<HabilidadTecnologica> crearHabilidad(@Valid @RequestBody HabilidadTecnologica habilidad, BindingResult bindingResult){        ;

        return new ResponseEntity<>(habilidadTecnologicaService.crearHabilidadTecnologica(habilidad), HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<HabilidadTecnologica>> listarHabilidades(@PathVariable("id") Long id){  ;
        return new ResponseEntity<>(habilidadTecnologicaService.listarHabilidadTecnologicaPorId(id), HttpStatus.CREATED);
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<HabilidadTecnologica>> listarHabilidades(){
        return new ResponseEntity<>(habilidadTecnologicaService.listarHabilidades(),HttpStatus.OK);
    }
}
