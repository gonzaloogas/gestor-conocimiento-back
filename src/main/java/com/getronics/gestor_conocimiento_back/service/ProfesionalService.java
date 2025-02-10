package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.dto.ProfesionalDTO;
import com.getronics.gestor_conocimiento_back.dto.ProfesionalProyectoDTO;
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

    public ProfesionalDTO crearProfesional(ProfesionalDTO profesionalDTO) throws DataNotFoundException;

    public Optional<ProfesionalDTO> listarProfesionalPorId(Long id) throws DataNotFoundException;

    public List<ProfesionalDTO> listarProfesionales();

    public void eliminarProfesionalPorId(Long id);

    public ProfesionalDTO actualizarProfesional(ProfesionalDTO profesionalDTO, Long id) throws  DataNotFoundException;

    public void asignarProfesionalProyecto(ProfesionalProyectoDTO profesionalProyectoDTO);
}
