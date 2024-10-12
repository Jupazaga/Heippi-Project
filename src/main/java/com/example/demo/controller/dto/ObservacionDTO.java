package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ObservacionDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @NotBlank(message = "paciente is mandatory")
    private String idPaciente;
    @NotBlank(message = "medico is mandatory")
    private String idMedico;
    @NotBlank(message = "hospital is mandatory")
    private String idHospital;
    @NotBlank(message = "descripcion is mandatory")
    private String descripcion;
    @NotBlank(message = "estadoSalud is mandatory")
    private String estadoSalud;
    @NotBlank(message = "especialidad is mandatory")
    private String especialidad;
}
