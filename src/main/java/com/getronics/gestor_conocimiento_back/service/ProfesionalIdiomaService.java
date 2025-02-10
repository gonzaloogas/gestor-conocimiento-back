package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.IdiomaDTO;
import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfesionalIdiomaService {

    public IdiomaDTO crearIdioma(IdiomaDTO idiomaDTO);
    public Optional<IdiomaDTO> listarIdiomaPorId(Long id);
    public List<IdiomaDTO> listarIdiomas();
}
