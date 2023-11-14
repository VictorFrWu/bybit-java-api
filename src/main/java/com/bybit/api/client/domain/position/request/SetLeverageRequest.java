package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SetLeverageRequest {
    private String category;
    private String symbol;
    private String buyLeverage;
    private String sellLeverage;
}
