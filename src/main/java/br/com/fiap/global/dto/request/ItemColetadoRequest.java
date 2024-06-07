package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemColetadoRequest(
        @NotBlank(message = "Nome do item é obrigatório")
        String nomeItem,

        @NotBlank(message = "Tipo do item é obrigatório")
        String tipoItem,

        @NotNull(message = "Valor em pontos é obrigatório")
        Integer valorEmPontos
) {}
