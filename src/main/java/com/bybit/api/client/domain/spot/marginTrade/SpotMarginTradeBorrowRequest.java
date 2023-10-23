/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin name
 * qty	true	string	Amount to borrow
 * Response Parameters
 * Parameter	Type	Comments
 * transactId	string	Borrow transaction ID
 */
package com.bybit.api.client.domain.spot.marginTrade;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SpotMarginTradeBorrowRequest {
    private final String coin;
    private final String qty;
}

