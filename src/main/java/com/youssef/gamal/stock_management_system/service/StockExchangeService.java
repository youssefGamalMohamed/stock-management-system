package com.youssef.gamal.stock_management_system.service;

import com.youssef.gamal.stock_management_system.entity.Stock;
import com.youssef.gamal.stock_management_system.entity.StockExchange;
import com.youssef.gamal.stock_management_system.repository.StockExchangeRepository;
import com.youssef.gamal.stock_management_system.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockExchangeService {
    @Autowired
    private StockExchangeRepository stockExchangeRepository;
    @Autowired
    private StockRepository stockRepository;

    public List<StockExchange> getAllExchanges() {
        return stockExchangeRepository.findAll();
    }

    public StockExchange createStockExchange(StockExchange exchange) {
        return stockExchangeRepository.save(exchange);
    }

    public void addStockToExchange(Long exchangeId, Long stockId) {
        StockExchange exchange = stockExchangeRepository.findById(exchangeId).orElseThrow();
        Stock stock = stockRepository.findById(stockId).orElseThrow();
        exchange.getStocks().add(stock);
        if (exchange.getStocks().size() >= 10) {
            exchange.setLiveInMarket(true);
        }
        stockExchangeRepository.save(exchange);
    }

    public void removeStockFromExchange(Long exchangeId, Long stockId) {
        StockExchange exchange = stockExchangeRepository.findById(exchangeId).orElseThrow();
        Stock stock = stockRepository.findById(stockId).orElseThrow();
        exchange.getStocks().remove(stock);
        if (exchange.getStocks().size() < 10) {
            exchange.setLiveInMarket(false);
        }
        stockExchangeRepository.save(exchange);
    }

    public void deleteStockExchange(Long exchangeId) {
        stockExchangeRepository.deleteById(exchangeId);
    }
}
