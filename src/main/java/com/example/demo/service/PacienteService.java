package com.example.demo.service;

import com.example.demo.controller.dto.PacienteDTO;
import com.example.demo.controller.mapper.PacienteMapper;
import com.example.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }
    public void crearPaciente(PacienteDTO pacienteDTO) {
        pacienteRepository.save(pacienteMapper.pacienteDTOToPaciente(pacienteDTO));
    }
}
