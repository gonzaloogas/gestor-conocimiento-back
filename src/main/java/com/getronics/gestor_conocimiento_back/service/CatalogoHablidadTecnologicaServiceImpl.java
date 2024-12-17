package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimientoTecnologica;
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
    public CatalogoConocimientoTecnologica crearHabilidadTecnologica(CatalogoConocimientoTecnologica habilidadTecnologica) {
        return habilidadTecnologicaRepository.save(habilidadTecnologica);
    }

    @Override
    public Optional<CatalogoConocimientoTecnologica> listarHabilidadTecnologicaPorId(Long id) {
        return habilidadTecnologicaRepository.findById(id);
    }

    @Override
    public List<CatalogoConocimientoTecnologica> listarHabilidades() {
        return habilidadTecnologicaRepository.findAll();
    }
}
