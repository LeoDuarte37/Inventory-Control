package com.inventory.control.infrastructure.model;

import com.inventory.control.infrastructure.model.enumeration.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Enterprise enterprise;
}
