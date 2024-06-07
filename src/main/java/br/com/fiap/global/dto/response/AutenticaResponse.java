package br.com.fiap.global.dto.response;

public record AutenticaResponse(
        Long idAutentica,
        String login,
        String senha,
        String statusLogin
) {}
