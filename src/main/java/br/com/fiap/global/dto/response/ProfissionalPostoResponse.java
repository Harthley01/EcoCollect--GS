package br.com.fiap.global.dto.response;

import lombok.Builder;


@Builder
public record ProfissionalPostoResponse(
        Long idProfissional,
        String nomeProfissional,
        String tipoProfissional,
        String flSexo
) {}
