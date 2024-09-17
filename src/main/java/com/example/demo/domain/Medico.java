package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Medico implements Serializable {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Usuario usuario;
    private String nombre;
    private String direccion;
    private Boolean passwordChanged;
    @ManyToOne
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;
}
