package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo rut no puede ser nulo")
    @NotEmpty(message = "El valor del campo rut no puede ser vacío")
    private String rut;

    @NotNull (message = "El campo razon social no puede ser nulo")
    @NotEmpty(message = "El valor del campo razon social no puede ser vacío")
    @Column(name = "razon_social")
    private String razonSocial;

    @NotNull (message = "El campo rubro no puede ser nulo")
    @NotEmpty(message = "El valor del campo rubro no puede ser vacío")
    private String rubro;

    private Boolean activo;

    @OneToMany(targetEntity = Profesional.class, fetch = FetchType.EAGER, mappedBy ="cliente", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Profesional> profesionales = new ArrayList<>();

}
