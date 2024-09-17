package com.example.demo.service;

import com.example.demo.config.Authorities;
import com.example.demo.domain.Observacion;
import com.example.demo.repository.ObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ObservacionService {
    private final ObservacionRepository observacionRepository;
    public ObservacionService(ObservacionRepository observacionRepository) {
        this.observacionRepository = observacionRepository;
    }
    public List<Observacion> getObservacion(String id, Authorities authorities) {
        switch (authorities) {
            case HOSPITAL -> {
                return observacionRepository.findAllByHospitalId(id);
            }
            case MEDICO -> {
                return observacionRepository.findAllByMedicoId(id);
            }
            case PACIENTE -> {
                return observacionRepository.findAllByPacienteId(id);
            }
            default -> {return null;}
        }
    }

    public void createObservacion(Observacion observacion) {
        observacionRepository.save(observacion);
    }
}
