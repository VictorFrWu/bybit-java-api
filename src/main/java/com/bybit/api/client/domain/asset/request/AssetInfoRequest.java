/**
 * HTTP Request
 * GET /v5/asset/transfer/query-asset-info
 *
 * Request Parameters
 * Parameter	Required	Type	Comments
 * accountType	true	string	Account type. SPOT
 * coin	false	string	Coin name
 * Response Parameters
 * Parameter	Type	Comments
 * spot	Object
 * > status	string	account status. ACCOUNT_STATUS_NORMAL: normal, ACCOUNT_STATUS_UNSPECIFIED: banned
 * > assets	array	Object
 * >> coin	string	Coin
 * >> frozen	string	Freeze amount
 * >> free	string	Free balance
 * >> withdraw	string	Amount in withdrawing
 */
package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.account.AccountType;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class AssetInfoRequest {
    private final AccountType accountType;
    private final String coin;
}

