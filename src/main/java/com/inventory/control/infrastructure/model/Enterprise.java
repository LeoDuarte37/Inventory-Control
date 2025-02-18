package com.inventory.control.infrastructure.model;

import com.inventory.control.infrastructure.model.enumeration.Subscription;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enterprise_name")
    private String name;

    private int cnpj;

    @Enumerated(value = EnumType.STRING)
    private Subscription subscription;
}
