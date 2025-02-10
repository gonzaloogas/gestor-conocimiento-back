package com.getronics.gestor_conocimiento_back.dto;

import com.getronics.gestor_conocimiento_back.model.EstadoProfesional;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProfesionalDTO {


    private String rut;

    private String nombres;

    private String aPaterno;

    private String aMaterno;

    private LocalDate fechaNacimiento;

    private String nacionalidad;

    private String direccion;

    private String telefono;

    private String correoElectronico;

    private Integer anioExperiencia;

    @Lob
    private String perfilProfesional;

    private String nivelExperiencia;

    private LocalDate fechaIngresoGetronics;
    private LocalDate fechaEgresoGetronics;
    private Boolean referido;
    private EstadoProfesional estadoProfesional;
    private byte[] fotografia;

    private List<HabilidadProfesionalDTO> conocimientoProfesional;
    private List<FormacionAcademicaProfesionalDTO> formacionAcademicaProfesional;
    private List<IdiomaDTO> idiomasProfesional;
    private List<ExperienciaLaboralProfesionalDTO> experienciaLaboralProfesional;
    private List<CertificacionProfesionalDTO> certificacionProfesional;
    private List<ReferenciaProfesionalDTO> referenciaProfesional;
    private List<PublicacionesLogrosAcademicosProfesionalDTO> publicacionesProfesional;
    private List<RedesSocialesPortafolioProfesionalDTO> rrssPortafolioProfesional;
    private JefeServicioDTO jefeServicio;
}
