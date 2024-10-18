package com.youssef.gamal.stock_management_system.controller;

import com.youssef.gamal.stock_management_system.entity.StockExchange;
import com.youssef.gamal.stock_management_system.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
public class StockExchangeController {
    @Autowired
    private StockExchangeService exchangeService;

    @GetMapping
    public List<StockExchange> getAllExchanges() {
        return exchangeService.getAllExchanges();
    }

    @PostMapping
    public StockExchange createExchange(@RequestBody StockExchange exchange) {
        return exchangeService.createStockExchange(exchange);
    }

    @PutMapping("/{exchangeId}/stocks/{stockId}")
    public void addStockToExchange(@PathVariable Long exchangeId, @PathVariable Long stockId) {
        exchangeService.addStockToExchange(exchangeId, stockId);
    }

    @DeleteMapping("/{exchangeId}/stocks/{stockId}")
    public void removeStockFromExchange(@PathVariable Long exchangeId, @PathVariable Long stockId) {
        exchangeService.removeStockFromExchange(exchangeId, stockId);
    }

    @DeleteMapping("/{id}")
    public void deleteExchange(@PathVariable Long id) {
        exchangeService.deleteStockExchange(id);
    }
}
