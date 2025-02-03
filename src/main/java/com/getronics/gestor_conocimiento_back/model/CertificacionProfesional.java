package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="certificacion_profesional")
public class CertificacionProfesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El valor del campo nombre certificacion no puede ser vacío")
    @Column(name = "nombre_certificacion")
    private String nombreCertificacion;

    @NotEmpty(message = "El valor del campo institucion emisora no puede ser vacío")
    @Column(name = "institucion_emisora")
    private String institucionEmisora;

    @Column(name = "fecha_emision")
    private LocalDate fechaEmision;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "codigo_certificado")
    private String codigoCertificado;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Profesional profesional;

    @Override
    public String toString() {

        return  "{ nombreCertificacion = '" + nombreCertificacion + '\'' +
                ", institucionEmisora = '" + institucionEmisora + '\'' +
                ", fechaEmision = '" + fechaEmision + '\'' +
                ", fechaVencimiento = '" + fechaVencimiento + '\'' +
                ", codigoCertificado = '" + codigoCertificado + '\'' +
                '}';

    }
}
