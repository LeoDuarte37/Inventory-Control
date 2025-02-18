package com.inventory.control.infrastructure.model;

import com.inventory.control.infrastructure.model.enumeration.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    private BigDecimal price;

    @Column(name = "product_status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Enterprise enterprise;

    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
}
