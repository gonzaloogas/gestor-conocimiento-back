package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoIdioma;
import com.getronics.gestor_conocimiento_back.repository.CatalogoIdiomaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt

//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IdiomaService{

    //Para el log
    private static final Logger logger =LogManager.getLogger(IdiomaServiceImpl.class);



    @Autowired
    private CatalogoIdiomaRepository idiomaRepository;

    @Override
    public List<CatalogoIdioma> listarIdiomas() {



        return idiomaRepository.findAll();
    }
}
