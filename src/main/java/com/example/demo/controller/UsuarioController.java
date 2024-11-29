package com.example.demo.controller;

import com.example.demo.controller.dto.EmailUsuarioDTO;
import com.example.demo.controller.dto.RecoveryDTO;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsers());
    }
    @PostMapping
    public ResponseEntity<Void> postUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {

        usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/activation")
    public ResponseEntity<Void> activateUsuario(@RequestBody String key) {
        usuarioService.activateUsuario(key);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    public ResponseEntity<Void> requestRecovery(@Valid @RequestBody EmailUsuarioDTO emailUsuarioDTO) {
        usuarioService.requestPasswordReset(emailUsuarioDTO);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(@Valid @RequestBody RecoveryDTO recoveryDTO) {
        usuarioService.resetPassword(recoveryDTO);
        return ResponseEntity.noContent().build();
    }
}
