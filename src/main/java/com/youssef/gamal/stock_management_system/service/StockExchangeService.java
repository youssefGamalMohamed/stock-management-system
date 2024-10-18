package com.youssef.gamal.stock_management_system.service;

import com.youssef.gamal.stock_management_system.entity.Stock;
import com.youssef.gamal.stock_management_system.entity.StockExchange;
import com.youssef.gamal.stock_management_system.repository.StockExchangeRepository;
import com.youssef.gamal.stock_management_system.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StockExchangeService {
    @Autowired
    private StockExchangeRepository stockExchangeRepository;
    @Autowired
    private StockRepository stockRepository;

    public List<StockExchange> getAllExchanges() {
        log.info("Fetching all stock exchanges");
        List<StockExchange> exchanges = stockExchangeRepository.findAll();
        log.info("Retrieved {} stock exchanges", exchanges.size());
        return exchanges;
    }

    public StockExchange createStockExchange(StockExchange exchange) {
        log.info("Creating stock exchange: {}", exchange);
        StockExchange createdExchange = stockExchangeRepository.save(exchange);
        log.info("Created stock exchange with ID: {}", createdExchange.getId());
        return createdExchange;
    }

    public void addStockToExchange(Long exchangeId, Long stockId) {
        log.info("Adding stock ID {} to exchange ID {}", stockId, exchangeId);
        StockExchange exchange = stockExchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new IllegalArgumentException("Exchange not found"));
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));

        exchange.getStocks().add(stock);
        log.info("Added stock ID {} to exchange ID {}", stockId, exchangeId);

        if (exchange.getStocks().size() >= 10) {
            exchange.setLiveInMarket(true);
            log.info("Exchange ID {} is now live in the market", exchangeId);
        }
        stockExchangeRepository.save(exchange);
    }

    public void removeStockFromExchange(Long exchangeId, Long stockId) {
        log.info("Removing stock ID {} from exchange ID {}", stockId, exchangeId);
        StockExchange exchange = stockExchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new IllegalArgumentException("Exchange not found"));
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));

        exchange.getStocks().remove(stock);
        log.info("Removed stock ID {} from exchange ID {}", stockId, exchangeId);

        if (exchange.getStocks().size() < 10) {
            exchange.setLiveInMarket(false);
            log.info("Exchange ID {} is no longer live in the market", exchangeId);
        }
        stockExchangeRepository.save(exchange);
    }

    public void deleteStockExchange(Long exchangeId) {
        log.info("Deleting stock exchange ID: {}", exchangeId);
        stockExchangeRepository.deleteById(exchangeId);
        log.info("Deleted stock exchange ID: {}", exchangeId);
    }
}
