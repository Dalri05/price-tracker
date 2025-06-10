package com.joaod.price_tracker.feature.usuario.repository;

import com.joaod.price_tracker.feature.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

    public Usuario findByUsername(String username);

}
