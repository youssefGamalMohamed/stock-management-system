package com.youssef.gamal.stock_management_system.controller;

import com.youssef.gamal.stock_management_system.dto.StockDto;
import com.youssef.gamal.stock_management_system.entity.Stock;
import com.youssef.gamal.stock_management_system.mappers.StockMapper;
import com.youssef.gamal.stock_management_system.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@Slf4j
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private StockMapper stockMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StockDto> getAllStocks() {
        log.info("Fetching all stocks");
        List<Stock> stocks = stockService.getAllStocks();
        List<StockDto> stockDtos = stockMapper.toDtos(stocks);
        log.info("Retrieved stocks: " + stockDtos);
        return stockDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDto createStock(@RequestBody StockDto stockDto) {
        log.info("Creating stock: {}", stockDto);
        Stock createdStock = stockService.createStock(stockMapper.toEntity(stockDto));
        StockDto createdStockDto = stockMapper.toDto(createdStock);
        log.info("Created stock with ID: {}", createdStockDto.getId());
        return createdStockDto;
    }

    @PutMapping("/{id}/price")
    @ResponseStatus(HttpStatus.OK)
    public StockDto updateStockPrice(@PathVariable Long id, @RequestParam BigDecimal newPrice) {
        log.info("Updating stock ID {} with new price: {}", id, newPrice);
        Stock updatedStock = stockService.updatePrice(id, newPrice);
        StockDto updatedStockDto = stockMapper.toDto(updatedStock);
        log.info("Updated stock ID {}: new price is {}", id, updatedStockDto.getCurrentPrice());
        return updatedStockDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStock(@PathVariable Long id) {
        log.info("Deleting stock ID: {}", id);
        stockService.deleteStock(id);
        log.info("Deleted stock ID: {}", id);
    }
}

