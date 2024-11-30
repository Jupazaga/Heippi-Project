package com.example.demo.samples;

import com.example.demo.controller.dto.ObservacionDTO;
import com.example.demo.domain.Observacion;

public class ObservacionsSamples {
    private final
        String idPaciente1 = new PacientesSamples().pacienteTest1().getId(),
        idMedico1 = new MedicosSamples().medicoTest1().getId(),
        idHospital1 = new HospitalsSamples().hospitalTest1().getId(),
        descripcion1 = "descripcion 1",
        estadoSalud1 = "estado salud 1",
        especialidad1 = "especialidad 1",

        idPaciente2 = new PacientesSamples().pacienteTest2().getId(),
        idMedico2 = new MedicosSamples().medicoTest2().getId(),
        idHospital2 = new HospitalsSamples().hospitalTest2().getId(),
        descripcion2 = "descripcion 2",
        estadoSalud2 = "estado salud 2",
        especialidad2 = "especialidad 2";

    public ObservacionDTO observacionDTOTest1(){
        ObservacionDTO observacionDTO = new ObservacionDTO();
        observacionDTO.setIdPaciente(idPaciente1);
        observacionDTO.setIdMedico(idMedico1);
        observacionDTO.setIdHospital(idHospital1);
        observacionDTO.setDescripcion(descripcion1);
        observacionDTO.setEstadoSalud(estadoSalud1);
        observacionDTO.setEspecialidad(especialidad1);
        return observacionDTO;
    }

    public ObservacionDTO observacionDTOTest2(){
        ObservacionDTO observacionDTO = new ObservacionDTO();
        observacionDTO.setIdPaciente(idPaciente2);
        observacionDTO.setIdMedico(idMedico2);
        observacionDTO.setIdHospital(idHospital2);
        observacionDTO.setDescripcion(descripcion2);
        observacionDTO.setEstadoSalud(estadoSalud2);
        observacionDTO.setEspecialidad(especialidad2);
        return observacionDTO;
    }

    public Observacion observacionTest1(){
        Observacion observacion = new Observacion();
        observacion.setPaciente(new PacientesSamples().pacienteTest1());
        observacion.setMedico(new MedicosSamples().medicoTest1());
        observacion.setHospital(new HospitalsSamples().hospitalTest1());
        observacion.setDescripcion(descripcion1);
        observacion.setEstadoSalud(estadoSalud1);
        observacion.setEspecialidad(especialidad1);
        return observacion;
    }

    public Observacion observacionTest2(){
        Observacion observacion = new Observacion();
        observacion.setPaciente(new PacientesSamples().pacienteTest2());
        observacion.setMedico(new MedicosSamples().medicoTest2());
        observacion.setHospital(new HospitalsSamples().hospitalTest2());
        observacion.setDescripcion(descripcion2);
        observacion.setEstadoSalud(estadoSalud2);
        observacion.setEspecialidad(especialidad2);
        return observacion;
    }
}
