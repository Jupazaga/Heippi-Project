package com.example.demo.samples;

import com.example.demo.config.Authorities;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.domain.Usuario;

public class UsuariosSamples {
    private final
        String identificaionTest1 = "1111";
        String emailTest1 = "test1@test.com";
        String passwordTest1 = "123456";
        String telefonoTest1 = "123456789";
        Authorities authorityTest1 = Authorities.HOSPITAL;

        String identificaionTest2 = "2222";
        String emailTest2 = "test2@test.com";
        String passwordTest2 = "1234567";
        String telefonoTest2 = "1123456789";
        Authorities authorityTest2 = Authorities.HOSPITAL;

    public UsuarioDTO usuarioDTOTest1() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(identificaionTest1);
        usuarioDTO.setEmail(emailTest1);
        usuarioDTO.setPassword(passwordTest1);
        usuarioDTO.setAuthority(authorityTest1);
        return usuarioDTO;
    }

    public UsuarioDTO usuarioDTOTest2() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(identificaionTest2);
        usuarioDTO.setEmail(emailTest2);
        usuarioDTO.setPassword(passwordTest2);
        usuarioDTO.setAuthority(authorityTest2);
        return usuarioDTO;
    }

    public Usuario usuarioTest1() {
        Usuario usuario = new Usuario();
        usuario.setIdentificacion(identificaionTest1);
        usuario.setEmail(emailTest1);
        usuario.setPassword(passwordTest1);
        usuario.setAuthority(authorityTest1);
        return usuario;
    }

    public Usuario usuarioTest2() {
        Usuario usuario = new Usuario();
        usuario.setIdentificacion(identificaionTest2);
        usuario.setEmail(emailTest2);
        usuario.setPassword(passwordTest2);
        usuario.setAuthority(authorityTest2);
        return usuario;
    }
}
