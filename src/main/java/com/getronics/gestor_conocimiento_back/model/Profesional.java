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

    @NotNull(message = "El campo rut no puede ser nulo")
    @NotEmpty(message = "El valor del campo rut no puede ser vacío")
    private String rut;

    @NotNull(message = "El campo id sap no puede ser nulo")
    @NotEmpty(message = "El valor del campo id sap no puede ser vacío")
    @Column(name="id_sap")
    private String idSAP;

    @NotNull(message = "El campo nombres no puede ser nulo")
    @NotEmpty(message = "El valor del campo nombres no puede ser vacío")
    private String nombres;

    @NotNull (message = "El campo apellido paterno no puede ser nulo")
    @NotEmpty(message = "El valor del campo apellido paterno no puede ser vacío")
    @Column(name="apellido_paterno")
    private String aPaterno;

    @NotNull (message = "El campo apellido materno no puede ser nulo")
    @NotEmpty(message = "El valor del campo apellido materno no puede ser vacío")
    @Column(name="apellido_materno")
    private String aMaterno;

    @NotNull(message = "El campo fecha de nacimiento no debe ser nulo")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El campo direccion no debe ser nulo")
    @NotEmpty(message = "El valor del campo direccion no debe ser vacio")
    private String direccion;

    @NotNull(message = "El campo telefono no debe ser nulo")
    @NotEmpty(message = "El valor del campo direccion no debe ser vacio")
    private String telefono;

    @NotNull(message = "El campo correo electronico no debe ser nulo")
    @NotEmpty(message = "El valor del campo correo electronico no debe ser vacio")
    @Email
    @Column(name = "correo_electronico")
    private String correoElectronico;


    @NotNull (message = "El campo años de experiencia no puede ser nulo")
    @Column(name="anio_experiencia")
    private Integer anioExperiencia;

    @NotNull (message = "El campo nivel experiencia no puede ser nulo")
    @NotEmpty(message = "El valor del campo nivel experiencia no puede ser vacío")
    private String nivelExperiencia;

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

    @NotNull (message = "El campo fecha ingreso getronics no puede ser nulo")
    private LocalDate fechaIngresoGetronics;

    private LocalDate fechaEgresoGetronics;

    private Boolean activo;

    private Boolean referido;

    private Boolean listaNegra;

    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Override
    public String toString() {

        return "Profesional";
    }
}
