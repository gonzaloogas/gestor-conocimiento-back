package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.ProfesionalIdioma;
import com.getronics.gestor_conocimiento_back.repository.ProfesionalIdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalIdiomaServiceImpl implements ProfesionalIdiomaService {

    private ProfesionalIdiomaRepository idiomaRepository;

    @Override
    public ProfesionalIdioma crearIdioma(ProfesionalIdioma idioma) {
        return idiomaRepository.save(idioma);
    }

    @Override
    public Optional<ProfesionalIdioma> listarIdiomaPorId(Long id) {
        return idiomaRepository.findById(id);
    }

    @Override
    public List<ProfesionalIdioma> listarIdiomas() {
        return idiomaRepository.findAll();
    }
}
