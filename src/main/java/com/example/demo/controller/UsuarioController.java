package com.example.demo.controller;

import com.example.demo.controller.dto.RecoveryDTO;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.domain.Recovery;
import com.example.demo.domain.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsers());
    }
    @PostMapping
    public ResponseEntity<Void> postUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    public ResponseEntity<Void> requestRecovery(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.requestPasswordReset(usuarioDTO);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestBody RecoveryDTO recoveryDTO) {
        usuarioService.resetPassword(recoveryDTO);
        return ResponseEntity.noContent().build();
    }
}
