package com.youssef.gamal.stock_management_system.service;

import com.youssef.gamal.stock_management_system.entity.Stock;
import com.youssef.gamal.stock_management_system.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock createStock(Stock stock) {
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        return stockRepository.save(stock);
    }

    public Stock updatePrice(Long stockId, BigDecimal newPrice) {
        Stock stock = stockRepository.findById(stockId).orElseThrow();
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        return stockRepository.save(stock);
    }

    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }
}
