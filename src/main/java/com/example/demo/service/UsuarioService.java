package com.example.demo.service;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UsuarioService {
    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;
    public UsuarioService(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void crearUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuariosRepository.save(usuario);
    }

    public Iterable<Usuario> findAllUsers() {
        return usuariosRepository.findAll();
    }
}
