package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.HabilidadTecnologica;
import com.getronics.gestor_conocimiento_back.repository.HabilidadTecnologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HablidadTecnologicaServiceImpl implements HabilidadTecnologicaService{

    @Autowired
    private HabilidadTecnologicaRepository habilidadTecnologicaRepository;

    @Override
    public HabilidadTecnologica crearHabilidadTecnologica(HabilidadTecnologica habilidadTecnologica) {
        return habilidadTecnologicaRepository.save(habilidadTecnologica);
    }

    @Override
    public Optional<HabilidadTecnologica> listarHabilidadTecnologicaPorId(Long id) {
        return habilidadTecnologicaRepository.findById(id);
    }

    @Override
    public List<HabilidadTecnologica> listarHabilidades() {
        return habilidadTecnologicaRepository.findAll();
    }
}
