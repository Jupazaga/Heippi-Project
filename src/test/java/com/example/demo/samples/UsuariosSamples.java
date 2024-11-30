package com.example.demo.samples;

import com.example.demo.config.Authorities;
import com.example.demo.controller.dto.UsuarioDTO;
import com.example.demo.domain.Usuario;

public class UsuariosSamples {
    private final String
            identificaionTest1 = "1111",
            emailTest1 = "test1@test.com",
            passwordTest1 = "123456",
            telefonoTest1 = "123456789";
    private final Authorities authorityTest1 = Authorities.HOSPITAL;

    private final String
            identificaionTest2 = "2222",
            emailTest2 = "test2@test.com",
            passwordTest2 = "1234567",
            telefonoTest2 = "1123456789";
    private final Authorities authorityTest2 = Authorities.HOSPITAL;

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
