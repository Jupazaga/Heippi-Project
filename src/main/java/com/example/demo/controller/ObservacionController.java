package com.example.demo.controller;

import com.example.demo.domain.Observacion;
import com.example.demo.service.ObservacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/observaciones")
public class ObservacionController {
    private final ObservacionService observacionService;
    public ObservacionController(ObservacionService observacionService) {
        this.observacionService = observacionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getObservacionesMedicas(@PathVariable Long id) {
        observacionService.getObservacion(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<Void> createObservacionesMedicas(@RequestBody Observacion observacion) {
        observacionService.createObservacion(observacion);
        return ResponseEntity.ok().build();
    }
}
