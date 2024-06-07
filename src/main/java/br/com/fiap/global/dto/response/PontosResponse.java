package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record PontosResponse(
        Long idPontos,
        Integer qtPontos,
        String atributo2
) {}
