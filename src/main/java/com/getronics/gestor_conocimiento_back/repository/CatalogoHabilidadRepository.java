package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.CatalogoConocimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoHabilidadRepository extends JpaRepository<CatalogoConocimiento, Long> {
}
