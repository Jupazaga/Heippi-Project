package com.example.demo.controller;

import com.example.demo.domain.Paciente;
import com.example.demo.service.PacienteService;
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
    public ResponseEntity<Void> createPaciente(@RequestBody Paciente paciente){
        pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok().build();
    }
}
