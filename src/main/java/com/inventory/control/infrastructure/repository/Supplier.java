package com.inventory.control.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Supplier extends JpaRepository<Supplier, Long> {
}
