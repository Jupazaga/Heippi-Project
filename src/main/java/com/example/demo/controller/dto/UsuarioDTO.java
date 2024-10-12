package com.example.demo.controller.dto;

import com.example.demo.config.Authorities;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UsuarioDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    @Email
    @NotBlank(message = "email is mandatory")
    private String email;
    private String telefono;
    @NotBlank(message = "password is mandatory")
    private String password;
    @NotBlank
    private Authorities authority;

}
