package com.example.demo.controller;

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
    public ResponseEntity<Void> postUsuario(@RequestBody Usuario usuario) {

        usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    public ResponseEntity<Void> requestRecovery(@RequestBody Usuario usuario) {
        String email = usuario.getEmail();
        usuarioService.requestPasswordReset(email);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestParam String token, @RequestParam String password) {
        Recovery recovery = new Recovery();
        recovery.setToken(token);
        usuarioService.resetPassword(recovery, password);
        return ResponseEntity.noContent().build();
    }
}
