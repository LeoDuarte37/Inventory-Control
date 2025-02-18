package com.inventory.control.infrastructure.model;

import com.inventory.control.infrastructure.model.enumeration.Movement;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "stock_movement")
public class StockMovement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movement_type")
    @Enumerated(value = EnumType.STRING)
    private Movement movement;

    private int quantity;

    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
}
