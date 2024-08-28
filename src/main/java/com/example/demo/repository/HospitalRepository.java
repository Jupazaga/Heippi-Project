package com.example.demo.repository;

import com.example.demo.domain.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, String> {
}
