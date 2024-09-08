package com.example.demo.controller;

import com.example.demo.domain.Medico;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public String getMedico() {
        return "Medico";
    }
    @PostMapping
    public ResponseEntity<Void> createMedico(@RequestBody Medico medico) {
        medicoService.create(medico);
        return ResponseEntity.ok().build();
    }
}
