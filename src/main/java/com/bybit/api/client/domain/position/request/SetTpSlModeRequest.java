/**
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * tpSlMode	true	string	TP/SL mode. Full,Partial
 */
package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.TpslMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SetTpSlModeRequest {
    private String category;
    private String symbol;
    private String tpSlMode;
}
