package com.example.demo.domain;

import com.example.demo.config.Authorities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    private String identificacion;
    @Column(unique=true)
    private String email;
    private String telefono;
    private String password;
    @Enumerated(EnumType.STRING)
    private Authorities authority;
    private boolean activado;
    private String activationKey;
}