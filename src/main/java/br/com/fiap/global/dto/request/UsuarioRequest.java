package br.com.fiap.global.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record UsuarioRequest(

        @NotNull(message = "CPF é obrigatório")
        String nrCpf,

        @NotNull(message = "RG é obrigatório")
        String nrRg,

        @NotNull(message = "Data de nascimento é obrigatória")
        Date dtNascimento,

        @NotNull(message = "Sexo é obrigatório")
        String flSexo,

        @Valid
        @NotNull(message = "Pontos devem ser informados")
        PontosRequest pontos

) {}
