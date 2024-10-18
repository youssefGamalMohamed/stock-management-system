package com.youssef.gamal.stock_management_system.controller;

import com.youssef.gamal.stock_management_system.entity.Stock;
import com.youssef.gamal.stock_management_system.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/stocks")
@Slf4j
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        log.info("Fetching all stocks");
        List<Stock> stocks = stockService.getAllStocks();
        log.info("Retrieved {} stocks", stocks.size());
        return stocks;
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        log.info("Creating stock: {}", stock);
        Stock createdStock = stockService.createStock(stock);
        log.info("Created stock with ID: {}", createdStock.getId());
        return createdStock;
    }

    @PutMapping("/{id}/price")
    public Stock updateStockPrice(@PathVariable Long id, @RequestParam BigDecimal newPrice) {
        log.info("Updating stock ID {} with new price: {}", id, newPrice);
        Stock updatedStock = stockService.updatePrice(id, newPrice);
        log.info("Updated stock ID {}: new price is {}", id, updatedStock.getCurrentPrice());
        return updatedStock;
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        log.info("Deleting stock ID: {}", id);
        stockService.deleteStock(id);
        log.info("Deleted stock ID: {}", id);
    }
}

