/**
 * Response Parameters
 * Parameter	Type	Comments
 * rows	array	Object
 * > withdrawId	string	Withdraw ID
 * > txID	string	Transaction ID. It returns "" when withdrawal failed, withdrawal cancelled or internal transfer
 * > withdrawType	string	Withdraw type. 0: on chain. 1: off chain
 * > coin	string	Coin
 * > chain	string	Chain
 * > amount	string	Amount
 * > withdrawFee	string	Withdraw fee
 * > status	string	Withdraw status
 * > toAddress	string	To withdrawal address. Shows an email or mobile number for internal transfers
 * > tag	string	Tag
 * > createTime	string	Withdraw created timestamp (ms)
 * > updateTime	string	Withdraw updated timestamp (ms)
 * nextPageCursor	string	Cursor. Used for pagination
 */
package com.bybit.api.client.domain.asset.request;

import com.bybit.api.client.domain.asset.WithdrawType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AssetWithdrawRecordsRequest {
    private String withdrawID;
    private String coin;
    private Integer withdrawType;  // 0 for on-chain, 1 for off-chain, 2 for all
    private Long startTime;
    private Long endTime;
    private Integer limit;
    private String cursor;
}

