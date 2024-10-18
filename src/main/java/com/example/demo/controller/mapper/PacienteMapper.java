package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.PacienteDTO;
import com.example.demo.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteMapper {
    public Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        return paciente;
    }
    public PacienteDTO pacienteToPacienteDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        return pacienteDTO;
    }

    public List<PacienteDTO> pacientesToPacientesDTO(Iterable<Paciente> all) {
        List<PacienteDTO> pacientesDTO = new ArrayList<>();
        for (Paciente paciente : all) {
            pacientesDTO.add(pacienteToPacienteDTO(paciente));
        }
        return pacientesDTO;
    }
}
