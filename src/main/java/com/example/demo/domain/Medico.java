package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico {
    @Id
    private String id;
    @OneToOne
    @MapsId
    private Usuario usuario;
    private String nombre;
    private String direccion;
    private Boolean passwordChanged;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;
}