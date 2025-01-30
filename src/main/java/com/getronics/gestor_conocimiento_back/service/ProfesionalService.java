package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.Profesional;
import com.getronics.gestor_conocimiento_back.model.ProfesionalProyecto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface ProfesionalService {

    public Profesional crearProfesional(Profesional profesional) throws DataNotFoundException;

    public Optional<Profesional> listarProfesionalPorId(Long id) throws DataNotFoundException;

    public List<Profesional> listarProfesionales();

    public void eliminarProfesionalPorId(Long id);

    public Profesional actualizarProfesional(Profesional profesional, Long id) throws  DataNotFoundException;

    public void asignarProfesionalProyecto(ProfesionalProyecto profesionalProyecto);
}
