package com.example.demo.controller;

import com.example.demo.controller.dto.ObservacionDTO;
import com.example.demo.domain.Observacion;
import com.example.demo.service.ObservacionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> createObservacionesMedicas(@Valid @RequestBody ObservacionDTO observacionDTO) {
        observacionService.createObservacion(observacionDTO);
        return ResponseEntity.ok().build();
    }
}
