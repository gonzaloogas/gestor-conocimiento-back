package com.getronics.gestor_conocimiento_back.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data

public class ClienteDTO {

    private String rut;
    private String razonSocial;
    private String rubro;
    private Boolean activo;
    private byte[] logo;
    private List<ProyectoDTO> proyectos;  // Evita referencia a entidades dentro del DTO
}