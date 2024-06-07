package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PontosRequest(
        @NotNull(message = "Quantidade de pontos é obrigatória")
        Integer qtPontos,

        @NotBlank(message = "Atributo 2 é obrigatório")
        String atributo2
) {}
