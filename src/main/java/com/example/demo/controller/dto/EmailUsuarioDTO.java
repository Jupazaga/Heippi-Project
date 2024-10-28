package com.example.demo.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmailUsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;
}
