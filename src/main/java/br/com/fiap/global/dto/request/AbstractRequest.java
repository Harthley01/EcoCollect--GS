package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest(

        @Positive
        @NotNull
        Long id

) {
}
