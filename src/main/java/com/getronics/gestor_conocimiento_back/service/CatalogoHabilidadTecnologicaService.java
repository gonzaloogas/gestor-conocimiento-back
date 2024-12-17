package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimientoTecnologica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogoHabilidadTecnologicaService {

    public CatalogoConocimientoTecnologica crearHabilidadTecnologica(CatalogoConocimientoTecnologica habilidadTecnologica);

    public Optional<CatalogoConocimientoTecnologica> listarHabilidadTecnologicaPorId(Long id);

    public List<CatalogoConocimientoTecnologica> listarHabilidades();
}
