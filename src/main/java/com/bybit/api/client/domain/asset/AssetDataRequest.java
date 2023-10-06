package com.bybit.api.client.domain.asset;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.request.WithTransferSafeAmount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AssetDataRequest {
    private String coin;
    private String chain;
    private Integer limit;
    private String cursor;
    private String memberId;
    private Integer fromMemberId;
    private Integer toMemberId;
    private AccountType accountType;
    private WithBonus withBonus;
    private ProductType category;
    private String symbol;
    private String expDate;
    private String subMemberId; // required = true to Get Sub Deposit Records (on-chain)
    private Long startTime;
    private Long endTime;
    private String transferId;
    private String amount;
    private AccountType fromAccountType;
    private AccountType toAccountType;
    private WithTransferSafeAmount withTransferSafeAmount;
    private WithTransferSafeAmount withLtvTransferSafeAmount;
    private TransferStatus transferStatus;
    private String withdrawID;
    private WithdrawType withdrawType;  // 0 for on-chain, 1 for off-chain, 2 for all
    private String address; // mandatory
    private String tag;
    private Long timestamp; // mandatory
    private Integer forceChain;
    private FeeType feeType;
    private String fromCoin;
    private String toCoin;
    private String chainType;
}
