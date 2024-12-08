package com.example.demo.controller;

import com.example.demo.controller.dto.HospitalDTO;
import com.example.demo.service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService hospitalService;
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    @GetMapping
    public ResponseEntity<List<HospitalDTO>> getHospital(){
        return ResponseEntity.ok(hospitalService.getListHospitals());
    }
    @PostMapping
    public ResponseEntity<Void> createHospital(@Valid @RequestBody HospitalDTO hospitalDTO){
        hospitalService.createHospital(hospitalDTO);
        return ResponseEntity.ok().build();
    }
}
