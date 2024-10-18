package com.example.demo.service;

import com.example.demo.controller.dto.MedicoDTO;
import com.example.demo.controller.mapper.MedicoMapper;
import com.example.demo.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }
    public void create(MedicoDTO medicoDTO) {
        medicoRepository.save(medicoMapper.medicoDTOToMedico(medicoDTO));
    }

    public List<MedicoDTO> getAllMedicos() {
        return medicoMapper.medicosToMedicosDTO(medicoRepository.findAll());
    }
}
