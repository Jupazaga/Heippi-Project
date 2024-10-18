package com.example.demo.service;

import com.example.demo.controller.dto.RecoveryDTO;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.controller.mapper.UsuarioMapper;
import com.example.demo.domain.Recovery;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.RecoveryRepository;
import com.example.demo.repository.UsuariosRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class UsuarioService {
    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;
    private final RecoveryRepository recoveryRepository;
    private final EmailService emailService;
    private final HttpServletRequest request;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(
            UsuariosRepository usuariosRepository,
            PasswordEncoder passwordEncoder,
            RecoveryRepository recoveryRepository,
            EmailService emailService,
            HttpServletRequest request,
            UsuarioMapper usuarioMapper) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
        this.recoveryRepository = recoveryRepository;
        this.emailService = emailService;
        this.request = request;
        this.usuarioMapper = usuarioMapper;

    }
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        usuariosRepository.save(usuarioMapper.UsuarioDTOtoUsuario(usuarioDTO));
    }

    public List<UsuarioDTO> findAllUsers() {
        return usuarioMapper.usuariosToUsuarioDTOs(usuariosRepository.findAll());
    }

    public void requestPasswordReset(UsuarioDTO usuarioDTO) {
        String email = usuarioDTO.getEmail();
        Optional<Usuario> usuario = Optional.ofNullable(usuariosRepository.findUsuarioByEmail(email));

        if(usuario.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        String token = UUID.randomUUID().toString();
        Recovery passwordResetToken = new Recovery();

        passwordResetToken.setUsuario(usuario.get());
        passwordResetToken.setToken(token);
        passwordResetToken.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        recoveryRepository.save(passwordResetToken);

        String text = "Seems you forgot your password ! \n To reset your password, use this link: \n" + request.getContextPath() + "?token=" + token ;
        emailService.sendSimpleMessage("DevelopApp@gmail.com", email, "PasswordRecovery", text);
    }

    public void resetPassword(RecoveryDTO recoveryDTO) {

        Optional<Recovery> optionalRecovery = Optional.ofNullable(recoveryRepository.findRecoveryByToken(recoveryDTO.getToken()));
        if(optionalRecovery.isEmpty()) {
            throw new RuntimeException("Recovery token no encontrado");
        }

        Recovery recoveryToken = optionalRecovery.get();

        if(recoveryToken.getExpiration().before(new Date(System.currentTimeMillis()))) {
            throw new RuntimeException("Recovery token expired");
        }

        Usuario usuario = recoveryToken.getUsuario();
        usuario.setPassword(passwordEncoder.encode(recoveryDTO.getPassword()));
        usuariosRepository.save(usuario);
        recoveryRepository.delete(recoveryToken);
    }
}
