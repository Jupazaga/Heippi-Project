package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private Usuario usuario;
    private String nombre;
    private String direccion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;
}
