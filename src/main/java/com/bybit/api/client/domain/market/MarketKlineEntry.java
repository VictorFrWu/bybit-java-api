package com.bybit.api.client.domain.market;

import com.bybit.api.client.constant.BybitApiConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class MarketKlineEntry {
    private long startTime;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String closePrice;
    private String volume;
    private String turnover;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("startTime", startTime)
                .append("openPrice", openPrice)
                .append("highPrice", highPrice)
                .append("lowPrice", lowPrice)
                .append("closePrice", closePrice)
                .append("volume", volume)
                .append("turnover", turnover)
                .toString();
    }
}
