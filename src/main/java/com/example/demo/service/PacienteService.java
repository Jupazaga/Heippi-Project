package com.example.demo.service;

import com.example.demo.domain.Paciente;
import com.example.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    public void crearPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}
