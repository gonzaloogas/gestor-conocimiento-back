package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.Idioma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IdiomaService {

    public List<Idioma> listarIdiomas();
}
