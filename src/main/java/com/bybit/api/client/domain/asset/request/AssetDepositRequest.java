/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin
 * chainType	true	string	Chain, e.g.,ETH
 * subMemberId	true	string	Sub user ID
 * Response Parameters
 * Parameter	Type	Comments
 * coin	string	Coin
 * chains	array	Object
 * > chainType	string	Chain type
 * > addressDeposit	string	The address for deposit
 * > tagDeposit	string	Tag of deposit
 * > chain	string	Chain
 * > batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
 */
package com.bybit.api.client.domain.asset.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AssetDepositRequest {
    private String coin;
    private String chainType;
    private String subMemberId;
}
