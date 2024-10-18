package com.youssef.gamal.stock_management_system.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.youssef.gamal.stock_management_system.entity.Stock;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
public class StockExchangeDto {

    private Long id;
    private String name;
    private String description;
    private Boolean liveInMarket;
    private Set<StockDto> stocks;

}
