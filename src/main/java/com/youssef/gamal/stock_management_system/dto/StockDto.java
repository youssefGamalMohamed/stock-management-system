package com.youssef.gamal.stock_management_system.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.youssef.gamal.stock_management_system.entity.StockExchange;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
public class StockDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal currentPrice;
    private Timestamp lastUpdate;
    private Set<StockExchangeDto> exchanges;

}
