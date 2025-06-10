package com.joaod.price_tracker.feature.usuario.service;

import com.joaod.price_tracker.feature.usuario.dto.UsuarioDTO;
import com.joaod.price_tracker.feature.usuario.entity.Usuario;
import com.joaod.price_tracker.feature.usuario.repository.UsuarioRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;
import java.util.Objects;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO findByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return UsuarioDTO.builder()
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .tipoUsuario(usuario.getTipoUsuario())
                .senha(usuario.getSenha())
                .build();
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {

        if (StringUtils.isBlank(usuarioDTO.getUsername()) || StringUtils.isBlank(usuarioDTO.getEmail()) || StringUtils.isBlank(usuarioDTO.getSenha())) {
            throw new IllegalArgumentException("Os campos username, email e senha são obrigatórios.");
        }

        Usuario usuario = Usuario.builder()
                .username(usuarioDTO.getUsername())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .tipoUsuario(usuarioDTO.getTipoUsuario())
                .build();

        usuarioRepository.save(usuario);

        return usuarioDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getSenha(),
                Collections.emptyList()
        );
    }
}