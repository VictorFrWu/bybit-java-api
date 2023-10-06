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
public class MasterUserPermissions {
    private List<String> contractTrade;      // Permission of contract trade
    private List<String> spot;               // Permission of spot
    private List<String> wallet;             // Permission of wallet
    private List<String> options;            // Permission of USDC Contract. It supports trade option and USDC perpetual.
    private List<String> derivatives;        // Permission of Unified account
    private List<String> copyTrading;        // Permission of copytrade
    private List<String> blockTrade;         // Permission of blocktrade. Not applicable to sub account, always []
    private List<String> exchange;           // Permission of exchange
    private List<String> nft;                // Permission of NFT. Not applicable to sub account, always []
}
