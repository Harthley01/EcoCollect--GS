package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioRequest(
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Login é obrigatório")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        String senha
) {}
