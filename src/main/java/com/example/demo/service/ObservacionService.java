package com.example.demo.service;

import com.example.demo.controller.dto.ObservacionDTO;
import com.example.demo.controller.mapper.ObservacionMapper;
import com.example.demo.repository.ObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ObservacionService {
    private final ObservacionRepository observacionRepository;
    private final ObservacionMapper observacionMapper;

    public ObservacionService(ObservacionRepository observacionRepository, ObservacionMapper observacionMapper) {
        this.observacionRepository = observacionRepository;
        this.observacionMapper = observacionMapper;
    }
    public List<ObservacionDTO> getObservaciones(Authentication authentication) {
        //Process the Collection of Authorities and get the first element
        GrantedAuthority grantedAuthority = authentication
                .getAuthorities().iterator().next();

        String id = authentication.getName();
        switch (grantedAuthority.getAuthority()) {
            case "HOSPITAL"-> {
                return observacionMapper.observacionesToObservacionesDTOs(observacionRepository.findAllByHospitalId(id));
            }
            case "MEDICO" -> {
                return observacionMapper.observacionesToObservacionesDTOs(observacionRepository.findAllByMedicoId(id));
            }
            case "PACIENTE" -> {
                return observacionMapper.observacionesToObservacionesDTOs(observacionRepository.findAllByPacienteId(id));
            }
            default -> {return null;}
        }
    }

    public void createObservacion(ObservacionDTO observacionDTO) {
        observacionRepository.save(observacionMapper.observacionDTOtoObservacion(observacionDTO));
    }
}
