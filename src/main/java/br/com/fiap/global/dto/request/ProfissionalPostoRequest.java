package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record ProfissionalPostoRequest(
        @NotBlank(message = "Nome do profissional é obrigatório")
        String nomeProfissional,

        @NotBlank(message = "Tipo do profissional é obrigatório")
        String tipoProfissional,

        @NotBlank(message = "Sexo do profissional é obrigatório")
        String flSexo
) {}
