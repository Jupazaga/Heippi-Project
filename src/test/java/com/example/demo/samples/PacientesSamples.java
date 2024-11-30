package com.example.demo.samples;

import com.example.demo.controller.dto.PacienteDTO;
import com.example.demo.domain.Paciente;

import java.sql.Date;

public class PacientesSamples {
    private final String id1 = "1111",
        nombre1 = "paciente1",
        direccion1 = "direccion 1",
        fechaNacimiento1 = "2000-01-01",

        id2 = "2222",
        nombre2 = "paciente2",
        direccion2 = "direccion2",
        getFechaNacimiento2 = "2000-01-01";

    public Paciente pacienteTest1(){
        Paciente paciente = new Paciente();
        paciente.setId(id1);
        paciente.setNombre(nombre1);
        paciente.setDireccion(direccion1);
        paciente.setFechaNacimiento(Date.valueOf(fechaNacimiento1));
        paciente.setUsuario(new UsuariosSamples().usuarioTest1());
        return paciente;
    }

    public Paciente pacienteTest2(){
        Paciente paciente = new Paciente();
        paciente.setId(id2);
        paciente.setNombre(nombre2);
        paciente.setDireccion(direccion2);
        paciente.setFechaNacimiento(Date.valueOf(getFechaNacimiento2));
        paciente.setUsuario(new UsuariosSamples().usuarioTest2());
        return paciente;
    }

    public PacienteDTO pacienteDTOTest1(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(id1);
        pacienteDTO.setNombre(nombre1);
        pacienteDTO.setDireccion(direccion1);
        pacienteDTO.setFechaNacimiento(Date.valueOf(fechaNacimiento1));
        return pacienteDTO;
    }

    public PacienteDTO pacienteDTOTest2(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(id2);
        pacienteDTO.setNombre(nombre2);
        pacienteDTO.setDireccion(direccion2);
        pacienteDTO.setFechaNacimiento(Date.valueOf(getFechaNacimiento2));
        return pacienteDTO;
    }
}
