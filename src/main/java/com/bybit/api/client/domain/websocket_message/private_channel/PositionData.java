package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionData {
    private String category;
    private String symbol;
    private String side;
    private String size;
    private Integer positionIdx;
    private Integer tradeMode;
    private String positionValue;
    private Integer riskId;
    private String riskLimitValue;
    private String entryPrice;
    private String markPrice;
    private String leverage;
    private String positionBalance;
    private Integer autoAddMargin;
    private String positionMM;
    private String positionIM;
    private String liqPrice;
    private String bustPrice;
    private String tpslMode;
    private String takeProfit;
    private String stopLoss;
    private String trailingStop;
    private String unrealisedPnl;
    private String cumRealisedPnl;
    private String positionStatus;
    private Integer adlRankIndicator;
    private Boolean isReduceOnly;
    private String mmrSysUpdatedTime;
    private String leverageSysUpdatedTime;
    private String createdTime;
    private String updatedTime;
    private Long seq;
}
