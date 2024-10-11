package com.example.demo.controller.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class HospitalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String direccion;
    private String serviciosMedicos;

}