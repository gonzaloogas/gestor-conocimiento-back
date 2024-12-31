package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class EstadoProfesional {



    private String estado;
    private String motivo;
}
