package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogoHabilidadTecnologicaService {

    public CatalogoConocimiento crearHabilidadTecnologica(CatalogoConocimiento habilidadTecnologica);

    public Optional<CatalogoConocimiento> listarHabilidadTecnologicaPorId(Long id);

    public List<CatalogoConocimiento> listarHabilidades();
}
