package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.CatalogoConocimientoDTO;
import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogoHabilidadTecnologicaService {

    public CatalogoConocimientoDTO crearHabilidadTecnologica(CatalogoConocimientoDTO habilidadTecnologica);

    public Optional<CatalogoConocimientoDTO> listarHabilidadTecnologicaPorId(Long id);

    public List<CatalogoConocimientoDTO> listarHabilidades();
}
