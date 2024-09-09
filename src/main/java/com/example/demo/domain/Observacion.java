package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Observacion {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Hospital hospital;
    private String descripcion;
    private String estadoSalud;
    private String especialidad;
}
