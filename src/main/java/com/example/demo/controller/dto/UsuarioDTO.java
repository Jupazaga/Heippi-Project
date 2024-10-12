package com.example.demo.controller.dto;

import com.example.demo.config.Authorities;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UsuarioDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String email;
    private String telefono;
    private String password;
    private Authorities authority;

}
