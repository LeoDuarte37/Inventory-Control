package com.inventory.control.infrastructure.model;

import com.inventory.control.infrastructure.model.embeddable.Contact;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_name")
    private String name;

    @Embedded
    private Contact contact;

    @ManyToOne(cascade = CascadeType.ALL)
    private Enterprise enterprise;
}
