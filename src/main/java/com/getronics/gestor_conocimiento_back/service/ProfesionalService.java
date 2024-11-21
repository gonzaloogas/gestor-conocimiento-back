package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.Profesional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfesionalService {

    public Profesional crearProfesional(Profesional profesional);

    public Optional<Profesional> listarProfesionalPorId(Long id);

    public List<Profesional> listarProfesionales();

    public void eliminarProfesionalPorId(Long id);
}
