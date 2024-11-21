package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.Idioma;
import com.getronics.gestor_conocimiento_back.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IdiomaService{

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Override
    public List<Idioma> listarIdiomas() {
        return idiomaRepository.findAll();
    }
}
