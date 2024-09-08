package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Paciente{
    @Id
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Usuario usuario;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
}
