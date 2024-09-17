package com.example.demo.repository;

import com.example.demo.domain.Observacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObservacionRepository extends CrudRepository<Observacion, Long> {
    List<Observacion> findAllByPacienteId(String paciente_id);

    List<Observacion> findAllByMedicoId(String s);

    List<Observacion> findAllByHospitalId(String id);
}
