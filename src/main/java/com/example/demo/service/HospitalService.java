package com.example.demo.service;

import com.example.demo.domain.Hospital;
import com.example.demo.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public void createHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public Iterable<Hospital> getListHospitals() {
        return hospitalRepository.findAll();
    }
}
