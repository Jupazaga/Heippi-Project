package com.example.demo.controller;

import com.example.demo.controller.dto.MedicoDTO;
import com.example.demo.domain.Medico;
import com.example.demo.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getMedico() {
        return ResponseEntity.ok(
                medicoService.getAllMedicos()
        );
    }
    @PostMapping
    public ResponseEntity<Void> createMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        medicoService.create(medicoDTO);
        return ResponseEntity.ok().build();
    }
}
