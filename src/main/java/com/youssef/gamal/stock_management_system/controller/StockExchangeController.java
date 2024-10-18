package com.youssef.gamal.stock_management_system.controller;

import com.youssef.gamal.stock_management_system.entity.StockExchange;
import com.youssef.gamal.stock_management_system.service.StockExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
@Slf4j
public class StockExchangeController {
    @Autowired
    private StockExchangeService exchangeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StockExchange> getAllExchanges() {
        log.info("Fetching all stock exchanges");
        List<StockExchange> exchanges = exchangeService.getAllExchanges();
        log.info("Retrieved {} stock exchanges", exchanges.size());
        return exchanges;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockExchange createExchange(@RequestBody StockExchange exchange) {
        log.info("Creating stock exchange: {}", exchange);
        StockExchange createdExchange = exchangeService.createStockExchange(exchange);
        log.info("Created stock exchange with ID: {}", createdExchange.getId());
        return createdExchange;
    }

    @PutMapping("/{exchangeId}/stocks/{stockId}")
    @ResponseStatus(HttpStatus.OK)
    public void addStockToExchange(@PathVariable Long exchangeId, @PathVariable Long stockId) {
        log.info("Adding stock ID {} to exchange ID {}", stockId, exchangeId);
        exchangeService.addStockToExchange(exchangeId, stockId);
        log.info("Added stock ID {} to exchange ID {}", stockId, exchangeId);
    }

    @DeleteMapping("/{exchangeId}/stocks/{stockId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStockFromExchange(@PathVariable Long exchangeId, @PathVariable Long stockId) {
        log.info("Removing stock ID {} from exchange ID {}", stockId, exchangeId);
        exchangeService.removeStockFromExchange(exchangeId, stockId);
        log.info("Removed stock ID {} from exchange ID {}", stockId, exchangeId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExchange(@PathVariable Long id) {
        log.info("Deleting stock exchange ID: {}", id);
        exchangeService.deleteStockExchange(id);
        log.info("Deleted stock exchange ID: {}", id);
    }
}
