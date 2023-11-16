package com.bybit.api.client.domain.trade.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.service.CategoryTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class CancelBatchOrderRequest {
    @JsonSerialize(using = CategoryTypeSerializer.class)
    private CategoryType category;
    private List<CancelOrderRequest> request;
}
