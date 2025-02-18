package com.inventory.control.infrastructure.model.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Contact {

    private String email;

    private int ddd;

    private int phone;
}
