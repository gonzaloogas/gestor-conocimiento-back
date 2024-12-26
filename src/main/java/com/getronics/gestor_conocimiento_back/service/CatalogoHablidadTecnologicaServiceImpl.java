package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimientoTecnologico;
import com.getronics.gestor_conocimiento_back.repository.CatalogoHabilidadTecnologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoHablidadTecnologicaServiceImpl implements CatalogoHabilidadTecnologicaService{

    @Autowired
    private CatalogoHabilidadTecnologicaRepository habilidadTecnologicaRepository;

    @Override
    public CatalogoConocimientoTecnologico crearHabilidadTecnologica(CatalogoConocimientoTecnologico habilidadTecnologica) {
        return habilidadTecnologicaRepository.save(habilidadTecnologica);
    }

    @Override
    public Optional<CatalogoConocimientoTecnologico> listarHabilidadTecnologicaPorId(Long id) {
        return habilidadTecnologicaRepository.findById(id);
    }

    @Override
    public List<CatalogoConocimientoTecnologico> listarHabilidades() {
        return habilidadTecnologicaRepository.findAll();
    }
}
