package com.example.demo;

import com.example.demo.controller.MedicoController;
import com.example.demo.controller.dto.MedicoDTO;
import com.example.demo.controller.mapper.MedicoMapper;
import com.example.demo.domain.Medico;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.samples.MedicosSamples;
import com.example.demo.samples.UsuariosSamples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Transactional
public class MedicoControllerTests {
    @Autowired
    private MedicoController medicoController;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    @Test
    @DisplayName("Should create a Medico and return OK")
    public void createMedico() {
        MedicoDTO medicoDTO = new MedicosSamples().medicoDTOTest1();
        Usuario usuario = new UsuariosSamples().usuarioTest1();
        usuariosRepository.save(usuario);
        ResponseEntity<Void> response = medicoController.createMedico(medicoDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Medico medico = medicoRepository.findById(medicoDTO.getId()).orElse(null);
        assertNotNull(medico);

        Usuario usuarioUpdated = usuariosRepository.findUsuarioByIdentificacion(medico.getId());
        assertEquals(medicoDTO.getNombre(), medico.getNombre());
        assertEquals(medicoDTO.getDireccion(), medico.getDireccion());
        assertTrue(passwordEncoder.matches(medicoDTO.getNewPassword(), usuarioUpdated.getPassword()));

    }

    @Test
    @DisplayName("Should get all Medicos created and return OK")
    public void getAllMedicos() {
        Medico medico1 = new MedicosSamples().medicoTest1();
        Medico medico2 = new MedicosSamples().medicoTest2();
        List<Medico> medicos = Arrays.asList(medico1, medico2);
        medicoRepository.saveAll(medicos);

        ResponseEntity<List<MedicoDTO>> response = medicoController.getMedico();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<MedicoDTO> medicoDTOList = response.getBody();
        assertNotNull(medicoDTOList);
        assertEquals(medicoDTOList.size(), medicos.size());

        Medico retrievedMedico1 = medicoMapper.medicoDTOToMedico(medicoDTOList.get(0));
        Medico retrievedMedico2 = medicoMapper.medicoDTOToMedico(medicoDTOList.get(1));

        assertEquals(medico1.getId(), retrievedMedico1.getId());
        assertEquals(medico1.getNombre(), retrievedMedico1.getNombre());
        assertEquals(medico1.getDireccion(), retrievedMedico1.getDireccion());

        assertEquals(medico2.getId(), retrievedMedico2.getId());
        assertEquals(medico2.getNombre(), retrievedMedico2.getNombre());
        assertEquals(medico2.getDireccion(), retrievedMedico2.getDireccion());
    }
}
