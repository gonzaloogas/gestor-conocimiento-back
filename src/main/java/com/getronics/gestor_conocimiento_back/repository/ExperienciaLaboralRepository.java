package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.ExperienciaLaboralProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboralProfesional, Long> {
}
