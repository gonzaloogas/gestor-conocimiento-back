package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import com.getronics.gestor_conocimiento_back.repository.CatalogoIdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IdiomaService{

    @Autowired
    private CatalogoIdiomaRepository idiomaRepository;

    @Override
    public List<CatalogoIdioma> listarIdiomas() {
        return idiomaRepository.findAll();
    }
}
