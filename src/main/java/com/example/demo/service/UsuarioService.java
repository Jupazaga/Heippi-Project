package com.example.demo.service;

import com.example.demo.controller.dto.EmailUsuarioDTO;
import com.example.demo.controller.dto.RecoveryDTO;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.controller.mapper.UsuarioMapper;
import com.example.demo.domain.Recovery;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.RecoveryRepository;
import com.example.demo.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
    private final UsuarioMapper usuarioMapper;
    private final Environment environment;

    public UsuarioService(
            UsuariosRepository usuariosRepository,
            PasswordEncoder passwordEncoder,
            RecoveryRepository recoveryRepository,
            EmailService emailService,
            UsuarioMapper usuarioMapper, Environment environment) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
        this.recoveryRepository = recoveryRepository;
        this.emailService = emailService;
        this.usuarioMapper = usuarioMapper;
        this.environment = environment;
    }
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario newUsuario = usuarioMapper.UsuarioDTOtoUsuario(usuarioDTO);
        newUsuario.setActivationKey(UUID.randomUUID().toString());
        String host = "localhost";
        try{
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Host not found, using 'localhost' as fallback");
        }

        String text = "Hey, before you start, remember activate your account with the next link: "
                + host + ":" + environment.getProperty("server.port")  + "/usuarios/?key="
                + newUsuario.getActivationKey();
        emailService.sendSimpleMessage("DevelopApp@gmail.com", usuarioDTO.getEmail(), "New Account registered", text);
        usuariosRepository.save(newUsuario);
    }

    public List<UsuarioDTO> findAllUsers() {
        return usuarioMapper.usuariosToUsuarioDTOs(usuariosRepository.findAll());
    }

    public void requestPasswordReset(EmailUsuarioDTO emailUsuarioDTO) {
        String email = emailUsuarioDTO.getEmail();
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

        String text = "Seems you forgot your password ! \n" +
                "To reset your password, copy the next token " +
                token;
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

    public void activateUsuario(String key) {
        Optional<Usuario> usuario = Optional.ofNullable(usuariosRepository.findByActivationKey(key));
        if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario newUsuario = usuario.get();
        newUsuario.setActivado(true);
        newUsuario.setActivationKey(null);
        usuariosRepository.save(newUsuario);
    }
}
