package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.dto.CatalogoConocimientoDTO;
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
    public ResponseEntity<CatalogoConocimientoDTO> crearHabilidad(@Valid @RequestBody CatalogoConocimientoDTO habilidadDTO){        ;

        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.crearHabilidadTecnologica(habilidadDTO), HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<CatalogoConocimientoDTO>> listarHabilidades(@PathVariable("id") Long id){  ;
        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.listarHabilidadTecnologicaPorId(id), HttpStatus.CREATED);
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<CatalogoConocimientoDTO>> listarHabilidades(){
        return new ResponseEntity<>(catalogoHabilidadTecnologicaService.listarHabilidades(),HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CatalogoConocimientoDTO> actualizarHabilidad(CatalogoConocimientoDTO habilidadTecnologica, Long id ){

        return null;
    }
}
