package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfesionalService {

    public Profesional crearProfesional(Profesional profesional) throws ClienteNotFoundException;

    public Optional<Profesional> listarProfesionalPorId(Long id) throws ProfesionalNotFoundException;

    public List<Profesional> listarProfesionales();

    public void eliminarProfesionalPorId(Long id);

    public Profesional actualizarProfesional(Profesional profesional, Long id) throws ProfesionalNotFoundException, HabilidadNotFoundException, IdiomaNotFoundException, FormacionAcademicaNotFoundException, ClienteNotFoundException;
}
