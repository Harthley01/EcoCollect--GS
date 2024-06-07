package br.com.fiap.global.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record PostoAvancadoRequest(

        @NotNull(message = "Nome do Posto é obrigatório")
        String nomePosto,

        @NotNull(message = "Cidade do Posto é obrigatória")
        String cidadePosto,

        @NotNull(message = "Total de Itens é obrigatório")
        Integer totalItens

) {}
