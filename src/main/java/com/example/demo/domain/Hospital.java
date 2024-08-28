package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hospital {
    @Id
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Usuario usuario;
    private String serviciosMedicos;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medico> medicos;
}
