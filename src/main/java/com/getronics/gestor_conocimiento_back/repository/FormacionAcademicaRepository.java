package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.FormacionAcademicaProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormacionAcademicaRepository extends JpaRepository<FormacionAcademicaProfesional, Long> {
}
