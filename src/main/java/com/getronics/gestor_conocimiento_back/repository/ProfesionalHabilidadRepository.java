package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.ConocimientoTecnicoProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionalHabilidadRepository extends JpaRepository<ConocimientoTecnicoProfesional, Long> {
        List<ConocimientoTecnicoProfesional> findByProfesionalId(Long profesionalId);
}
