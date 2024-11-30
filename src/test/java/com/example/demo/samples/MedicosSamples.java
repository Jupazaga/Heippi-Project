package com.example.demo.samples;

import com.example.demo.controller.dto.MedicoDTO;
import com.example.demo.domain.Medico;
import com.example.demo.domain.Usuario;

public class MedicosSamples {
    private final
        String nombre1 = "medico1",
        direccion1 = "direccion1",

        nombre2 = "medico2",
        direccion2 = "direccion2";

    public Medico medicoTest1(){
        Usuario usuarioTest1 = new UsuariosSamples().usuarioTest1();
        Medico medico = new Medico();
        medico.setId(usuarioTest1.getIdentificacion());
        medico.setNombre(nombre1);
        medico.setDireccion(direccion1);
        medico.setUsuario(usuarioTest1);
        return medico;
    }

    public Medico medicoTest2(){
        Usuario usuarioTest2 = new UsuariosSamples().usuarioTest2();
        Medico medico = new Medico();
        medico.setId(usuarioTest2.getIdentificacion());
        medico.setNombre(nombre2);
        medico.setDireccion(direccion2);
        medico.setUsuario(usuarioTest2);
        return medico;
    }

    public MedicoDTO medicoDTOTest1(){
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setId(new UsuariosSamples().usuarioTest1().getIdentificacion());
        medicoDTO.setNombre(nombre1);
        medicoDTO.setDireccion(direccion1);
        medicoDTO.setNewPassword("123456");
        return medicoDTO;
    }

    public MedicoDTO medicoDTOTest2(){
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setId(new UsuariosSamples().usuarioTest2().getIdentificacion());
        medicoDTO.setNombre(nombre2);
        medicoDTO.setDireccion(direccion2);
        medicoDTO.setNewPassword("1234567");
        return medicoDTO;
    }
}
