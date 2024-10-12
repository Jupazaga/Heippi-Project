package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MedicoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "id is mandatory")
    private String id;
    @NotBlank(message = "nombre is mandatory")
    private String nombre;
    private String direccion;
}
