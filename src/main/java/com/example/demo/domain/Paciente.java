package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Paciente {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private Usuario usuario;
    private String nombre;
    private String direccion;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
}
