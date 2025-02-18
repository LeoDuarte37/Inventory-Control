package com.inventory.control.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginPostRequest(

        @NotNull
        PersonPostRequest person,

        @Size(min = 5, max = 60)
        @NotBlank
        String username,

        @Size(min = 5, max = 60)
        @NotBlank
        String keypass,

        @NotBlank
        String role
) {
}
