package com.example.demo.controller.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Data
public class PacienteDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;
}
