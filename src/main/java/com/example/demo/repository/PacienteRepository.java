package com.example.demo.repository;

import com.example.demo.domain.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, String> {
}
