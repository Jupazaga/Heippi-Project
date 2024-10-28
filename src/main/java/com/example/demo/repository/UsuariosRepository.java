package com.example.demo.repository;

import com.example.demo.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuario, String> {
    Usuario findUsuarioByIdentificacion(String username);

    Usuario findUsuarioByEmail(String email);

    Usuario findByActivationKey(String key);
}
