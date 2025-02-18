package com.inventory.control.infrastructure.model;

import com.inventory.control.infrastructure.model.enumeration.Role;
import com.inventory.control.infrastructure.model.enumeration.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    private String username;

    private String keypass;

    @Column(name = "login_role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "login_status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
