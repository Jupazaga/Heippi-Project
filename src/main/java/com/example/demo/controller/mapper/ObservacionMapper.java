package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.ObservacionDTO;
import com.example.demo.domain.Hospital;
import com.example.demo.domain.Medico;
import com.example.demo.domain.Observacion;
import com.example.demo.domain.Paciente;
import org.springframework.stereotype.Service;

@Service
public class ObservacionMapper {
    public Observacion observacionDTOtoObservacion(ObservacionDTO observacionDTO) {
        Observacion observacion = new Observacion();

        Paciente paciente = new Paciente();
        paciente.setId(observacionDTO.getIdPaciente());
        observacion.setPaciente(paciente);

        Medico medico = new Medico();
        medico.setId(observacionDTO.getIdMedico());
        observacion.setMedico(medico);

        Hospital hospital = new Hospital();
        hospital.setId(observacionDTO.getIdHospital());
        observacion.setHospital(hospital);

        observacion.setDescripcion(observacionDTO.getDescripcion());
        observacion.setEstadoSalud(observacionDTO.getEstadoSalud());
        observacion.setEspecialidad(observacionDTO.getEspecialidad());
        return observacion;
    }

    public ObservacionDTO observacionToObservacionDTO(Observacion observacion) {
        ObservacionDTO observacionDTO = new ObservacionDTO();
        observacionDTO.setIdPaciente(observacion.getPaciente().getId());
        observacionDTO.setIdMedico(observacion.getMedico().getId());
        observacionDTO.setIdHospital(observacion.getHospital().getId());
        observacionDTO.setDescripcion(observacion.getDescripcion());
        observacionDTO.setEstadoSalud(observacion.getEstadoSalud());
        observacionDTO.setEspecialidad(observacion.getEspecialidad());
        return observacionDTO;
    }
}
