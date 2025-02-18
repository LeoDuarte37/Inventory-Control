package com.inventory.control.infrastructure.repository;

import com.inventory.control.infrastructure.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMovementRepository extends JpaRepository<Stock, Long> {
}
