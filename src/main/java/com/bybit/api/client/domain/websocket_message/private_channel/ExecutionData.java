package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecutionData {
    private String category;
    private String symbol;
    private String isLeverage;
    private String orderId;
    private String orderLinkId;
    private String side;
    private String orderPrice;
    private String orderQty;
    private String leavesQty;
    private String createType;
    private String orderType;
    private String stopOrderType;
    private String execFee;
    private String execId;
    private String execPrice;
    private String execQty;
    private String execType;
    private String execValue;
    private String execTime;
    private Boolean isMaker;
    private String feeRate;
    private String tradeIv;
    private String markIv;
    private String markPrice;
    private String indexPrice;
    private String underlyingPrice;
    private String blockTradeId;
    private String closedSize;
    private Long seq;
}
