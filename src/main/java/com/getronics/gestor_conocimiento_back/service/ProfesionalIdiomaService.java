package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.ProfesionalIdioma;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfesionalIdiomaService {

    public ProfesionalIdioma crearIdioma(ProfesionalIdioma idioma);
    public Optional<ProfesionalIdioma> listarIdiomaPorId(Long id);
    public List<ProfesionalIdioma> listarIdiomas();
}
