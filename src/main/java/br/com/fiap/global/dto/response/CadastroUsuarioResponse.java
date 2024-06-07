package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record CadastroUsuarioResponse(
        Long idCadastroUsuario,
        String email,
        String login,
        String senha
) {}
