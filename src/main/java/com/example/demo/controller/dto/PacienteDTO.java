package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Data
public class PacienteDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String id;
    @NotBlank
    private String nombre;
    private String direccion;
    @NotBlank
    private Date fechaNacimiento;
}
