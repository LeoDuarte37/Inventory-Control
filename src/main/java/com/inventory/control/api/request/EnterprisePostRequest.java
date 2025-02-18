package com.inventory.control.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public record EnterprisePostRequest(

        @Size(min = 2, max = 45)
        @NotBlank
        String name,

        @CNPJ
        @NotNull
        int cnpj,

        @NotNull
        String subscription
) {
}
