package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.asset.*;
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
    private CategoryType category;
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
    private Integer side; //0: fromCoin list, the balance is given if you have it; 1: toCoin list (coin to buy) when side=1 and coin field is filled, it returns toCoin list based on coin field
    private String quoteTxId;
    private Integer index;
    private String fromCoinType;
    private String toCoinType;
    private String requestCoin;
    private String requestAmount;
    private String requestId;
}
