package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proyectos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;


    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<ProfesionalProyecto> profesionales = new ArrayList<>();
}
