package com.example.demo.controller;

import com.example.demo.controller.dto.PacienteDTO;
import com.example.demo.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public String getPaciente(){
        return "Paciente";
    }

    @PostMapping
    public ResponseEntity<Void> createPaciente(@Valid @RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok().build();
    }
}
