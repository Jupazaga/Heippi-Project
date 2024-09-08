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
    private Boolean passwordChanged;
}
