package com.bybit.api.client.domain.market.response.historicalVolatility;

import lombok.Data;

import java.util.List;

@Data
public class HistoricalVolatilityResult {
    private List<HistoricalVolatilityEntry> historicalVolatilityEntries;
}
