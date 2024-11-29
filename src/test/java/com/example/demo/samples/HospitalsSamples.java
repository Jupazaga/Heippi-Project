package com.example.demo.samples;

import com.example.demo.controller.dto.HospitalDTO;
import com.example.demo.domain.Hospital;

public class HospitalsSamples {
    private final String id1 = "1111",
        nombre1 = "test1",
        direccion1 = "direccion 1",
        serviciosMedicos1 = "Servicios Medicos 1",

        id2 = "2222",
        nombre2 = "test2",
        direccion2 = "direccion 2",
        serviciosMedicos2 = "Servicios Medicos 2";

    public HospitalDTO hospitalDTOTest1(){
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setId(id1);
        hospitalDTO.setNombre(nombre1);
        hospitalDTO.setDireccion(direccion1);
        hospitalDTO.setServiciosMedicos(serviciosMedicos1);
        return hospitalDTO;
    }
    public HospitalDTO HospitalDTOTest2(){
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setId(id2);
        hospitalDTO.setNombre(nombre2);
        hospitalDTO.setDireccion(direccion2);
        hospitalDTO.setServiciosMedicos(serviciosMedicos2);
        return hospitalDTO;
    }
    public Hospital hospitalTest1(){
        Hospital hospital = new Hospital();
        hospital.setId(id1);
        hospital.setNombre(nombre1);
        hospital.setDireccion(direccion1);
        hospital.setServiciosMedicos(serviciosMedicos1);
        hospital.setUsuario(new UsuariosSamples().usuarioTest1());
        return hospital;
    }

    public Hospital hospitalTest2(){
        Hospital hospital = new Hospital();
        hospital.setId(id2);
        hospital.setNombre(nombre2);
        hospital.setDireccion(direccion2);
        hospital.setServiciosMedicos(serviciosMedicos2);
        hospital.setUsuario(new UsuariosSamples().usuarioTest2());
        return hospital;
    }
}
