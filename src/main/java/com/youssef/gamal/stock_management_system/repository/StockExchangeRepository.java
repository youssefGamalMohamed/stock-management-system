package com.youssef.gamal.stock_management_system.repository;

import com.youssef.gamal.stock_management_system.entity.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
}