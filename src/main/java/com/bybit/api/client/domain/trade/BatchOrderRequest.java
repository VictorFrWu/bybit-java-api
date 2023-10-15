package com.bybit.api.client.domain.trade;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.service.ProductTypeSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class BatchOrderRequest {
    @JsonSerialize(using = ProductTypeSerializer.class)
    private ProductType category;
    private List<TradeOrderRequest> request;
}
