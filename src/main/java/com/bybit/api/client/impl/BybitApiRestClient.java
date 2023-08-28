package com.bybit.api.client.impl;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.requests.*;
import com.bybit.api.client.domain.trade.response.OpenOrderEntry;
import com.bybit.api.client.domain.trade.response.OrderResponse;
import com.bybit.api.client.domain.trade.response.OrderResult;

public interface BybitApiRestClient {
    // Market Data

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @param category product type. spot,linear, inverse (mandatory)
     * @param symbol symbol to aggregate (mandatory)
     * @param interval candlestick interval (mandatory)
     * @param limit Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    GenericResponse<MarketKlineResult> getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getMarketLinesData(ProductType, String, MarketKlineInterval, Integer, Long, Long)
     */
    GenericResponse<MarketKlineResult> getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval);

    // Trade



    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param orderHistoryRequest order request parameters
     * @return a list of all history orders 2 years
     */
    GenericResponse<OrderResult> getHistoryOrderResult(OrderHistoryRequest orderHistoryRequest);

    /**
     * This endpoint supports to create the order for spot, spot margin, USDT perpetual, USDC perpetual, USDC futures, inverse futures and options.
     *
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     *
     * INFO
     * Supported order type (orderType):
     * Limit order: orderType=Limit, it is necessary to specify order qty and price.
     *
     * Market order: orderType=Market, execute at the best price in the Bybit market until the transaction is completed. When selecting a market order, the `price` is empty. In the futures trading system, in order to protect the serious slippage of the market order, the Bybit trading system will convert the market order into a limit order for matching. will be cancelled. The slippage threshold refers to the percentage that the order price deviates from the latest transaction price. The current threshold is set to 3% for BTC contracts and 5% for other contracts.
     * Supported timeInForce strategy:
     * GTC
     * IOC
     * FOK
     * PostOnly: If the order would be filled immediately when submitted, it will be cancelled. The purpose of this is to protect your order during the submission process. If the matching system cannot entrust the order to the order book due to price changes on the market, it will be cancelled. For the PostOnly order type, the quantity that can be submitted in a single order is more than other types of orders, please refer to the parameter lotSizeFilter > postOnlyMaxOrderQty in the instruments-info endpoint.
     *
     * How to create conditional order:
     * When submitting an order, if triggerPrice is set, the order will be automatically converted into a conditional order. In addition, the conditional order does not occupy the margin. If the margin is insufficient after the conditional order is triggered, the order will be cancelled.
     *
     * Take profit / Stop loss: You can set TP/SL while placing orders. Besides, you could modify the position's TP/SL.
     *
     * Order quantity: The quantity of perpetual contracts you are going to buy/sell. For the order quantity, Bybit only supports positive number at present.
     *
     * Order price: Place a limit order, this parameter is required. If you have position, the price should be higher than the liquidation price. For the minimum unit of the price change, please refer to the priceFilter > tickSize field in the instruments-info endpoint.
     *
     * orderLinkId: You can customize the active order ID. We can link this ID to the order ID in the system. Once the active order is successfully created, we will send the unique order ID in the system to you. Then, you can use this order ID to cancel active orders, and if both orderId and orderLinkId are entered in the parameter input, Bybit will prioritize the orderId to process the corresponding order. Meanwhile, your customized order ID should be no longer than 36 characters and should be unique.
     *
     * Open orders up limit:
     * Future: Each account can hold a maximum of 500 active orders simultaneously. This is contract-specific, so the following situation is allowed: the same account can hold 300 BTCUSD active orders and 280 ETHUSD active orders at the same time. For conditional orders, each account can hold a maximum of 10 active orders simultaneously. When the upper limit of orders is reached, you can still place orders with parameters of reduceOnly or closeOnTrigger.
     * Spot: No limit for normal order but a maximum of 30 open TP/SL orders
     * Option: a maximum of 100 open orders
     *
     * Rate limit:
     * Please refer to rate limit table. If you need to raise the rate limit, please contact your client manager or submit an application via here
     *
     * TIP
     * To margin trade on spot on a normal account, you need to go here to borrow margin first.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    GenericResponse<OrderResponse> newOrder(NewOrderRequest order);

    /**
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Option
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * IMPORTANT
     * You can only modify unfilled or partially filled orders.
     *
     * @param order the existed order to amend.
     * @return a response containing details about the newly placed order.
     */
    GenericResponse<OrderResponse> amendOrder(AmendOrderRequest order);

    /**
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     *
     * IMPORTANT
     * You must specify orderId or orderLinkId to cancel the order.
     * If orderId and orderLinkId do not match, the system will process orderId first.
     * You can only cancel unfilled or partially filled orders.
     *
     * @param order the existed order to cancel.
     * @return a response containing details about the newly placed order.
     */
    GenericResponse<OrderResponse> cancelOrder(CancelOrderRequest order);


    /**
     * Query unfilled or partially filled orders in real-time. To query older order records, please use the order history interface.
     *
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     *
     * TIP
     * It also supports querying filled, cancelled, and rejected orders which occurred in last 10 minutes (check the openOnly param). At most, 500 orders will be returned.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId > orderLinkId > symbol > baseCoin.
     * The records are sorted by the createdTime from newest to oldest.
     *
     * @param order get all real time open orders
     * @return
     */
    GenericResponse<OrderResult> getOpenOrders(OpenOrderRequest order);
}
