package com.example.demo.service;

import com.example.demo.controller.dto.MedicoDTO;
import com.example.demo.controller.mapper.MedicoMapper;
import com.example.demo.domain.Medico;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;
    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper, UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void create(MedicoDTO medicoDTO) {
        Medico medico = medicoMapper.medicoDTOToMedico(medicoDTO);
        Usuario usuario = usuariosRepository.findUsuarioByIdentificacion(medicoDTO.getId());
        usuario.setPassword(passwordEncoder.encode(medicoDTO.getNewPassword()));
        medico.setUsuario(usuario);
        medicoRepository.save(medico);
    }

    public List<MedicoDTO> getAllMedicos() {
        return medicoMapper.medicosToMedicosDTO(medicoRepository.findAll());
    }
}
