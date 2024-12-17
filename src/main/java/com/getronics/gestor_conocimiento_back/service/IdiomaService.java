package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IdiomaService {

    public List<CatalogoIdioma> listarIdiomas();
}
