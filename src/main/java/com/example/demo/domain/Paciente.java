package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
public class Paciente implements Serializable {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Usuario usuario;
    private String nombre;
    private String direccion;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
}
