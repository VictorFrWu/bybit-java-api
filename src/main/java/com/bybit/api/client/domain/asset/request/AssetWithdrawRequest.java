/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin
 * chain	true	string	Chain
 * address	true	string	Wallet address. Please note that the address is case sensitive, so use the exact same address added in address book
 * tag	false	string	Tag
 * Required if tag exists in the wallet address list.
 * Note: please do not set a tag/memo in the address book if the chain does not support tag
 * amount	true	string	Withdraw amount
 * timestamp	true	integer	Current timestamp (ms). Used for preventing from withdraw replay
 * forceChain	false	integer	Whether or not to force an on-chain withdrawal
 * 0(default): If the address is parsed out to be an internal address, then internal transfer
 * 1: Force the withdrawal to occur on-chain
 * accountType	false	string	Select the wallet to be withdrawn from
 * SPOT：spot wallet (default)
 * FUND：Funding wallet
 * feeType	false	integer	Handling fee option
 * 0(default): input amount is the actual amount received, so you have to calculate handling fee manually
 * 1: input amount is not the actual amount you received, the system will help to deduct the handling fee automatically
 * Response Parameters
 * Parameter	Type	Comments
 * id	string	Withdrawal ID
 */
package com.bybit.api.client.domain.asset.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetWithdrawRequest {
    private String coin; // mandatory
    private String chain; // mandatory
    private String address; // mandatory
    private String tag;
    private String amount; // mandatory
    private Long timestamp; // mandatory
    private Integer forceChain;
    private String accountType;
    private Integer feeType;
}
