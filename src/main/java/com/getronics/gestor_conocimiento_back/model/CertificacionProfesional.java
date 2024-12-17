package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="certificacion_profesional")
public class CertificacionProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo nombre certificacion no puede ser nulo")
    @NotEmpty(message = "El valor del campo nombre certificacion no puede ser vacío")
    @Column(name = "nombre_certificacion")
    private String nombreCertificacion;

    @NotNull (message = "El campo institucion emisora no puede ser nulo")
    @NotEmpty(message = "El valor del campo institucion emisora no puede ser vacío")
    @Column(name = "institucion_emisora")
    private String institucionEmisora;

    @NotNull (message = "El campo fecha emision no puede ser nulo")
    @Column(name = "fecha_emision")
    private LocalDate fechaEmision;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Profesional profesional;
}
