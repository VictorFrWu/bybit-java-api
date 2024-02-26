package com.bybit.api.client.domain.websocket_message.private_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletData {
    private String accountType;
    private String accountLTV;
    private String accountIMRate;
    private String accountMMRate;
    private String totalEquity;
    private String totalWalletBalance;
    private String totalMarginBalance;
    private String totalAvailableBalance;
    private String totalPerpUPL;
    private String totalInitialMargin;
    private String totalMaintenanceMargin;
    private List<CoinData> coin;

}
