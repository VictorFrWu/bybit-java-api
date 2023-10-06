package com.bybit.api.client.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class SubUserPermissions {
    private List<String> contractTrade;  // Contract Trade permissions ["Order","Position"]
    private List<String> spot;  // Spot Trade permissions ["SpotTrade"]
    private List<String> wallet;  // Wallet permissions ["AccountTransfer", "SubMemberTransferList"]
    private List<String> options;  // USDC Contract permissions ["OptionsTrade"]
    private List<String> derivatives;  // This param is deprecated
    private List<String> exchange;  // Exchange permissions ["ExchangeHistory"]
    private List<String> copyTrading;  // Copytrade permissions ["CopyTrading"]
}
