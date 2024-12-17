package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="Idiomas")
@Data
public class CatalogoIdioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotEmpty(message = "El valor del campo nombre no puede ser vacío")
    private String nombre;

    @NotNull (message = "El campo código iso no puede ser nulo")
    @NotEmpty(message = "El valor del campo código iso no puede ser vacío")
    @Column(name = "codigo_iso")
    private String codigoISO;
}
