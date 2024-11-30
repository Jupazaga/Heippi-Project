package com.example.demo;

import com.example.demo.controller.ObservacionController;
import com.example.demo.controller.dto.ObservacionDTO;
import com.example.demo.controller.mapper.ObservacionMapper;
import com.example.demo.domain.Hospital;
import com.example.demo.domain.Medico;
import com.example.demo.domain.Observacion;
import com.example.demo.domain.Paciente;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.repository.ObservacionRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.samples.HospitalsSamples;
import com.example.demo.samples.MedicosSamples;
import com.example.demo.samples.ObservacionsSamples;
import com.example.demo.samples.PacientesSamples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ObservacionControllerTests {
    @Autowired
    private ObservacionController observacionController;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private ObservacionRepository observacionRepository;
    @Autowired
    private ObservacionMapper observacionMapper;

    @Test
    @DisplayName("Should create an Observacion and return OK")
    public void createObservacion() {
        Hospital hospital = new HospitalsSamples().hospitalTest1();
        hospitalRepository.save(hospital);

        Medico medico = new MedicosSamples().medicoTest1();
        medicoRepository.save(medico);

        Paciente paciente = new PacientesSamples().pacienteTest1();
        pacienteRepository.save(paciente);

        ObservacionDTO observacionDTO = new ObservacionsSamples().observacionDTOTest1();
        ResponseEntity<Void> response = observacionController.createObservacionesMedicas(observacionDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Observacion> observacionList = observacionRepository.findAllByPacienteId(observacionDTO.getIdPaciente());
        assertNotNull(observacionList);
        assertEquals(1, observacionList.size());

        Observacion observacion = observacionList.get(0);
        assertEquals(observacionDTO.getIdHospital(), observacion.getHospital().getId());
        assertEquals(observacionDTO.getIdMedico(), observacion.getMedico().getId());
        assertEquals(observacionDTO.getIdPaciente(), observacion.getPaciente().getId());
        assertEquals(observacionDTO.getDescripcion(), observacion.getDescripcion());
        assertEquals(observacionDTO.getEstadoSalud(), observacion.getEstadoSalud());
        assertEquals(observacionDTO.getEspecialidad(), observacion.getEspecialidad());
    }

    @Test
    @DisplayName("Should get all observaciones created and return OK")
    public void getAllObservaciones() {
        Hospital hospital1 = new HospitalsSamples().hospitalTest1();
        Hospital hospital2 = new HospitalsSamples().hospitalTest2();
        List<Hospital> hospitalList = Arrays.asList(hospital1, hospital2);
        hospitalRepository.saveAll(hospitalList);

        Medico medico1 = new MedicosSamples().medicoTest1();
        Medico medico2 = new MedicosSamples().medicoTest2();
        List<Medico> medicoList = Arrays.asList(medico1, medico2);
        medicoRepository.saveAll(medicoList);

        Paciente paciente1 = new PacientesSamples().pacienteTest1();
        Paciente paciente2 = new PacientesSamples().pacienteTest2();
        List<Paciente> pacienteList = Arrays.asList(paciente1, paciente2);
        pacienteRepository.saveAll(pacienteList);

        Observacion observacion1 = new ObservacionsSamples().observacionTest1();
        Observacion observacion2 = new ObservacionsSamples().observacionTest2();
        List<Observacion> observacionList = Arrays.asList(observacion1, observacion2);
        observacionRepository.saveAll(observacionList);

        Authentication authentication = mock(Authentication.class);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("HOSPITAL");
        when(authentication.getName()).thenReturn(hospital1.getId());
        when(authentication.getAuthorities()).thenAnswer(invocation -> Collections.singletonList(grantedAuthority));

        ResponseEntity<List<ObservacionDTO>> response1 = observacionController.getObservacionesMedicas(authentication);
        assertEquals(HttpStatus.OK, response1.getStatusCode());

        List<ObservacionDTO> observacionDTOList = response1.getBody();
        assertNotNull(observacionDTOList);
        assertEquals(1, observacionDTOList.size());
        ObservacionDTO observacionDTO1 = observacionMapper.observacionToObservacionDTO(observacion1);
        assertTrue(observacionDTOList.contains(observacionDTO1));

        when(authentication.getName()).thenReturn(hospital2.getId());
        when(authentication.getAuthorities()).thenAnswer(invocation -> Collections.singletonList(grantedAuthority));

        ResponseEntity<List<ObservacionDTO>> response2 = observacionController.getObservacionesMedicas(authentication);
        assertEquals(HttpStatus.OK, response2.getStatusCode());
        observacionDTOList = response2.getBody();
        assertNotNull(observacionDTOList);
        assertEquals(1, observacionDTOList.size());
        ObservacionDTO observacionDTO2 = observacionMapper.observacionToObservacionDTO(observacion2);
        assertTrue(observacionDTOList.contains(observacionDTO2));

    }
}
