package com.joaod.price_tracker.feature.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;

    private String username;

    private String email;

    private String senha;

    private Integer tipoUsuario;
}
