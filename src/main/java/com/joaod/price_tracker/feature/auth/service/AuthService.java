package com.joaod.price_tracker.feature.auth.service;

import com.joaod.price_tracker.config.JwtUtil;
import com.joaod.price_tracker.feature.auth.dto.LoginDTO;
import com.joaod.price_tracker.feature.usuario.dto.UsuarioDTO;
import com.joaod.price_tracker.feature.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UsuarioDTO createAccount(UsuarioDTO usuarioDTO) {
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuarioDTO.setTipoUsuario(1);

        return usuarioService.criarUsuario(usuarioDTO);
    }

    public String login(LoginDTO loginDTO) {
        UsuarioDTO usuarioDTO = usuarioService.findByUsername(loginDTO.getUsername());
        if (usuarioDTO != null && passwordEncoder.matches(loginDTO.getSenha(), usuarioDTO.getSenha())) {
            return jwtUtil.generateToken(usuarioDTO.getUsername());
        }

        throw new RuntimeException("Invalid username or password");
    }
}
