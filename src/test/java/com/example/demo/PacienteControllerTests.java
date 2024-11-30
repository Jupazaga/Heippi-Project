package com.example.demo;

import com.example.demo.controller.PacienteController;
import com.example.demo.controller.dto.PacienteDTO;
import com.example.demo.controller.mapper.PacienteMapper;
import com.example.demo.domain.Paciente;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.samples.PacientesSamples;
import com.example.demo.samples.UsuariosSamples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PacienteControllerTests {
    @Autowired
    private PacienteController pacienteController;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private PacienteMapper pacienteMapper;

    @Test
    @DisplayName("Should create a Paciente and return OK")
    public void createPaciente() {
        Usuario usuario = new UsuariosSamples().usuarioTest1();
        usuariosRepository.save(usuario);

        PacienteDTO pacienteDTO = new PacientesSamples().pacienteDTOTest1();
        ResponseEntity<Void> response = pacienteController.createPaciente(pacienteDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Paciente paciente = pacienteRepository.findById(pacienteDTO.getId()).orElse(null);
        assertNotNull(paciente);
        assertEquals(pacienteDTO.getId(), paciente.getId());
        assertEquals(pacienteDTO.getNombre(), paciente.getNombre());
        assertEquals(pacienteDTO.getDireccion(), paciente.getDireccion());
        assertEquals(pacienteDTO.getFechaNacimiento(), paciente.getFechaNacimiento());
    }

    @Test
    @DisplayName("Should get all Pacientes and return OK")
    public void getAllPacientes() {
        Paciente paciente1 = new PacientesSamples().pacienteTest1();
        Paciente paciente2 = new PacientesSamples().pacienteTest2();
        List<Paciente> pacientes = Arrays.asList(paciente1, paciente2);
        pacienteRepository.saveAll(pacientes);

        ResponseEntity<List<PacienteDTO>> response = pacienteController.getPaciente();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<PacienteDTO> pacienteDTOs = response.getBody();
        assertNotNull(pacienteDTOs);
        assertEquals(pacienteDTOs.size(), pacientes.size());

        PacienteDTO paciente1DTO = pacienteMapper.pacienteToPacienteDTO(paciente1);
        PacienteDTO paciente2DTO = pacienteMapper.pacienteToPacienteDTO(paciente2);

        assertEquals(paciente1DTO, pacienteDTOs.get(0));
        assertEquals(paciente2DTO, pacienteDTOs.get(1));
    }
}
