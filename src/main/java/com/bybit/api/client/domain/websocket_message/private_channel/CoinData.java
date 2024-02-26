package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinData {
    private String coin;
    private String equity;
    private String usdValue;
    private String walletBalance;
    private String free;
    private String locked;
    private String spotHedgingQty;
    private String borrowAmount;
    private String availableToBorrow;
    private String availableToWithdraw;
    private String accruedInterest;
    private String totalOrderIM;
    private String totalPositionIM;
    private String totalPositionMM;
    private String unrealisedPnl;
    private String cumRealisedPnl;
    private String bonus;
    private Boolean collateralSwitch;
    private Boolean marginCollateral;
}
