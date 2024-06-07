package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record ItemColetadoResponse(
        Long idItem,
        String nomeItem,
        String tipoItem,
        Integer valorEmPontos,
        Long idUsuario
) {}
