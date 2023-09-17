/**
 * HTTP Request
 * GET /v5/asset/transfer/query-account-coins-balance
 *
 * Request Parameters
 * Parameter	Required	Type	Comments
 * memberId	false	string	User Id. It is required when you use master api key to check sub account coin balance
 * accountType	true	string	Account type
 * coin	false	string	Coin name
 * Query all coins if not passed
 * Can query multiple coins, separated by comma. USDT,USDC,ETH
 * withBonus	false	string	Whether query bonus or not. 0(default)：false; 1：true
 * Response Parameters
 * Parameter	Type	Comments
 * accountType	string	Account type
 * memberId	string	UserID
 * balance	array	Object
 * > coin	string	Currency type
 * > walletBalance	string	Wallet balance
 * > transferBalance	string	Transferable balance
 * > bonus	string	The bonus
 */
package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.account.AccountType;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class AssetCoinsBalanceRequest {
    private final String memberId;
    private final AccountType accountType;
    private final String coin;
    private final String withBonus;
}

