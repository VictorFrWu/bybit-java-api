package com.bybit.api.client.domain.market.response.recentTrade;

import lombok.Data;

@Data
public class RecentTradeEntry {
    private String execId;
    private String symbol;
    private String price;
    private String size;
    private String side;
    private String time;
    private Boolean isBlockTrade;
}
