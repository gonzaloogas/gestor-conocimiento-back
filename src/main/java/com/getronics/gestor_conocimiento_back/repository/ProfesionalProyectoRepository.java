package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.ProfesionalProyecto;
import com.getronics.gestor_conocimiento_back.model.ProfesionalProyectoId;
import com.getronics.gestor_conocimiento_back.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesionalProyectoRepository extends JpaRepository<ProfesionalProyecto, ProfesionalProyectoId> {
}
