package com.getronics.gestor_conocimiento_back.controller;

import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import com.getronics.gestor_conocimiento_back.service.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/idiomas")
@CrossOrigin(origins = "http://localhost:3000")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping("/listar")
    public ResponseEntity<List<CatalogoIdioma>> listarIdiomas(){
        return new ResponseEntity<>(idiomaService.listarIdiomas(),HttpStatus.OK);
    }
}
