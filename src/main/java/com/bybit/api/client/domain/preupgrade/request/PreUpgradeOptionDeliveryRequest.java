/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. option
 * symbol	false	string	Symbol name
 * expDate	false	string	Expiry date. 25MAR22. Default: return all
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Used for pagination
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PreUpgradeOptionDeliveryRequest {
    private String category;
    private String symbol;
    private String expDate;
    private Integer limit;
    private String cursor;
}
