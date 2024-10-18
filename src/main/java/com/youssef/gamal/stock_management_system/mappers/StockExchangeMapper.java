package com.youssef.gamal.stock_management_system.mappers;

import com.youssef.gamal.stock_management_system.dto.StockExchangeDto;
import com.youssef.gamal.stock_management_system.entity.StockExchange;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {StockMapper.class})
public interface StockExchangeMapper {

    StockExchangeDto toDto(StockExchange stockExchange);
    Set<StockExchangeDto> toDtos(Set<StockExchange> stockExchanges);
    List<StockExchangeDto> toDtos(List<StockExchange> stockExchanges);

    StockExchange toEntity(StockExchangeDto stockExchangeDto);
    Set<StockExchange> toEntities(Set<StockExchangeDto> stockExchangeDtos);
    List<StockExchange> toEntities(List<StockExchangeDto> stockExchangeDtos);
}
