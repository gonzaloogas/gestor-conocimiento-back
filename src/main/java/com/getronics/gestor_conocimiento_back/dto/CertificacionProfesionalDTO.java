package com.getronics.gestor_conocimiento_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificacionProfesionalDTO {

    //Para evitar que el campo 'id' se incluya en el JSON de salida
    @JsonIgnore
    private Long id;
    private String nombreCertificacion;
    private String institucionEmisora;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private String codigoCertificado;

}
