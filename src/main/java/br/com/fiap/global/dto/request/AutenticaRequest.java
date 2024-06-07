package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AutenticaRequest(
        @NotBlank(message = "Login é obrigatório")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        String senha,

        @NotBlank(message = "Status do login é obrigatório")
        String statusLogin
) {}
