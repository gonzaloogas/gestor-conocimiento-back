package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import com.getronics.gestor_conocimiento_back.repository.CatalogoHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoHablidadTecnologicaServiceImpl implements CatalogoHabilidadTecnologicaService{

    @Autowired
    private CatalogoHabilidadRepository habilidadTecnologicaRepository;

    @Override
    public CatalogoConocimiento crearHabilidadTecnologica(CatalogoConocimiento habilidadTecnologica) {
        return habilidadTecnologicaRepository.save(habilidadTecnologica);
    }

    @Override
    public Optional<CatalogoConocimiento> listarHabilidadTecnologicaPorId(Long id) {
        return habilidadTecnologicaRepository.findById(id);
    }

    @Override
    public List<CatalogoConocimiento> listarHabilidades() {
        return habilidadTecnologicaRepository.findAll();
    }
}
