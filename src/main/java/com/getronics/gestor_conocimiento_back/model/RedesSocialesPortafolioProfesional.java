package com.getronics.gestor_conocimiento_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "rr_ss_portafolio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedesSocialesPortafolioProfesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "enlace")
    private String url;

    @ManyToOne(targetEntity = Profesional.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Profesional profesional;
}
