package com.inventory.control.api.request;

import com.inventory.control.infrastructure.model.Enterprise;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PersonPostRequest(

        @Size(min = 3, max = 60)
        @NotBlank
        String firstName,

        @Size(min = 3, max = 60)
        @NotBlank
        String lastName,

        @NotNull
        Enterprise enterprise
) {
}
