package com.bybit.api.client.domain.market.response.orderbook;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class OrderBookAskEntry {
    private String askPrice;
    private String askSize;
}
