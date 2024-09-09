package com.example.demo.repository;

import com.example.demo.domain.Observacion;
import org.springframework.data.repository.CrudRepository;

public interface ObservacionRepository extends CrudRepository<Observacion, Long> {
}
