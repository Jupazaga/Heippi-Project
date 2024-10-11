package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.HospitalDTO;
import com.example.demo.domain.Hospital;
import org.springframework.stereotype.Service;

@Service
public class HospitalMapper {
    public Hospital hospitalDTOtoHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = new Hospital();
        hospital.setId(hospitalDTO.getId());
        hospital.setNombre(hospitalDTO.getNombre());
        hospital.setDireccion(hospitalDTO.getDireccion());
        hospital.setServiciosMedicos(hospitalDTO.getServiciosMedicos());
        return hospital;
    }

    public HospitalDTO hospitalToHospitalDTO(Hospital hospital) {
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setId(hospital.getId());
        hospitalDTO.setNombre(hospital.getNombre());
        hospitalDTO.setDireccion(hospital.getDireccion());
        hospitalDTO.setServiciosMedicos(hospital.getServiciosMedicos());
        return hospitalDTO;
    }
}
