package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import com.getronics.gestor_conocimiento_back.repository.ProfesionalIdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalIdiomaServiceImpl implements ProfesionalIdiomaService {

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
