package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimientoTecnologico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogoHabilidadTecnologicaService {

    public CatalogoConocimientoTecnologico crearHabilidadTecnologica(CatalogoConocimientoTecnologico habilidadTecnologica);

    public Optional<CatalogoConocimientoTecnologico> listarHabilidadTecnologicaPorId(Long id);

    public List<CatalogoConocimientoTecnologico> listarHabilidades();
}
