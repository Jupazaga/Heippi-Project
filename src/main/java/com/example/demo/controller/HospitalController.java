package com.example.demo.controller;

import com.example.demo.domain.Hospital;
import com.example.demo.domain.Usuario;
import com.example.demo.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService hospitalService;
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    @GetMapping
    public String getHospital(){
        return "Hospital";
    }
    @PostMapping
    public ResponseEntity<Void> createHospital(@RequestBody Hospital hospital){
        hospitalService.createHospital(hospital);
        return ResponseEntity.ok().build();
    }
}
