package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.IdiomaProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesionalIdiomaRepository extends JpaRepository<IdiomaProfesional, Long> {
}
