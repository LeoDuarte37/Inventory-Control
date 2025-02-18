package com.inventory.control.api.request;

import com.inventory.control.infrastructure.model.Enterprise;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryPostRequest(

        @Size(min = 1, max = 45)
        @NotBlank
        String name,

        @NotBlank
        String status,

        @NotNull
        Enterprise enterprise
) {
}
