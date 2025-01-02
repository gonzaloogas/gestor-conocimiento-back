package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.ReferenciaProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenciaRepository extends JpaRepository<ReferenciaProfesional, Long> {
}
