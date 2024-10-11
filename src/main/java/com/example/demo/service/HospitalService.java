package com.example.demo.service;

import com.example.demo.controller.dto.HospitalDTO;
import com.example.demo.controller.mapper.HospitalMapper;
import com.example.demo.domain.Hospital;
import com.example.demo.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalService {
    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalMapper = new HospitalMapper();
    }

    public void createHospital(HospitalDTO hospitalDTO) {
        hospitalRepository.save(hospitalMapper.hospitalDTOtoHospital(hospitalDTO));
    }

    public Iterable<Hospital> getListHospitals() {
        return hospitalRepository.findAll();
    }
}
