package com.example.demo.service;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuariosRepository usuariosRepository;
    public UsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }
    public void crearUsuario(Usuario usuario) {
        usuariosRepository.save(usuario);
    }

    public Iterable<Usuario> findAllUsers() {
        return usuariosRepository.findAll();
    }
}
