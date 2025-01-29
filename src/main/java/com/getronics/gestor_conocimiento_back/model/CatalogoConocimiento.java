package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="catalogo_conocimiento")
public class CatalogoConocimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El valor del campo nombre no puede ser vacío")
    private String nombre;

    @NotEmpty(message = "El valor del campo categoría no puede ser vacío")
    private String categoria;

    @NotEmpty(message = "El valor del campo descripcion no puede ser vacío")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoHabilidad tipo;
}
