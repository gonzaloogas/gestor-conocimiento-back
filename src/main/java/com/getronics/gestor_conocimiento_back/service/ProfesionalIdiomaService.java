package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfesionalIdiomaService {

    public IdiomaProfesional crearIdioma(IdiomaProfesional idioma);
    public Optional<IdiomaProfesional> listarIdiomaPorId(Long id);
    public List<IdiomaProfesional> listarIdiomas();
}
