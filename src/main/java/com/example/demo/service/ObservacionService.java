package com.example.demo.service;

import com.example.demo.domain.Observacion;
import com.example.demo.repository.ObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class ObservacionService {
    private final ObservacionRepository observacionRepository;
    public ObservacionService(ObservacionRepository observacionRepository) {
        this.observacionRepository = observacionRepository;
    }
    public void getObservacion(Long id) {

    }

    public void createObservacion(Observacion observacion) {
        observacionRepository.save(observacion);
    }
}
