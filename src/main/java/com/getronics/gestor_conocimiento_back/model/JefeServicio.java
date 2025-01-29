package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="jefe_servicio")
public class JefeServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Profesional.class, fetch = FetchType.EAGER, mappedBy ="jefeServicio", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Profesional> profesionalesAsignados;
}
