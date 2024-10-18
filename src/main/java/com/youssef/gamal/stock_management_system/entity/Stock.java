package com.youssef.gamal.stock_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal currentPrice;
    private Timestamp lastUpdate;

    @ManyToMany(mappedBy = "stocks")
    @JsonIgnore
    @ToString.Exclude
    private Set<StockExchange> exchanges;

    // Getters, Setters, and other methods
}
