/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. spot,linear,inverse,option
 * symbol	false	string	Symbol name
 * baseCoin	false	string	Base coin. For option only
 * expDate	false	string	Expiry date. e.g., 25DEC22. For option only
 * Response Parameters
 * Linear/Inverse
 * Option
 * Spot
 * Parameter	Type	Comments
 * category	string	Product type
 * list	array	Object
 * > symbol	string	Symbol name
 * > bid1Price	string	Best bid price
 * > bid1Size	string	Best bid size
 * > bid1Iv	string	Best bid iv
 * > ask1Price	string	Best ask price
 * > ask1Size	string	Best ask size
 * > ask1Iv	string	Best ask iv
 * > lastPrice	string	Last price
 * > highPrice24h	string	The highest price in the last 24 hours
 * > lowPrice24h	string	The lowest price in the last 24 hours
 * > markPrice	string	Mark price
 * > indexPrice	string	Index price
 * > markIv	string	Mark price iv
 * > underlyingPrice	string	Underlying price
 * > openInterest	string	Open interest size
 * > turnover24h	string	Turnover for 24h
 * > volume24h	string	Volume for 24h
 * > totalVolume	string	Total volume
 * > totalTurnover	string	Total turnover
 * > delta	string	Delta
 * > gamma	string	Gamma
 * > vega	string	Vega
 * > theta	string	Theta
 * > predictedDeliveryPrice	string	Predicated delivery price. It has value when 30 min before delivery
 * > change24h	string	The change in the last 24 hous
 */
package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MarketDataTickerRequest {
    private final ProductType category;
    private final String symbol;
    private final String baseCoin;
    private final String expDate;
}
