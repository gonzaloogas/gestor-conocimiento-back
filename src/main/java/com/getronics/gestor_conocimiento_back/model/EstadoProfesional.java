package com.getronics.gestor_conocimiento_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum EstadoProfesional {
    ACTIVO,
    ACTIVO_SIN_ASIGNACION,
    INACTIVO_SIN_RESTRICCION,
    INACTIVO_CON_RESTRICCION
}