package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="profesionales")
public class Profesional  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_sap")
    private Long idSap;

    @NotNull(message = "El campo rut no puede ser nulo")
    @NotEmpty(message = "El valor del campo rut no puede ser vacío")
    private String rut;

    @NotEmpty(message = "El valor del campo nombres no puede ser vacío")
    private String nombres;

    @NotEmpty(message = "El valor del campo apellido paterno no puede ser vacío")
    @Column(name="apellido_paterno")
    private String aPaterno;

    @NotEmpty(message = "El valor del campo apellido materno no puede ser vacío")
    @Column(name="apellido_materno")
    private String aMaterno;

    @NotNull(message = "El campo fecha de nacimiento no debe ser nulo")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotEmpty(message = "El valor del campo nacionalidad no debe ser vacio")
    private String nacionalidad;

    @NotEmpty(message = "El valor del campo direccion no debe ser vacio")
    private String direccion;

    @NotEmpty(message = "El valor del campo direccion no debe ser vacio")
    private String telefono;

    @Email
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @NotNull (message = "El campo años de experiencia no puede ser nulo")
    @Column(name="anio_experiencia")
    private Integer anioExperiencia;

    @NotEmpty (message = "El campo perfil profesional no puede ser nulo")
    private String perfilProfesional;

    @NotEmpty(message = "El valor del campo nivel experiencia no puede ser vacío")
    private String nivelExperiencia;

    @NotNull (message = "El campo fecha ingreso getronics no puede ser nulo")
    private LocalDate fechaIngresoGetronics;

    private LocalDate fechaEgresoGetronics;

    private Boolean activo;

    private Boolean referido;

    private Boolean listaNegra;

    @Lob
    @Basic(optional = false, fetch = FetchType.EAGER)
    private byte[] fotografia;

    @OneToMany(targetEntity = ConocimientoTecnicoProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ConocimientoTecnicoProfesional> conocimientoTecnicoProfesional = new ArrayList<>();

    @OneToMany(targetEntity = FormacionAcademicaProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FormacionAcademicaProfesional> formacionAcademicaProfesional = new ArrayList<>();

    @OneToMany(targetEntity = IdiomaProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<IdiomaProfesional> idiomasProfesional= new ArrayList<>();

    @OneToMany(targetEntity = ExperienciaLaboralProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ExperienciaLaboralProfesional> experienciaLaboralProfesional= new ArrayList<>();

    @OneToMany(targetEntity = CertificacionProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CertificacionProfesional> certificacionProfesional = new ArrayList<>();

    @OneToMany(targetEntity = ReferenciaProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ReferenciaProfesional> referenciaProfesional = new ArrayList<>();

    @OneToMany(targetEntity = PublicacionesLogrosAcademicosProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PublicacionesLogrosAcademicosProfesional> publicacionesProfesional = new ArrayList<>();

    @OneToMany(targetEntity = RedesSocialesPortafolioProfesional.class, fetch = FetchType.EAGER, mappedBy ="profesional", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RedesSocialesPortafolioProfesional> rrssPortafolioProfesional = new ArrayList<>();

    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
    private List<ProfesionalProyecto> proyectos = new ArrayList<>();

    @ManyToOne(targetEntity = JefeServicio.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private JefeServicio jefeServicio;

    @Override
    public String toString() {

        return "Profesional";
    }
}
