package com.example.demo.repository;

import com.example.demo.domain.Medico;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<Medico, String> {
}
