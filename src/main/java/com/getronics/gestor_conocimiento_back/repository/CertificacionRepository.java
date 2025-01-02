package com.getronics.gestor_conocimiento_back.repository;

import com.getronics.gestor_conocimiento_back.model.CertificacionProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificacionRepository extends JpaRepository<CertificacionProfesional,Long> {
}
