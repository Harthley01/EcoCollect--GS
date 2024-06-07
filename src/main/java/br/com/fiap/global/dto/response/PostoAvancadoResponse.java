package br.com.fiap.global.dto.response;

import lombok.Builder;
import java.util.List;

@Builder
public record PostoAvancadoResponse(
        Long idPosto,
        String nomePosto,
        String cidadePosto,
        Integer totalItens
) {}
