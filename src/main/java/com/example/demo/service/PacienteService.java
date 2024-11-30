package com.example.demo.service;

import com.example.demo.controller.dto.PacienteDTO;
import com.example.demo.controller.mapper.PacienteMapper;
import com.example.demo.domain.Paciente;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    private final UsuariosRepository usuariosRepository;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper, UsuariosRepository usuariosRepository) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
        this.usuariosRepository = usuariosRepository;
    }
    public void crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.pacienteDTOToPaciente(pacienteDTO);
        paciente.setUsuario(usuariosRepository.findUsuarioByIdentificacion(paciente.getId()));
        pacienteRepository.save(paciente);
    }

    public List<PacienteDTO> getAllPacientes() {
        return pacienteMapper.pacientesToPacientesDTO(pacienteRepository.findAll());
    }
}
