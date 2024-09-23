package com.example.demo.controller;

import com.example.demo.config.Authorities;
import com.example.demo.domain.Observacion;
import com.example.demo.service.ObservacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/observaciones")
public class ObservacionController {
    private final ObservacionService observacionService;
    public ObservacionController(ObservacionService observacionService) {
        this.observacionService = observacionService;
    }

    @GetMapping
    public ResponseEntity<List<Observacion>> getObservacionesMedicas(Authentication authentication) {
        return ResponseEntity.ok().body(observacionService.getObservacion(authentication));
    }
    @PostMapping
    public ResponseEntity<Void> createObservacionesMedicas(@RequestBody Observacion observacion) {
        observacionService.createObservacion(observacion);
        return ResponseEntity.ok().build();
    }
}
