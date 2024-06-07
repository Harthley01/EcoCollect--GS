package br.com.fiap.global.dto.response;

import lombok.Builder;

import java.util.Date;


@Builder
public record UsuarioResponse(
        Long idUsuario,
        String nrCpf,
        String nrRg,
        Date dtNascimento,
        String flSexo,
        PontosResponse pontos
) {}
