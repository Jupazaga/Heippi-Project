package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Hospital implements Serializable {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_hospital")
    private Usuario usuario;
    private String nombre;
    private String direccion;
    private String serviciosMedicos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Medico> medicos;
}
