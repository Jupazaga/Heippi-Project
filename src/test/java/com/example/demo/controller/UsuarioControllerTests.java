package com.example.demo.controller;

import com.example.demo.controller.dto.EmailUsuarioDTO;
import com.example.demo.controller.dto.RecoveryDTO;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.domain.Recovery;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.RecoveryRepository;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.service.EmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UsuarioControllerTests {
    @Autowired
    private UsuarioController usuarioController;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RecoveryRepository recoveryRepository;
    @Mock
    private EmailService emailService;
    private final UsuariosSamples usuariosSamples = new UsuariosSamples();

    @Test
    @DisplayName("Should create an Usuario and return OK")
    void createUsuario() {
        // Datos del usuario a crear
        UsuarioDTO usuarioDTO = usuariosSamples.usuarioDTOTest1();

        ResponseEntity<Void> response = usuarioController.postUsuario(usuarioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Usuario usuario = usuariosRepository.findUsuarioByIdentificacion(usuarioDTO.getId());
        assertNotNull(usuario);
        assertEquals(usuarioDTO.getEmail(), usuario.getEmail());
        assertTrue(passwordEncoder.matches(usuarioDTO.getPassword(), usuario.getPassword()));
        assertEquals(usuarioDTO.getAuthority(), usuario.getAuthority());
    }

    @Test
    @DisplayName("Should return all Usuarios registered and return OK")
    void getAllUsuarios() {
        Usuario usuario1 = new UsuariosSamples().usuarioTest1();
        Usuario usuario2 = new UsuariosSamples().usuarioTest2();

        usuariosRepository.save(usuario1);
        usuariosRepository.save(usuario2);

        ResponseEntity<List<UsuarioDTO>> response = usuarioController.getUsuarios();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<UsuarioDTO> usuarios = response.getBody();
        assertNotNull(usuarios);
        assertEquals(2 , usuarios.size());

        UsuarioDTO firstUsuario = usuarios.get(0);
        UsuarioDTO lastUsuario = usuarios.get(1);

        assertNotNull(firstUsuario);
        assertEquals(usuario1.getIdentificacion(), firstUsuario.getId());
        assertEquals(usuario1.getEmail(), firstUsuario.getEmail());
        assertNull(firstUsuario.getPassword());
        assertEquals(usuario1.getAuthority(), firstUsuario.getAuthority());

        assertNotNull(lastUsuario);
        assertEquals(usuario2.getIdentificacion(), lastUsuario.getId());
        assertEquals(usuario2.getEmail(), lastUsuario.getEmail());
        assertNull(lastUsuario.getPassword());
        assertEquals(usuario2.getAuthority(), lastUsuario.getAuthority());
    }

    @Test
    @DisplayName("Should activate an Usuario after a creation and return OK")
    void activateUsuario() {

        UsuarioDTO usuarioDTO = new UsuariosSamples().usuarioDTOTest1();

        usuarioController.postUsuario(usuarioDTO);

        Usuario usuarioSaved = usuariosRepository.findUsuarioByIdentificacion(usuarioDTO.getId());
        assertNotNull(usuarioSaved);
        assertEquals(usuarioDTO.getEmail(), usuarioSaved.getEmail());
        assertTrue(passwordEncoder.matches(usuarioDTO.getPassword(), usuarioSaved.getPassword()));
        assertEquals(usuarioDTO.getAuthority(), usuarioSaved.getAuthority());

        ResponseEntity<Void> response = usuarioController.activateUsuario(usuarioSaved.getActivationKey());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Usuario usuarioActivated = usuariosRepository.findUsuarioByIdentificacion(usuarioDTO.getId());
        assertNotNull(usuarioActivated);
        assertEquals(usuarioDTO.getEmail(), usuarioActivated.getEmail());
        assertTrue(passwordEncoder.matches(usuarioDTO.getPassword(), usuarioActivated.getPassword()));
        assertEquals(usuarioDTO.getAuthority(), usuarioActivated.getAuthority());
        assertTrue(usuarioSaved.isActivado());
    }

    @Test
    @DisplayName("Should request a recovery process and update password")
    void requestRecoveryAndUpdatePassword() {
        EmailUsuarioDTO emailUsuarioDTO = new EmailUsuarioDTO();
        Usuario usuario = new UsuariosSamples().usuarioTest1();

        usuariosRepository.save(usuario);

        emailUsuarioDTO.setEmail(usuario.getEmail());

        ResponseEntity<Void> requestRecovery = usuarioController.requestRecovery(emailUsuarioDTO);
        assertEquals(HttpStatus.ACCEPTED, requestRecovery.getStatusCode());

        Recovery recoveryById = recoveryRepository.findById(usuario.getIdentificacion()).get();
        assertNotNull(recoveryById);
        assertNotNull(recoveryById.getToken());

        RecoveryDTO recoveryDTO = new RecoveryDTO();
        recoveryDTO.setToken(recoveryById.getToken());
        String newPassword = "newPassword";
        recoveryDTO.setPassword(newPassword);

        ResponseEntity<Void> responseUpdatePassword = usuarioController.updatePassword(recoveryDTO);
        assertEquals(HttpStatus.NO_CONTENT, responseUpdatePassword.getStatusCode());

        Usuario usuarioUpdated = usuariosRepository.findUsuarioByIdentificacion(usuario.getIdentificacion());
        assertNotNull(usuarioUpdated);
        assertEquals(usuario.getEmail(), usuarioUpdated.getEmail());
        assertTrue(passwordEncoder.matches(newPassword, usuarioUpdated.getPassword()));
        assertEquals(usuario.getAuthority(), usuarioUpdated.getAuthority());
        assertEquals(usuario.isActivado(), usuarioUpdated.isActivado());
    }
}
