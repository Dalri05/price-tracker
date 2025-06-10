package com.joaod.price_tracker.feature.auth.controller;

import com.joaod.price_tracker.feature.auth.dto.LoginDTO;
import com.joaod.price_tracker.feature.auth.service.AuthService;
import com.joaod.price_tracker.feature.usuario.dto.UsuarioDTO;
import com.joaod.price_tracker.shared.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<Object>> register(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(ResponseDTO.builder()
                .data(authService.createAccount(usuarioDTO))
                .statusMessage(HttpStatus.CREATED.getReasonPhrase())
                .statusCode(200)
                .timestamp(LocalDateTime.now())
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<Object>> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(ResponseDTO.builder()
                .data(token)
                .statusMessage(HttpStatus.OK.getReasonPhrase())
                .statusCode(200)
                .timestamp(LocalDateTime.now())
                .build());
    }
}