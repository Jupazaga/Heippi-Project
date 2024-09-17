package com.example.demo.domain;

import com.example.demo.config.Authorities;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Usuario implements Serializable {
    @Id
    private String identificacion;
    private String email;
    private String telefono;
    private String password;
    @Enumerated(EnumType.STRING)
    private Authorities authority;
}