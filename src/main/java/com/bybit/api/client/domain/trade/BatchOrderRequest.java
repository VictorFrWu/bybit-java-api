package com.bybit.api.client.domain.trade;

import com.bybit.api.client.domain.ProductType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class BatchOrderRequest {
    private String category;
    private List<TradeOrderRequest> request;

    @JsonCreator
    public static BatchOrderRequest create(@JsonProperty("category") String category,
                                           @JsonProperty("request") List<TradeOrderRequest> request) {
        return BatchOrderRequest.builder()
                .category(category)
                .request(request)
                .build();
    }
}
