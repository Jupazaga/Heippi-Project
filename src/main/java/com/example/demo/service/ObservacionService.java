package com.example.demo.service;

import com.example.demo.domain.Observacion;
import com.example.demo.repository.ObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Transactional
public class ObservacionService {
    private final ObservacionRepository observacionRepository;
    public ObservacionService(ObservacionRepository observacionRepository) {
        this.observacionRepository = observacionRepository;
    }
    public List<Observacion> getObservacion(Authentication authentication) {
        //Process the Collection of Authorities and get the first element
        GrantedAuthority grantedAuthority = authentication
                .getAuthorities()
                .stream().findFirst()
                .get();

        String id = authentication.getName();
        switch (grantedAuthority.getAuthority()) {
            case "HOSPITAL"-> {
                return observacionRepository.findAllByHospitalId(id);
            }
            case "MEDICO" -> {
                return observacionRepository.findAllByMedicoId(id);
            }
            case "PACIENTE" -> {
                return observacionRepository.findAllByPacienteId(id);
            }
            default -> {return null;}
        }
    }

    public void createObservacion(Observacion observacion) {
        observacionRepository.save(observacion);
    }
}
