package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import com.getronics.gestor_conocimiento_back.repository.ProfesionalIdiomaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Para buscar el nombre de la persona en el jwt


//logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalIdiomaServiceImpl implements ProfesionalIdiomaService {

    //Para el log
    private static final Logger logger =LogManager.getLogger(ProfesionalIdiomaServiceImpl.class);



    private ProfesionalIdiomaRepository idiomaRepository;

    @Override
    public IdiomaProfesional crearIdioma(IdiomaProfesional idioma) {



        return idiomaRepository.save(idioma);
    }

    @Override
    public Optional<IdiomaProfesional> listarIdiomaPorId(Long id) {



        return idiomaRepository.findById(id);
    }

    @Override
    public List<IdiomaProfesional> listarIdiomas() {



        return idiomaRepository.findAll();
    }
}
