package com.youssef.gamal.stock_management_system.repository;

import com.youssef.gamal.stock_management_system.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
