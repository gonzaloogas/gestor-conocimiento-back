package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.HabilidadTecnologica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HabilidadTecnologicaService {

    public HabilidadTecnologica crearHabilidadTecnologica(HabilidadTecnologica habilidadTecnologica);

    public Optional<HabilidadTecnologica> listarHabilidadTecnologicaPorId(Long id);

    public List<HabilidadTecnologica> listarHabilidades();
}
