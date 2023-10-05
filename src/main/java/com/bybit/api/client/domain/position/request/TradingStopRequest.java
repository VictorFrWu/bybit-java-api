/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type
 * Unified account: linear, inverse
 * Normal account: linear, inverse. Please note that category is not involved with business logic
 * symbol	true	string	Symbol name
 * takeProfit	false	string	Cannot be less than 0, 0 means cancel TP
 * stopLoss	false	string	Cannot be less than 0, 0 means cancel SL
 * trailingStop	false	string	Trailing stop by price distance. Cannot be less than 0, 0 means cancel TS
 * tpTriggerBy	false	string	Take profit trigger price type
 * slTriggerBy	false	string	Stop loss trigger price type
 * activePrice	false	string	Trailing stop trigger price. Trailing stop will be triggered when this price is reached only
 * tpslMode	false	string	TP/SL mode. Full: entire position TP/SL, Partial: partial position TP/SL. As each contract has an initial full TP/SL mode, if it has been modified before, it may be partial. Therefore, if not provided, the system will automatically retrieve the current TP/SL mode configuration for the contract.
 * tpSize	false	string	Take profit size. Valid in TP/SL partial mode. Note: the value of tpSize and slSize must equal
 * slSize	false	string	Stop loss size. Valid in TP/SL partial mode. Note: the value of tpSize and slSize must equal
 * tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit
 * slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit
 * tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market
 * slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market
 * positionIdx	true	integer	Used to identify positions in different position modes.
 * 0: one-way mode
 * 1: hedge-mode Buy side
 * 2: hedge-mode Sell side
 */

package com.bybit.api.client.domain.position.request;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.position.TpslMode;
import com.bybit.api.client.domain.trade.PositionIdx;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TradingStopRequest {
    private String category;
    private  String symbol;
    private  String takeProfit;
    private  String stopLoss;
    private  String trailingStop;
    private String tpTriggerBy;
    private  String slTriggerBy;
    private  String activePrice;
    private String tpslMode;
    private  String tpSize;
    private  String slSize;
    private  String tpLimitPrice;
    private  String slLimitPrice;
    private String tpOrderType;
    private  String slOrderType;
    private Integer positionIdx;
}