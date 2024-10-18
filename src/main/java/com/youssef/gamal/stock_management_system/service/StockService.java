package com.youssef.gamal.stock_management_system.service;

import com.youssef.gamal.stock_management_system.entity.Stock;
import com.youssef.gamal.stock_management_system.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        log.info("Fetching all stocks");
        List<Stock> stocks = stockRepository.findAll();
        log.info("Number of stocks retrieved: {}", stocks.size());
        return stocks;
    }

    public Stock createStock(Stock stock) {
        log.info("Creating stock with name: {}", stock.getName());
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        Stock savedStock = stockRepository.save(stock);
        log.info("Stock created with ID: {}", savedStock.getId());
        return savedStock;
    }

    public Stock updatePrice(Long stockId, BigDecimal newPrice) {
        log.info("Updating price for stock ID: {} to {}", stockId, newPrice);
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found with ID: " + stockId));
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        Stock updatedStock = stockRepository.save(stock);
        log.info("Stock price updated for ID: {} to {}", updatedStock.getId(), newPrice);
        return updatedStock;
    }

    public void deleteStock(Long stockId) {
        log.info("Deleting stock with ID: {}", stockId);
        stockRepository.deleteById(stockId);
        log.info("Stock with ID: {} deleted", stockId);
    }
}
