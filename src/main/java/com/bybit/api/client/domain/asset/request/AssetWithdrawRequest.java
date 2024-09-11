/**
 Request Parameters
 Parameter	Required	Type	Comments
 coin	true	string	Coin, uppercase only
 chain	false	string	Chain
 forceChain=0 or 1: this field is required
 forceChain=2: this field can be null
 address	true	string
 forceChain=0 or 1: fill wallet address, and make sure you add address in the address book first. Please note that the address is case sensitive, so use the exact same address added in address book
 forceChain=2: fill Bybit UID, and it can only be another Bybit main account UID. Make sure you add UID in the address book first
 tag	false	string	Tag
 Required if tag exists in the wallet address list.
 Note: please do not set a tag/memo in the address book if the chain does not support tag
 amount	true	string	Withdraw amount
 timestamp	true	integer	Current timestamp (ms). Used for preventing from withdraw replay
 forceChain	false	integer	Whether or not to force an on-chain withdrawal
 0(default): If the address is parsed out to be an internal address, then internal transfer
 1: Force the withdrawal to occur on-chain
 2: Use UID to withdraw
 accountType	false	string	Select the wallet to be withdrawn from
 SPOT：spot wallet (default)
 FUND：Funding wallet
 feeType	false	integer	Handling fee option
 0(default): input amount is the actual amount received, so you have to calculate handling fee manually
 1: input amount is not the actual amount you received, the system will help to deduct the handling fee automatically
 requestId	false	string	Customised ID, globally unique, it is used for idempotent verification
 A combination of letters (case sensitive) and numbers, which can be pure letters or pure numbers and the length must be between 1 and 32 digits
 beneficiary	false	Object	Travel rule info, only required for kyc=KOR (korean) users
 > vaspEntityId	true	string	Receiver exchange entity Id. Please call this endpoint to get this ID
 > beneficiaryName	false	string	Receiver exchange user KYC name, like John Wilson or Wilson John
 Please refer to target exchange kyc name
 When vaspEntityId="others", this field can be null
 */
package com.bybit.api.client.domain.asset.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

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
    private String requestId; // not required
    @JsonProperty("beneficiary")
    private Map<String, String> beneficiary; // not required
}
