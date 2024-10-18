package com.youssef.gamal.stock_management_system.mappers;

import com.youssef.gamal.stock_management_system.dto.StockDto;
import com.youssef.gamal.stock_management_system.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {})
public interface StockMapper {

    @Mapping(target = "exchanges", source = "exchanges", ignore = true)
    StockDto toDto(Stock stock);

    Set<StockDto> toDtos(Set<Stock> stocks);
    List<StockDto> toDtos(List<Stock> stocks);

    @Mapping(target = "exchanges", source = "exchanges", ignore = true)
    Stock toEntity(StockDto stockDto);

    Set<Stock> toEntities(Set<StockDto> stockDtos);
    List<Stock> toEntities(List<StockDto> stockDtos);
}
