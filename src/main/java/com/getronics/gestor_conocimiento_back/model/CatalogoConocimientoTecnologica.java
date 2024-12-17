package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="habilidad_tecnologica")
public class CatalogoConocimientoTecnologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotEmpty(message = "El valor del campo nombre no puede ser vacío")
    private String nombre;

    @NotNull (message = "El campo categoría no puede ser nulo")
    @NotEmpty(message = "El valor del campo categoría no puede ser vacío")
    private String categoria;

    @NotNull (message = "El campo descripcion no puede ser nulo")
    @NotEmpty(message = "El valor del campo descripcion no puede ser vacío")
    private String descripcion;

}
