package com.example.demo.config;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AuthenticationConfig implements UserDetailsService {
    private final UsuariosRepository usuariosRepository;
    public AuthenticationConfig(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuariosRepository.findUsuarioByIdentificacion(username);
        if (!usuario.isActivado()){
            throw new UsernameNotFoundException("Usuario no activado");
        }
        return createSpringSecurityUser(usuario);
    }

    private User createSpringSecurityUser(Usuario usuario) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getAuthority().toString()));
        return new User(usuario.getIdentificacion(), usuario.getPassword(), authorities);
    }
}
