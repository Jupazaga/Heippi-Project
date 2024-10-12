package com.example.demo.controller.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ObservacionDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    private String idPaciente;
    private String idMedico;
    private String idHospital;
    private String descripcion;
    private String estadoSalud;
    private String especialidad;
}
