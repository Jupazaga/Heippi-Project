package com.example.demo.controller;

import com.example.demo.domain.Usuario;
import com.example.demo.service.UsuarioService;
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
    public List<Usuario> getUsuarios() {
        return usuarioService.findAllUsers();
    }
    @PostMapping
    public ResponseEntity<Void> postUsuario(@RequestBody Usuario usuario) {

        usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok().build();
    }
}
