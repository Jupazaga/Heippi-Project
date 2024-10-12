package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.MedicoDTO;
import com.example.demo.domain.Medico;
import org.springframework.stereotype.Service;

@Service
public class MedicoMapper {
    public Medico medicoDTOToMedico(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setId(medicoDTO.getId());
        medico.setNombre(medicoDTO.getNombre());
        medico.setDireccion( medicoDTO.getDireccion());
        return medico;
    }

    public MedicoDTO medicoToMedicoDTO(Medico medico) {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setId(medico.getId());
        medicoDTO.setNombre(medico.getNombre());
        medicoDTO.setDireccion(medico.getDireccion());
        return medicoDTO;
    }
}
