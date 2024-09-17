package com.example.demo.service;

import com.example.demo.domain.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicoService {
    private final MedicoRepository medicoRepository;
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    public void create(Medico medico) {
        medicoRepository.save(medico);
    }

    public List<Medico> getAllMedicos() {
        return (List<Medico>) medicoRepository.findAll();
    }
}
