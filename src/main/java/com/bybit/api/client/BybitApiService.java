package com.bybit.api.client;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.account.request.ResetMMPRequest;
import com.bybit.api.client.domain.account.request.SetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.SetMMPRequest;
import com.bybit.api.client.domain.account.request.SetMarginModeRequest;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeRePayRequest;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.user.UserDataRequest;
import com.bybit.api.client.domain.user.request.CreateApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.ModifyApiKeyRequest;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Bybit's REST API URL mappings and endpoint security configuration.
 */
public interface BybitApiService {
    // Market data endpoints

    /**
     * Get Bybit Server Time
     * https://bybit-exchange.github.io/docs/v5/market/time
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * timeSecond	string	Bybit server timestamp (sec)
     * timeNano	string	Bybit server timestamp (nano)
     */
    @GET("/v5/market/time")
    Call<Object> getServerTime();

    /**
     * Get Kline
     * Query for historical klines (also known as candles/candlesticks). Charts are returned in groups based on the requested interval.
     *
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract
     *
     * https://bybit-exchange.github.io/docs/v5/market/time
     *
     * @param category true	string	Product type. spot,linear,inverse
     * @param symbol true	string	Symbol name
     * @param interval true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * @param start false	integer	The start timestamp (ms)
     * @param end false	integer	The end timestamp (ms)
     * @param limit false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * @return Response Parameters
     *      * Parameter	Type	Comments
     *      * category	string	Product type
     *      * symbol	string	Symbol name
     *      * list	array
     *      * An string array of individual candle
     *      * Sort in reverse by startTime
     *      * &gt; list[0]: startTime	string	Start time of the candle (ms)
     *      * &gt; list[1]: openPrice	string	Open price
     *      * &gt; list[2]: highPrice	string	Highest price
     *      * &gt; list[3]: lowPrice	string	Lowest price
     *      * &gt; list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
     *      * &gt; list[5]: volume	string	Trade volume. Unit of contract: pieces of contract. Unit of spot: quantity of coins
     *      * &gt; list[6]: turnover	string	Turnover. Unit of figure: quantity of quota coin
     */
    @GET("/v5/market/kline")
    Call<Object> getMarketLinesData(@Query("category") String category,
                                    @Query("symbol") String symbol,
                                    @Query("interval") String interval,
                                    @Query("start") Long start,
                                    @Query("end") Long end,
                                    @Query("limit") Integer limit);

    /**
     * Query for historical mark price klines. Charts are returned in groups based on the requested interval.
     * Covers: USDT perpetual / USDC contract / Inverse contract
     *
     * https://bybit-exchange.github.io/docs/v5/market/mark-kline
     *
     * @param category true	string	Product type. spot,linear,inverse
     * @param symbol true	string	Symbol name
     * @param interval true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * @param start false	integer	The start timestamp (ms)
     * @param end false	integer	The end timestamp (ms)
     * @param limit false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * symbol	string	Symbol name
     * list	array
     * An string array of individual candle
     * Sort in reverse by startTime
     * &gt; list[0]: startTime	string	Start time of the candle (ms)
     * &gt; list[1]: openPrice	string	Open price
     * &gt; list[2]: highPrice	string	Highest price
     * &gt; list[3]: lowPrice	string	Lowest price
     * &gt; list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
     */
    @GET("/v5/market/mark-price-kline")
    Call<Object> getMarketPriceLinesData(@Query("category") String category,
                                         @Query("symbol") String symbol,
                                         @Query("interval") String interval,
                                         @Query("start") Long start,
                                         @Query("end") Long end,
                                         @Query("limit") Integer limit);

    /**
     * Query for historical index price klines. Charts are returned in groups based on the requested interval.
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot,linear,inverse
     * symbol	true	string	Symbol name
     * interval	true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * start	false	integer	The start timestamp (ms)
     * end	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * https://bybit-exchange.github.io/docs/v5/market/index-kline
     */
    @GET("/v5/market/index-price-kline")
    Call<Object> getIndexPriceLinesData(@Query("category") String category,
                                        @Query("symbol") String symbol,
                                        @Query("interval") String interval,
                                        @Query("start") Long start,
                                        @Query("end") Long end,
                                        @Query("limit") Integer limit);


    /**
     * Query for historical index price klines. Charts are returned in groups based on the requested interval.
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot,linear,inverse
     * symbol	true	string	Symbol name
     * interval	true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * start	false	integer	The start timestamp (ms)
     * end	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * https://bybit-exchange.github.io/docs/v5/market/index-kline
     */
    @GET("/v5/market/premium-index-price-kline")
    Call<Object> getPremiumIndexPriceLinesData(@Query("category") String category,
                                               @Query("symbol") String symbol,
                                               @Query("interval") String interval,
                                               @Query("start") Long start,
                                               @Query("end") Long end,
                                               @Query("limit") Integer limit);

    /**
     * Get Instruments Info
     * Query for the instrument specification of online trading pairs.
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * CAUTION
     * Spot does not support pagination, so limit, cursor are invalid.
     * When query by baseCoin, regardless of category=linear or inverse, the result will have USDT perpetual, USDC contract and Inverse contract symbols.
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot,linear,inverse,option
     * symbol	false	string	Symbol name
     * status	false	string	Symbol status filter
     * spot/linear/inverse has Trading only
     * baseCoin	false	string	Base coin. linear,inverse,option only
     * For option, it returns BTC by default
     * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 500
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/market/instrument
     */
    @GET("/v5/market/instruments-info")
    Call<Object> getInstrumentsInfo(@Query("category") String category, @Query("symbol") String symbol, @Query("status") String status, @Query("baseCoin") String baseCoin,
                                    @Query("limit") Integer limit, @Query("cursor") String cursor);

    /**
     * Query for orderbook depth data.
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * future: 200-level of orderbook data
     * spot: 50-level of orderbook data
     * option: 25-level of orderbook data
     * TIP
     * The response is in the snapshot format.
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot,linear,inverse,option
     * symbol	false	string	Symbol name
     * status	false	string	Symbol status filter
     * spot/linear/inverse has Trading only
     * baseCoin	false	string	Base coin. linear,inverse,option only
     * For option, it returns BTC by default
     * limit	false	integer	Limit for data size per page. [1, 1000]. Default: 500
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/market/orderbook
     */
    @GET("/v5/market/orderbook")
    Call<Object> getMarketOrderBook(@Query("category") String category, @Query("symbol") String symbol, @Query("limit") Integer limit);

    /**
     * Get Tickers
     * Query for the latest price snapshot, best bid/ask price, and trading volume in the last 24 hours.
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * TIP
     * If category=option, symbol or baseCoin must be passed.
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot,linear,inverse,option
     * symbol	false	string	Symbol name
     * baseCoin	false	string	Base coin. For option only
     * expDate	false	string	Expiry date. e.g., 25DEC22. For option only
     * https://bybit-exchange.github.io/docs/v5/market/tickers
     */
    @GET("/v5/market/tickers")
    Call<Object> getMarketTickers(@Query("category") String category, @Query("symbol") String symbol, @Query("baseCoin") String baseCoin, @Query("expDate") String expDate);

    /**
     * Get Funding Rate History
     * Query for historical funding rates. Each symbol has a different funding interval. For example, if the interval is 8 hours and the current time is UTC 12, then it returns the last funding rate, which settled at UTC 8.
     * To query the funding rate interval, please refer to the instruments-info endpoint.
     * Covers: USDT and USDC perpetual / Inverse perpetual
     * TIP
     * Passing only startTime returns an error.
     * Passing only endTime returns 200 records up till endTime.
     * Passing neither returns 200 records up till the current time.
     * https://bybit-exchange.github.io/docs/v5/market/history-fund-rate
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear,inverse
     * symbol	true	string	Symbol name
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 200]. Default: 200
     */
    @GET("/v5/market/funding/history")
    Call<Object> getFundingHistory(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit);

    /**
     * Get Public Recent Trading History
     * Query recent public trading data in Bybit.
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * You can download archived historical trades here:
     * USDT Perpetual, Inverse Perpetual and Inverse Futures
     * https://bybit-exchange.github.io/docs/v5/market/recent-trade
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot,linear,inverse,option
     * symbol	false	string	Symbol name
     * required for spot/linear/inverse
     * optional for option
     * baseCoin	false	string	Base coin. For option only. If not passed, return BTC data by default
     * optionType	false	string	Option type. Call or Put. For option only
     * limit	false	integer	Limit for data size per page.
     * spot: [1,60], default: 60.
     * others: [1,1000], default: 500
     */
    @GET("/v5/market/recent-trade")
    Call<Object> getRecentTradeData(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("baseCoin") String baseCoin,
            @Query("optionType") String optionType,
            @Query("limit") Integer limit);

    /**
     * Get Open Interest
     * Get the open interest of each symbol.
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * INFO
     * Returns single side data
     * The upper limit time you can query is the launch time of the symbol.
     * https://bybit-exchange.github.io/docs/v5/market/open-interest
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear,inverse
     * symbol	true	string	Symbol name
     * intervalTime	true	string	Interval. 5min,15min,30min,1h,4h,1d
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 200]. Default: 50
     * cursor	false	string	Cursor. Used to paginate
     */
    @GET("/v5/market/kline")
    Call<Object> getOpenInterest(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("intervalTime") String intervalTime,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Get Historical Volatility
     * Query option historical volatility
     * Covers: Option
     * INFO
     * The data is hourly.
     * If both startTime and endTime are not specified, it will return the most recent 1 hours worth of data.
     * startTime and endTime are a pair of params. Either both are passed or they are not passed at all.
     * This endpoint can query the last 2 years worth of data, but make sure [endTime - startTime] &lt;= 30 days.
     * https://bybit-exchange.github.io/docs/v5/market/iv
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. option
     * baseCoin	false	string	Base coin. Default: return BTC data
     * period	false	integer	Period
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     */
    @GET("/v5/market/historical-volatility")
    Call<Object> getHistoricalVolatility(
            @Query("category") String category,
            @Query("baseCoin") String baseCoin,
            @Query("period") Integer period,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime);

    /**
     * Get Insurance
     * Query for Bybit insurance pool data (BTC/USDT/USDC etc). The data is updated every 24 hours.
     * https://bybit-exchange.github.io/docs/v5/market/insurance
     * @param coin
     * @return
     */
    @GET("/v5/market/insurance")
    Call<Object> getInsurance(@Query("coin") String coin);

    @GET("/v5/market/insurance")
    Call<Object> getInsurance();

    /**
     * Get Risk Limit
     * Query for the risk limit.
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * https://bybit-exchange.github.io/docs/v5/market/risk-limit
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear,inverse
     * symbol	false	string	Symbol name
     */
    @GET("/v5/market/risk-limit")
    Call<Object> getRiskLimit(@Query("category") String category,
                              @Query("symbol") String symbol);

    /**
     * Get Delivery Price
     * Get the delivery price.
     * Covers: USDC futures / Inverse futures / Option
     * HTTP Request
     * GET /v5/market/delivery-price
     * https://bybit-exchange.github.io/docs/v5/market/delivery-price
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear, inverse, option
     * symbol	false	string	Symbol name
     * baseCoin	false	string	Base coin. Default: BTC. valid for option only
     * limit	false	integer	Limit for data size per page. [1, 200]. Default: 50
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the
     */
    @GET("/v5/market/delivery-price")
    Call<Object> getDeliveryPrice(@Query("category") String category,
                                  @Query("symbol") String symbol,
                                  @Query("baseCoin") String baseCoin,
                                  @Query("limit") Integer limit,
                                  @Query("cursor") String cursor);

    /**
     * Get Long Short Ratio
     * https://bybit-exchange.github.io/docs/v5/market/long-short-ratio
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear(USDT Perpetual only),inverse
     * symbol	true	string	Symbol name
     * period	true	string	Data recording period. 5min, 15min, 30min, 1h, 4h, 4d
     * limit	false	integer	Limit for data size per page. [1, 500]. Default: 50
     */
    @GET("/v5/market/account-ratio")
    Call<Object> getMarketAccountRatio(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("period") String baseCoin,
                                       @Query("limit") Integer limit);

    // Trade
    /**
     * Get Order History
     * Query order history. As order creation/cancellation is asynchronous, the data returned from this endpoint may delay. If you want to get real-time order information, you could query this endpoint or rely on the websocket stream (recommended).
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * INFO
     * The orders in the last 7 days: supports querying all statuses
     * The orders beyond 7 days: supports querying filled orders
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * TIP
     * Classic account spot can get final status orders only
     * https://bybit-exchange.github.io/docs/v5/order/order-list
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/history")
    Call<Object> getHistoryOrderResult(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("baseCoin") String baseCoin,
                                       @Query("settleCoin") String settleCoin,
                                       @Query("orderId") String orderId,
                                       @Query("orderLinkId") String orderLinkId,
                                       @Query("orderFilter") String orderFilter,
                                       @Query("orderStatus") OrderStatus orderStatus,
                                       @Query("startTime") Long startTime,
                                       @Query("endTime") Long endTime,
                                       @Query("limit") Integer limit,
                                       @Query("cursor") String cursor);

    /**
     * Get Borrow Quota (Spot)
     * Query the qty and amount of borrowable coins in spot account.
     * Covers: Spot (Unified Account)
     * HTTP Request
     * GET /v5/order/spot-borrow-check
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot
     * symbol	true	string	Symbol name
     * side	true	string	Transaction side. Buy,Sell
     * Response Parameters
     * Parameter	Type	Comments
     * symbol	string	Symbol name
     * side	string	Side
     * maxTradeQty	string	The maximum base coin qty can be traded
     * If spot margin trade on and symbol is margin trading pair, it returns available balance + max.borrowable amount
     * Otherwise, it returns actual balance
     * maxTradeAmount	string	The maximum quote coin amount can be traded
     * If spot margin trade on and symbol is margin trading pair, it returns available balance + max.borrowable amount
     * Otherwise, it returns actual balance
     * borrowCoin	string	Borrow coin
     * https://bybit-exchange.github.io/docs/v5/order/spot-borrow-quota
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/spot-borrow-check")
    Call<Object> getBorrowQuota(@Query("category") String category,
                                @Query("symbol") String symbol,
                                @Query("side") String side);

    /**
     * Set Disconnect Cancel All
     * Covers: Option (Unified Account)
     * INFO
     * What is Disconnection Protect (DCP)?
     * Based on the websocket private connection and heartbeat mechanism, Bybit provides disconnection protection function. The timing starts from the first disconnection. If the Bybit server does not receive the reconnection from the client for more than 10 (default) seconds and resumes the heartbeat "ping", then the client is in the state of "disconnection protect", all active option orders of the client will be cancelled automatically. If within 10 seconds, the client reconnects and resumes the heartbeat "ping", the timing will be reset and restarted at the next disconnection.
     * How to enable DCP
     * If you need to turn it on/off, you can contact your client manager for consultation and application. The default time window is 10 seconds.
     * Applicable
     * Effective for options only.
     * TIP
     * After the request is successfully sent, the system needs a certain time to take effect. It is recommended to query or set again after 10 seconds
     * You can use this endpoint to get your current DCP configuration.
     * Your private websocket connection must subscribe "dcp" topic in order to trigger DCP successfully
     * https://bybit-exchange.github.io/docs/v5/order/dcp
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/disconnected-cancel-all")
    Call<Object> setDisconnectCancelAllTime(@Query("timeWindow") Integer timeWindow);

    /**
     * Get Open Orders
     * Query unfilled or partially filled orders in real-time. To query older order records, please use the order history interface.
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * TIP
     * It also supports querying filled, cancelled, and rejected orders which occurred in last 10 minutes (check the openOnly param). At most, 500 orders will be returned.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * The records are sorted by the createdTime from newest to oldest.
     * INFO
     * Classic account spot trade can return open orders only
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/order/realtime")
    Call<Object> getOpenOrders(@Query("category") String category,
                               @Query("symbol") String symbol,
                               @Query("baseCoin") String baseCoin,
                               @Query("settleCoin") String settleCoin,
                               @Query("orderId") String orderId,
                               @Query("orderLinkId") String orderLinkId,
                               @Query("openOnly") Integer openOnly,
                               @Query("orderFilter") String orderFilter,
                               @Query("limit") Integer limit,
                               @Query("cursor") String cursor);

    /**
     * Place Order
     * This endpoint supports to create the order for spot, spot margin, USDT perpetual, USDC perpetual, USDC futures, inverse futures and options.
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * INFO
     * Supported order type (orderType):
     * Limit order: orderType=Limit, it is necessary to specify order qty and price.
     * Market order: orderType=Market, execute at the best price in the Bybit market until the transaction is completed. When selecting a market order, the `price` is empty. In the futures trading system, in order to protect the serious slippage of the market order, the Bybit trading system will convert the market order into a limit order for matching. will be cancelled. The slippage threshold refers to the percentage that the order price deviates from the latest transaction price. The current threshold is set to 3% for BTC contracts and 5% for other contracts.
     * Supported timeInForce strategy:
     * GTC
     * IOC
     * FOK
     * PostOnly: If the order would be filled immediately when submitted, it will be cancelled. The purpose of this is to protect your order during the submission process. If the matching system cannot entrust the order to the order book due to price changes on the market, it will be cancelled. 
     * For the PostOnly order type, the quantity that can be submitted in a single order is more than other types of orders, please refer to the parameter lotSizeFilter  &gt;  postOnlyMaxOrderQty in the instruments-info endpoint.
     * How to create conditional order:
     * When submitting an order, if triggerPrice is set, the order will be automatically converted into a conditional order. In addition, the conditional order does not occupy the margin. If the margin is insufficient after the conditional order is triggered, the order will be cancelled.
     * Take profit / Stop loss: You can set TP/SL while placing orders. Besides, you could modify the position's TP/SL.
     * Order quantity: The quantity of perpetual contracts you are going to buy/sell. For the order quantity, Bybit only supports positive number at present.
     * Order price: Place a limit order, this parameter is required. If you have position, the price should be higher than the liquidation price. For the minimum unit of the price change, please refer to the priceFilter  &gt;  tickSize field in the instruments-info endpoint.
     * orderLinkId: You can customize the active order ID. We can link this ID to the order ID in the system. Once the active order is successfully created, we will send the unique order ID in the system to you. Then, you can use this order ID to cancel active orders, and if both orderId and orderLinkId are entered in the parameter input, Bybit will prioritize the orderId to process the corresponding order. Meanwhile, your customized order ID should be no longer than 36 characters and should be unique.
     * Open orders up limit:
     * Future: Each account can hold a maximum of 500 active orders simultaneously. This is contract-specific, so the following situation is allowed: the same account can hold 300 BTCUSD active orders and 280 ETHUSD active orders at the same time. For conditional orders, each account can hold a maximum of 10 active orders simultaneously. When the upper limit of orders is reached, you can still place orders with parameters of reduceOnly or closeOnTrigger.
     * Spot: 500 orders in total, including a maximum of 30 open TP/SL orders, a maximum of 30 open conditional orders
     * Option: a maximum of 100 open orders
     * Rate limit:
     * Please refer to rate limit table. If you need to raise the rate limit, please contact your client manager or submit an application via here
     * TIP
     * To margin trade on spot on a normal account, you need to go here to borrow margin first.
     * https://bybit-exchange.github.io/docs/v5/order/create-order
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/create")
    Call<Object> createOrder(@Body TradeOrderRequest tradeOrderRequest);

    /**
     * Batch Place Order
     * Covers: Option (UTA, UTA Pro) / USDT Perpetual, UDSC Perpetual, USDC Futures (UTA Pro)
     * TIP
     * This endpoint allows you to place more than one order in a single request.
     * Make sure you have sufficient funds in your account when placing an order. Once an order is placed, according to the funds required by the order, the funds in your account will be frozen by the corresponding amount during the life cycle of the order.
     * A maximum of 20 orders (option) and 10 orders (linear) can be placed per request. The returned data list is divided into two lists. The first list indicates whether or not the order creation was successful and the second list details the created order information. The structure of the two lists are completely consistent.
     * INFO
     * Check the rate limit instruction when category=linear here
     * https://bybit-exchange.github.io/docs/v5/order/batch-place
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear, option
     * request	true	array	Object
     *  &gt;  symbol	true	string	Symbol name
     *  &gt;  side	true	string	Buy, Sell
     *  &gt;  orderType	true	string	Market, Limit
     *  &gt;  qty	true	string	Order quantity
     * In particular, for linear, if you pass qty="0", you can close the whole position of current symbol
     *  &gt;  price	false	string	Order price
     * Market order will ignore this field
     * Please check the min price and price precision from instrument info endpoint
     * If you have position, price needs to be better than liquidation price
     *  &gt;  triggerDirection	false	integer	Conditional order param. Used to identify the expected direction of the conditional order.
     * 1: triggered when market price rises to triggerPrice
     * 2: triggered when market price falls to triggerPrice
     * Valid for linear
     *  &gt;  triggerPrice	false	string
     * For futures, it is the conditional order trigger price. If you expect the price to rise to trigger your conditional order, make sure:
     * triggerPrice  &gt;  market price
     * Else, triggerPrice &lt; market price
     *  &gt;  triggerBy	false	string	Conditional order param. Trigger price type. LastPrice, IndexPrice, MarkPrice
     *  &gt;  orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed. orderIv has a higher priority when price is passed as well
     *  &gt;  timeInForce	false	string	Time in force
     * Market order will use IOC directly
     * If not passed, GTC is used by default
     *  &gt;  positionIdx	false	integer	Used to identify positions in different position modes. Under hedge-mode, this param is required (USDT perps have hedge mode)
     * 0: one-way mode
     * 1: hedge-mode Buy side
     * 2: hedge-mode Sell side
     *  &gt;  orderLinkId	false	string	User customised order ID. A max of 36 characters. Combinations of numbers, letters (upper and lower cases), dashes, and underscores are supported.
     * Futures and Perps: orderLinkId rules:
     * optional param
     * always unique
     * option orderLinkId rules:
     * required param
     * always unique
     *  &gt;  takeProfit	false	string	Take profit price, valid for linear
     *  &gt;  stopLoss	false	string	Stop loss price, valid for linear
     *  &gt;  tpTriggerBy	false	string	The price type to trigger take profit. MarkPrice, IndexPrice, default: LastPrice.
     * Valid for linear
     *  &gt;  slTriggerBy	false	string	The price type to trigger stop loss. MarkPrice, IndexPrice, default: LastPrice
     * Valid for linear
     *  &gt;  reduceOnly	false	boolean	What is a reduce-only order? true means your position can only reduce in size if this order is triggered.
     * You must specify it as true when you are about to close/reduce the position
     * When reduceOnly is true, take profit/stop loss cannot be set
     * Valid for linear, and option
     *  &gt;  closeOnTrigger	false	boolean	What is a close on trigger order? For a closing order. It can only reduce your position, not increase it. If the account has insufficient available balance when the closing order is triggered, then other active orders of similar contracts will be cancelled or reduced. It can be used to ensure your stop loss reduces your position regardless of current available margin.
     * Valid for linear
     *  &gt;  smpType	false	string	Smp execution type. What is SMP?
     *  &gt;  mmp	false	boolean	Market maker protection. option only. true means set the order as a market maker protection order. What is mmp?
     *  &gt;  tpslMode	false	string	TP/SL mode
     * Full: entire position for TP/SL. Then, tpOrderType or slOrderType must be Market
     * Partial: partial position tp/sl. Limit TP/SL order are supported. Note: When create limit tp/sl, tpslMode is required and it must be Partial
     * Valid for linear
     *  &gt;  tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit
     * Valid for linear
     *  &gt;  slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit
     * Valid for linear
     *  &gt;  tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market
     * Valid for linear
     *  &gt;  slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market
     * Valid for linear
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear, option
     * request	true	array	Object
     *  &gt;  symbol	true	string	Symbol name
     *  &gt;  side	true	string	Buy, Sell
     *  &gt;  orderType	true	string	Market, Limit
     *  &gt;  qty	true	string	Order quantity
     * In particular, for linear, if you pass qty="0", you can close the whole position of current symbol
     *  &gt;  price	false	string	Order price
     * Market order will ignore this field
     * Please check the min price and price precision from instrument info endpoint
     * If you have position, price needs to be better than liquidation price
     *  &gt;  triggerDirection	false	integer	Conditional order param. Used to identify the expected direction of the conditional order.
     * 1: triggered when market price rises to triggerPrice
     * 2: triggered when market price falls to triggerPrice
     * Valid for linear
     *  &gt;  triggerPrice	false	string
     * For futures, it is the conditional order trigger price. If you expect the price to rise to trigger your conditional order, make sure:
     * triggerPrice  &gt;  market price
     * Else, triggerPrice  &gt; market price
     *  &gt;  triggerBy	false	string	Conditional order param. Trigger price type. LastPrice, IndexPrice, MarkPrice
     *  &gt;  orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed. orderIv has a higher priority when price is passed as well
     *  &gt;  timeInForce	false	string	Time in force
     * Market order will use IOC directly
     * If not passed, GTC is used by default
     *  &gt;  positionIdx	false	integer	Used to identify positions in different position modes. Under hedge-mode, this param is required (USDT perps have hedge mode)
     * 0: one-way mode
     * 1: hedge-mode Buy side
     * 2: hedge-mode Sell side
     *  &gt;  orderLinkId	false	string	User customised order ID. A max of 36 characters. Combinations of numbers, letters (upper and lower cases), dashes, and underscores are supported.
     * Futures and Perps: orderLinkId rules:
     * optional param
     * always unique
     * option orderLinkId rules:
     * required param
     * always unique
     *  &gt;  takeProfit	false	string	Take profit price, valid for linear
     *  &gt;  stopLoss	false	string	Stop loss price, valid for linear
     *  &gt;  tpTriggerBy	false	string	The price type to trigger take profit. MarkPrice, IndexPrice, default: LastPrice.
     * Valid for linear
     *  &gt;  slTriggerBy	false	string	The price type to trigger stop loss. MarkPrice, IndexPrice, default: LastPrice
     * Valid for linear
     *  &gt;  reduceOnly	false	boolean	What is a reduce-only order? true means your position can only reduce in size if this order is triggered.
     * You must specify it as true when you are about to close/reduce the position
     * When reduceOnly is true, take profit/stop loss cannot be set
     * Valid for linear, and option
     *  &gt;  closeOnTrigger	false	boolean	What is a close on trigger order? For a closing order. It can only reduce your position, not increase it. If the account has insufficient available balance when the closing order is triggered, then other active orders of similar contracts will be cancelled or reduced. It can be used to ensure your stop loss reduces your position regardless of current available margin.
     * Valid for linear
     *  &gt;  smpType	false	string	Smp execution type. What is SMP?
     *  &gt;  mmp	false	boolean	Market maker protection. option only. true means set the order as a market maker protection order. What is mmp?
     *  &gt;  tpslMode	false	string	TP/SL mode
     * Full: entire position for TP/SL. Then, tpOrderType or slOrderType must be Market
     * Partial: partial position tp/sl. Limit TP/SL order are supported. Note: When create limit tp/sl, tpslMode is required and it must be Partial
     * Valid for linear
     *  &gt;  tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit
     * Valid for linear
     *  &gt;  slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit
     * Valid for linear
     *  &gt;  tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market
     * Valid for linear
     *  &gt;  slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market
     * Valid for linear
     * @param batchOrderRequest
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/create-batch")
    Call<Object> createBatchOrder(@Body BatchOrderRequest batchOrderRequest);

    /**
     * Cancel Order
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * IMPORTANT
     * You must specify orderId or orderLinkId to cancel the order.
     * If orderId and orderLinkId do not match, the system will process orderId first.
     * You can only cancel unfilled or partially filled orders.
     * https://bybit-exchange.github.io/docs/v5/order/cancel-order
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel")
    Call<Object> cancelOrder(@Query("category") String category,
                             @Query("symbol") String symbol,
                             @Query("orderId") String orderId,
                             @Query("orderLinkId") String orderLinkId,
                             @Query("orderFilter") String orderFilter);

    /**
     * Batch Cancel Order
     * This endpoint allows you to cancel more than one open order in a single request.
     * Covers: Option (UTA, UTA Pro) / USDT Perpetual, UDSC Perpetual, USDC Futures (UTA Pro)
     * IMPORTANT
     * You must specify orderId or orderLinkId.
     * If orderId and orderLinkId is not matched, the system will process orderId first.
     * You can cancel unfilled or partially filled orders.
     * A maximum of 20 orders (option) and 10 orders (linear) can be cancelled per request.
     * HTTP Request
     * POST /v5/order/cancel-batch
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear, option
     * request	true	array	Object
     *  &gt;  symbol	true	string	Symbol name
     *  &gt;  orderId	false	string	Order ID. Either orderId or orderLinkId is required
     *  &gt;  orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     * https://bybit-exchange.github.io/docs/v5/order/batch-cancel
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel-batch")
    Call<Object> cancelBatchOrder(@Body BatchOrderRequest batchOrderRequest);

    /**
     * Cancel All Orders
     * Cancel all open orders
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * INFO
     * Support cancel orders by symbol/baseCoin/settleCoin. If you pass multiple of these params, the system will process one of param, which priority is symbol  &gt;  baseCoin  &gt;  settleCoin.
     * NOTE: category=option, you can cancel all option open orders without passing any of those three params. However, for linear and inverse, you must specify one of those three params.
     * NOTE: category=spot, you can cancel all spot open orders (normal order by default) without passing other params.
     * HTTP Request
     * POST /v5/order/cancel-all
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: spot, linear, inverse, option
     * Classic account: spot, linear, inverse
     * symbol	false	string	Symbol name. linear and inverse: Required if not passing baseCoin or settleCoin
     * baseCoin	false	string	Base coin
     * linear and inverse: If cancel all by baseCoin, it will cancel all linear and inverse orders. Required if not passing symbol or settleCoin
     * Classic spot: invalid
     * settleCoin	false	string	Settle coin
     * linear and inverse: Required if not passing symbol or baseCoin
     * Does not support spot
     * orderFilter	false	string
     * category=spot, you can pass Order, tpslOrder, StopOrder. If not passed, Order by default
     * category=linear or inverse, you can pass Order, StopOrder. If not passed, all kinds of orders will be cancelled, like active order, conditional order, TP/SL order and trailing stop order
     * category=option, you can pass Order. No matter it is passed or not, always cancel all orders
     * stopOrderType	false	string	Stop order type, Stop
     * Only used for category=linear or inverse and orderFilter=StopOrder,you can cancel conditional orders except TP/SL order and Trailing stop orders with this param
     * https://bybit-exchange.github.io/docs/v5/order/cancel-all
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel-all")
    Call<Object> cancelAllOrder(@Query("category") String category,
                                @Query("symbol") String symbol,
                                @Query("baseCoin") String baseCoin,
                                @Query("settleCoin") String settleCoin,
                                @Query("orderFilter") String orderFilter,
                                @Query("stopOrderType") String stopOrderType);

    /**
     * Amend Order
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Option
     * Classic account covers: USDT perpetual / Inverse contract
     * IMPORTANT
     * You can only modify unfilled or partially filled orders.
     * HTTP Request
     * POST /v5/order/amend
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse, option
     * Classic account: linear, inverse. Please note that category is not involved with business logic
     * symbol	true	string	Symbol name
     * orderId	false	string	Order ID. Either orderId or orderLinkId is required
     * orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     * orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed
     * triggerPrice	false	string	If you expect the price to rise to trigger your conditional order, make sure:
     * triggerPrice  &gt;  market price
     * Else, triggerPrice  &gt; market price
     * qty	false	string	Order quantity after modification. Do not pass it if not modify the qty
     * price	false	string	Order price after modification. Do not pass it if not modify the price
     * takeProfit	false	string	Take profit price after modification. If pass "0", it means cancel the existing take profit of the order. Do not pass it if you do not want to modify the take profit
     * stopLoss	false	string	Stop loss price after modification. If pass "0", it means cancel the existing stop loss of the order. Do not pass it if you do not want to modify the stop loss
     * tpTriggerBy	false	string	The price type to trigger take profit. When set a take profit, this param is required if no initial value for the order
     * slTriggerBy	false	string	The price type to trigger stop loss. When set a take profit, this param is required if no initial value for the order
     * triggerBy	false	string	Trigger price type
     * tpLimitPrice	false	string	Limit order price when take profit is triggered. Only working when original order sets partial limit tp/sl
     * slLimitPrice	false	string	Limit order price when stop loss is triggered. Only working when original order sets partial limit tp/sl
     * https://bybit-exchange.github.io/docs/v5/order/amend-order
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/amend")
    Call<Object> amendOrder(@Query("category") String category,
                            @Query("symbol") String symbol,
                            @Query("orderId") String orderId,
                            @Query("orderLinkId") String orderLinkId,
                            @Query("orderIv") String orderIv,
                            @Query("triggerPrice") String triggerPrice,
                            @Query("qty") String qty,
                            @Query("price") String price,
                            @Query("takeProfit") String takeProfit,
                            @Query("stopLoss") String stopLoss,
                            @Query("tpTriggerBy") TriggerBy tpTriggerBy,
                            @Query("slTriggerBy") TriggerBy slTriggerBy,
                            @Query("triggerBy") TriggerBy triggerBy,
                            @Query("tpLimitPrice") String tpLimitPrice,
                            @Query("slLimitPrice") String slLimitPrice);

    /**
     * Batch Amend Order
     * Covers: Option (UTA, UTA Pro) / USDT Perpetual, UDSC Perpetual, USDC Futures (UTA Pro)
     * TIP
     * This endpoint allows you to amend more than one open order in a single request.
     * You can modify unfilled or partially filled orders. Conditional orders are not supported.
     * A maximum of 20 orders (option) and 10 orders (linear) can be amended per request.
     * HTTP Request
     * POST /v5/order/amend-batch
     * https://bybit-exchange.github.io/docs/v5/order/batch-amend
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear, option
     * request	true	array	Object
     *  &gt;  symbol	true	string	Symbol name
     *  &gt;  orderId	false	string	Order ID. Either orderId or orderLinkId is required
     *  &gt;  orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     *  &gt;  orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed
     *  &gt;  triggerPrice	false	string	If you expect the price to rise to trigger your conditional order, make sure:
     * triggerPrice  &gt;  market price
     * Else, triggerPrice  &gt; market price
     *  &gt;  qty	false	string	Order quantity after modification. Do not pass it if not modify the qty
     *  &gt;  price	false	string	Order price after modification. Do not pass it if not modify the price
     *  &gt;  takeProfit	false	string	Take profit price after modification. If pass "0", it means cancel the existing take profit of the order. Do not pass it if you do not want to modify the take profit
     *  &gt;  stopLoss	false	string	Stop loss price after modification. If pass "0", it means cancel the existing stop loss of the order. Do not pass it if you do not want to modify the stop loss
     *  &gt;  tpTriggerBy	false	string	The price type to trigger take profit. When set a take profit, this param is required if no initial value for the order
     *  &gt;  slTriggerBy	false	string	The price type to trigger stop loss. When set a take profit, this param is required if no initial value for the order
     *  &gt;  triggerBy	false	string	Trigger price type
     *  &gt;  tpLimitPrice	false	string	Limit order price when take profit is triggered. Only working when original order sets partial limit tp/sl
     *  &gt;  slLimitPrice	false	string	Limit order price when stop loss is triggered. Only working when original order sets partial limit tp/sl
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/amend-batch")
    Call<Object> amendBatchOrder(@Body BatchOrderRequest batchOrderRequest);

    // User
    /**
     * Get API Key Information
     * Get the information of the api key. Use the api key pending to be checked to call the endpoint. Both master and sub user's api key are applicable.
     * TIP
     * Any permission can access this endpoint.
     * HTTP Request
     * GET /v5/user/query-api
     * Request Parameters
     * None
     * Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique ID. Internal use
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	Always ""
     * permissions	Object	The types of permission
     *  &gt;  ContractTrade	array	Permission of contract trade
     *  &gt;  Spot	array	Permission of spot
     *  &gt;  Wallet	array	Permission of wallet
     *  &gt;  Options	array	Permission of USDC Contract. It supports trade option and USDC perpetual.
     *  &gt;  Derivatives	array	Permission of derivatives
     *  &gt;  CopyTrading	array	Permission of copytrade. Not applicable to subaccount, always []
     *  &gt;  BlockTrade	array	Permission of blocktrade. Not applicable to subaccount, always []
     *  &gt;  Exchange	array	Permission of exchange
     *  &gt;  NFT	array	Permission of NFT. Not applicable to sub account, always []
     * ips	array	IP bound
     * type	integer	The type of api key. 1：personal, 2：connected to the third-party app
     * deadlineDay	integer	The remaining valid days of api key. Only for those api key with no IP bound or the password has been changed
     * expiredAt	datetime	The expiry day of the api key. Only for those api key with no IP bound or the password has been changed
     * createdAt	datetime	The create day of the api key
     * unified	integer	Whether the account to which the api key belongs is a unified margin account. 0：regular account; 1：unified margin account
     * uta	integer	Whether the account to which the account upgrade to unified trade account. 0：regular account; 1：unified trade account
     * userID	integer	User ID
     * inviterID	integer	Inviter ID (the UID of the account which invited this account to the platform)
     * vipLevel	string	VIP Level
     * mktMakerLevel	string	Market maker level
     * affiliateID	integer	Affiliate Id. 0 represents that there is no binding relationship.
     * rsaPublicKey	string	Rsa public key
     * isMaster	boolean	If this api key belongs to master account or not
     * parentUid	string	The main account uid. Returns "0" when the endpoint is called by main account
     * https://bybit-exchange.github.io/docs/v5/user/apikey-info
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/query-api")
    Call<Object> getCurrentAPIKeyInfo();

    /**
     * Get Sub UID List
     * Get all sub UID of master account. Use master user's api key only.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * HTTP Request
     * GET /v5/user/query-sub-members
     * Request Parameters
     * None
     * Response Parameters
     * Parameter	Type	Comments
     * subMembers	array	Object
     *  &gt;  uid	string	Sub user Id
     *  &gt;  username	string	Username
     *  &gt;  memberType	integer	1: normal sub account, 6: custodial sub account
     *  &gt;  status	integer	The status of the user account
     * 1: normal
     * 2: login banned
     * 4: frozen
     *  &gt;  accountMode	integer	The account mode of the user account
     * 1: classic account
     * 2: UMA
     * 3: UTA
     *  &gt;  remark	string	The remark
     * https://bybit-exchange.github.io/docs/v5/user/subuid-list
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/query-sub-members")
    Call<Object> getSubUIDList();

    /**
     * Get UID Wallet Type
     * Get available wallet types for the master account or sub account
     * TIP
     * Master api key: you can get master account and appointed sub account available wallet types, and support up to 200 sub UID in one request.
     * Sub api key: you can get its own available wallet types
     * PRACTICE
     * "FUND" - If you never deposit or transfer capital into it, this wallet type will not be shown in the array, but your account indeed has this wallet.
     * ["SPOT","OPTION","FUND","CONTRACT"] : Classic account and Funding wallet was operated before
     * ["SPOT","OPTION","CONTRACT"] : Classic account and Funding wallet is never operated
     * ["SPOT","UNIFIED","FUND","CONTRACT"] : UMA account and Funding wallet was operated before. (No UMA account after we forced upgrade to UTA)
     * ["SPOT","UNIFIED","CONTRACT"] : UMA account and Funding wallet is never operated. (No UMA account after we forced upgrade to UTA)
     * ["UNIFIED""FUND","CONTRACT"] : UTA account and Funding wallet was operated before.
     * ["UNIFIED","CONTRACT"] : UTA account and Funding wallet is never operated.
     * HTTP Request
     * GET /v5/user/get-member-type
     * Request Parameters
     * Parameter	Required	Type	Comments
     * memberIds	false	string
     * Query itself wallet types when not passed
     * When use master api key to query sub UID, master UID data is always returned in the top of the array
     * Multiple sub UID are supported, separated by commas
     * This param is ignored when you use sub account api key
     * Response Parameters
     * Parameter	Type	Comments
     * accounts	array	Object
     *  &gt;  uid	string	Master/Sub user Id
     *  &gt;  accountType	array	Wallets array. SPOT, CONTRACT, FUND, OPTION, UNIFIED. Please check above practice to understand the value
     * https://bybit-exchange.github.io/docs/v5/user/wallet-type
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/get-member-type")
    Call<Object> getUIDWalletType(@Query("memberIds") String memberIds);

    /**
     * Get Affiliate User Info
     * This API is used for affiliate to get their users information
     * TIP
     * Use master UID only
     * The api key can only have "Affiliate" permission
     * The transaction volume and deposit amount are the total amount of the user done on Bybit, and have nothing to do with commission settlement. Any transaction volume data related to commission settlement is subject to the Affiliate Portal.
     * HTTP Request
     * GET /v5/user/aff-customer-info
     * Request Parameters
     * Parameter	Required	Type	Comments
     * uid	true	string	The master account UID of affiliate's client
     * Response Parameters
     * Parameter	Type	Comments
     * uid	string	UID
     * vipLevel	string	VIP level
     * takerVol30Day	string	Taker volume in last 30 days (USDT). All volume related attributes below includes Derivatives, Option, Spot volume
     * makerVol30Day	string	Maker volume in last 30 days (USDT)
     * tradeVol30Day	string	Total trading volume in last 30 days (USDT)
     * depositAmount30Day	string	Deposit amount in last 30 days (USDT)
     * takerVol365Day	string	Taker volume in the past year (USDT)
     * makerVol365Day	string	Maker volume in the past year (USDT)
     * tradeVol365Day	string	Total trading volume in the past year (USDT)
     * depositAmount365Day	string	Total deposit amount in the past year (USDT)
     * totalWalletBalance	string	Wallet balance range
     * 1: less than 100 USDT value
     * 2: [100, 250) USDT value
     * 3: [250, 500) USDT value
     * 4: greater than 500 USDT value
     * depositUpdateTime	string	The update date time (UTC) of deposit data
     * volUpdateTime	string	The update date of volume data time (UTC)
     * https://bybit-exchange.github.io/docs/v5/user/affiliate-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/aff-customer-info")
    Call<Object> getAffiliateUserInfo(@Query("uid") String uid);

    /**
     * Create Sub UID
     * Create a new sub user id. Use master user's api key only.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * HTTP Request
     * POST /v5/user/create-sub-member
     * Request Parameters
     * Parameter	Required	Type	Comments
     * username	true	string	Give a username of the new sub user id.
     * 6-16 characters, must include both numbers and letters.
     * cannot be the same as the exist or deleted one.
     * password	false	string	Set the password for the new sub user id.
     * 8-30 characters, must include numbers, upper and lowercase letters.
     * memberType	true	integer	1: normal sub account, 6: custodial sub account
     * switch	false	integer
     * 0: turn off quick login (default)
     * 1: turn on quick login.
     * isUta	false	boolean
     * true: create UTA account
     * false(default): create classic account
     * note	false	string	Set a remark
     * Response Parameters
     * Parameter	Type	Comments
     * uid	string	Sub user Id
     * username	string	Give a username of the new sub user id.
     * 6-16 characters, must include both numbers and letters.
     * cannot be the same as the exist or deleted one.
     * memberType	integer	1: normal sub account, 6: custodial sub account
     * status	integer	The status of the user account
     * 1: normal
     * 2: login banned
     * 4: frozen
     * remark	string	The remark
     * https://bybit-exchange.github.io/docs/v5/user/create-subuid
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/create-sub-member")
    Call<Object> createSubMember(@Body UserSubMemberRequest userSubMemberRequest);

    /**
     * Create Sub UID
     * Create a new sub user id. Use master user's api key only.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * HTTP Request
     * POST /v5/user/create-sub-member
     * Request Parameters
     * Parameter	Required	Type	Comments
     * username	true	string	Give a username of the new sub user id.
     * 6-16 characters, must include both numbers and letters.
     * cannot be the same as the exist or deleted one.
     * password	false	string	Set the password for the new sub user id.
     * 8-30 characters, must include numbers, upper and lowercase letters.
     * memberType	true	integer	1: normal sub account, 6: custodial sub account
     * switch	false	integer
     * 0: turn off quick login (default)
     * 1: turn on quick login.
     * isUta	false	boolean
     * true: create UTA account
     * false(default): create classic account
     * note	false	string	Set a remark
     * Response Parameters
     * Parameter	Type	Comments
     * uid	string	Sub user Id
     * username	string	Give a username of the new sub user id.
     * 6-16 characters, must include both numbers and letters.
     * cannot be the same as the exist or deleted one.
     * memberType	integer	1: normal sub account, 6: custodial sub account
     * status	integer	The status of the user account
     * 1: normal
     * 2: login banned
     * 4: frozen
     * remark	string	The remark
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/create-sub-api")
    Call<Object> createSubAPI(@Body CreateApiKeyRequest createApiKeyRequest);

    /**
     * Modify Master API Key
     * Modify the settings of master api key. Use the api key pending to be modified to call the endpoint. Use master user's api key only.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * INFO
     * Only the api key that calls this interface can be modified
     * HTTP Request
     * POST /v5/user/update-api
     * Request Parameters
     * Parameter	Required	Type	Comments
     * readOnly	false	integer	0 (default)：Read and Write. 1：Read only
     * ips	false	string	Set the IP bind. example: "192.168.0.1,192.168.0.2"note:
     * don't pass ips or pass with "*" means no bind
     * No ip bound api key will be invalid after 90 days
     * api key will be invalid after 7 days once the account password is changed
     * permissions	false	Object	Tick the types of permission. Don't send this param if you don't want to change the permission
     *  &gt;  ContractTrade	false	array	Contract Trade. ["Order","Position"]
     *  &gt;  Spot	false	array	Spot Trade. ["SpotTrade"]
     *  &gt;  Wallet	false	array	Wallet. ["AccountTransfer","SubMemberTransfer"]
     *  &gt;  Options	false	array	USDC Contract. ["OptionsTrade"]
     *  &gt;  Derivatives	false	array	This param is depreciated because system will automatically add this permission according to your account is UTA or Classic
     *  &gt;  CopyTrading	false	array	Copytrade. ["CopyTrading"]
     *  &gt;  BlockTrade	false	array	Blocktrade. ["BlockTrade"]
     *  &gt;  Exchange	false	array	Exchange. ["ExchangeHistory"]
     *  &gt;  NFT	false	array	NFT. ["NFTQueryProductList"]
     *  &gt;  Affiliate	false	array	Affiliate. ["Affiliate"]
     * This permission is only useful for affiliate
     * If you need this permission, make sure you remove all other permissions
     * Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique id. Internal used
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	Always ""
     * permissions	Object	The types of permission
     *  &gt;  ContractTrade	array	Permisson of contract trade
     *  &gt;  Spot	array	Permisson of spot
     *  &gt;  Wallet	array	Permisson of wallet
     *  &gt;  Options	array	Permission of USDC Contract. It supports trade option and usdc perpetual.
     *  &gt;  Derivatives	array	Permission of Unified account
     *  &gt;  CopyTrading	array	Permission of copytrade. Not applicable to sub account, always []
     *  &gt;  BlockTrade	array	Permission of blocktrade. Not applicable to sub account, always []
     *  &gt;  Exchange	array	Permission of exchange
     *  &gt;  NFT	array	Permission of NFT. Not applicable to sub account, always []
     * ips	array	IP bound
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/update-api")
    Call<Object> modifyMasterApiKey(@Body ModifyApiKeyRequest modifyMasterApiKeyRequest);

    /**
     * Modify Sub API Key
     * Modify the settings of sub api key. Use the sub account api key pending to be modified to call the endpoint or use master account api key to manage its sub account api key.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint
     * sub API key: "Account Transfer", "Sub Member Transfer"
     * master API Key: "Account Transfer", "Sub Member Transfer", "Withdrawal"
     * HTTP Request
     * POST /v5/user/update-sub-api
     * Request Parameters
     * Parameter	Required	Type	Comments
     * apikey	false	string	Sub account api key
     * You must pass this param when you use master account manage sub account api key settings
     * If you use corresponding sub uid api key call this endpoint, apikey param cannot be passed, otherwise throwing an error
     * readOnly	false	integer	0 (default)：Read and Write. 1：Read only
     * ips	false	string	Set the IP bind. example: "192.168.0.1,192.168.0.2"note:
     * don't pass ips or pass with "*" means no bind
     * No ip bound api key will be invalid after 90 days
     * api key will be invalid after 7 days once the account password is changed
     * permissions	false	Object	Tick the types of permission. Don't send this param if you don't want to change the permission
     *  &gt;  ContractTrade	false	array	Contract Trade. ["Order","Position"]
     *  &gt;  Spot	false	array	Spot Trade. ["SpotTrade"]
     *  &gt;  Wallet	false	array	Wallet. ["AccountTransfer", "SubMemberTransferList"]
     *  &gt;  Options	false	array	USDC Contract. ["OptionsTrade"]
     *  &gt;  Derivatives	false	array	This param is depreciated because system will automatically add this permission according to your account is UTA or Classic
     *  &gt;  Exchange	false	array	Exchange. ["ExchangeHistory"]
     *  &gt;  CopyTrading	false	array	Copytrade. ["CopyTrading"]
     * Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique id. Internal used
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	Always ""
     * permissions	Object	The types of permission
     *  &gt;  ContractTrade	array	Permisson of contract trade
     *  &gt;  Spot	array	Permisson of spot
     *  &gt;  Wallet	array	Permisson of wallet
     *  &gt;  Options	array	Permission of USDC Contract. It supports trade option and usdc perpetual.
     *  &gt;  Derivatives	array	Permission of Unified account
     *  &gt;  CopyTrading	array	Permission of copytrade
     *  &gt;  BlockTrade	array	Permission of blocktrade. Not applicable to sub account, always []
     *  &gt;  Exchange	array	Permission of exchange
     *  &gt;  NFT	array	Permission of NFT. Not applicable to sub account, always []
     * ips	array	IP bound
     * https://bybit-exchange.github.io/docs/v5/user/modify-sub-apikey
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/update-sub-api")
    Call<Object> modifySubApiKey(@Body ModifyApiKeyRequest modifysubApiKeyRequest);

    /**
     * Delete Master API Key
     * Delete the api key of master account. Use the api key pending to be delete to call the endpoint. Use master user's api key only.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * DANGER
     * BE CAREFUL! The API key used to call this interface will be invalid immediately.
     * HTTP Request
     * POST /v5/user/delete-api
     * Request Parameters
     * None
     * Response Parameters
     * None
     * https://bybit-exchange.github.io/docs/v5/user/rm-master-apikey
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/delete-api")
    Call<Object> deleteMasterApiKey();

    /**
     * Delete Sub API Key
     * Delete the api key of sub account. Use the sub api key pending to be delete to call the endpoint or use the master api key to delete corresponding sub account api key
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint.
     * sub API key: "Account Transfer", "Sub Member Transfer"
     * master API Key: "Account Transfer", "Sub Member Transfer", "Withdrawal"
     * DANGER
     * BE CAREFUL! The Sub account API key will be invalid immediately after calling the endpoint.
     * HTTP Request
     * POST /v5/user/delete-sub-api
     * Request Parameters
     * Parameter	Required	Type	Comments
     * apikey	false	string	Sub account api key
     * You must pass this param when you use master account manage sub account api key settings
     * If you use corresponding sub uid api key call this endpoint, apikey param cannot be passed, otherwise throwing an error
     * Response Parameters
     * None
     * https://bybit-exchange.github.io/docs/v5/user/rm-sub-apikey
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/delete-sub-api")
    Call<Object> deleteSubApiKey(@Body ModifyApiKeyRequest deleteSubUidRequest);

    /**
     * Freeze Sub UID
     * Freeze Sub UID. Use master user's api key only.
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * HTTP Request
     * POST /v5/user/frozen-sub-member
     * Request Parameters
     * Parameter	Required	Type	Comments
     * subuid	true	integer	Sub user Id
     * frozen	true	integer	0：unfreeze, 1：freeze
     * https://bybit-exchange.github.io/docs/v5/user/froze-subuid
     * @param freezeSubUIDRquest
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/frozen-sub-member")
    Call<Object> freezeSubMember(@Body FreezeSubUIDRquest freezeSubUIDRquest);

    // Position Data endpoints

    /**
     * Get Position Info
     * Query real-time position data, such as position size, cumulative realizedPNL.
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: USDT perpetual / Inverse contract
     * INFO
     * Regarding inverse contracts,
     * you can query all holding positions with "/v5/position/list?category=inverse";
     * symbol parameter is supported to be passed with multiple symbols up to 10
     * HTTP Request
     * GET /v5/position/list
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse, option
     * Classic account: linear, inverse
     * symbol	false	string	Symbol name
     * If symbol passed, it returns data regardless of having position or not.
     * If symbol=null and settleCoin specified, it returns position size greater than zero.
     * baseCoin	false	string	Base coin. option only. Return all option positions if not passed
     * settleCoin	false	string	Settle coin. For linear, either symbol or settleCoin is required. symbol has a higher priority
     * limit	false	integer	Limit for data size per page. [1, 200]. Default: 20
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/position
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/position/list")
    Call<Object> getPositionInfo(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("baseCoin") String baseCoin,
                                 @Query("settleCoin") String settleCoin,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    /**
     * Set Leverage
     * Set the leverage
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * HTTP Request
     * POST /v5/position/set-leverage
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse. Please note that category is not involved with business logic
     * symbol	true	string	Symbol name
     * buyLeverage	true	string	[1, max leverage of corresponding risk limit]
     * Classic account: under one-way mode, buyLeverage must be the same as sellLeverage
     * Unified account: buyLeverage must be the same as sellLeverage all the time
     * sellLeverage	true	string	[1, max leverage of corresponding risk limit]
     * Classic account: under one-way mode, buyLeverage must be the same as sellLeverage
     * Unified account: buyLeverage must be the same as sellLeverage all the time
     * https://bybit-exchange.github.io/docs/v5/position/leverage
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-leverage")
    Call<Object> setPositionLeverage(
            @Body SetLeverageRequest setLeverageRequest);

    /**
     * Switch Cross/Isolated Margin
     * Select cross margin mode or isolated margin mode per symbol level
     * Unified account covers: Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * HTTP Request
     * POST /v5/position/switch-isolated
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: inverse
     * Classic account: linear, inverse. Please note that category is not involved with business logic
     * symbol	true	string	Symbol name
     * tradeMode	true	integer	0: cross margin. 1: isolated margin
     * buyLeverage	true	string	The value must be equal to sellLeverage value
     * sellLeverage	true	string	The value must be equal to buyLeverage value
     * https://bybit-exchange.github.io/docs/v5/position/cross-isolate
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/switch-isolated")
    Call<Object> swithMarginRequest(
            @Body SwitchMarginRequest switchMarginRequest);

    /**
     * Switch Position Mode
     * It supports to switch the position mode for USDT perpetual and Inverse futures. If you are in one-way Mode, you can only open one position on Buy or Sell side. If you are in hedge mode, you can open both Buy and Sell side positions simultaneously.
     * Unified account covers: USDT perpetual / Inverse Futures
     * Classic account covers: USDT perpetual / Inverse Futures
     * TIP
     * Priority for configuration to take effect: symbol  &gt;  coin  &gt;  system default
     * System default: one-way mode
     * If the request is by coin (settleCoin), then all symbols based on this setteCoin that do not have position and open order will be batch switched, and new listed symbol based on this settleCoin will be the same mode you set.
     * Example
     * System default	coin	symbol
     * Initial setting	one-way	never configured	never configured
     * Result	All USDT perpetual trading pairs are one-way mode
     * Change 1	-	-	Set BTCUSDT to hedge-mode
     * Result	BTCUSDT becomes hedge-mode, and all other symbols keep one-way mode
     * list new symbol ETHUSDT	ETHUSDT is one-way mode （inherit default rules）
     * Change 2	-	Set USDT to hedge-mode	-
     * Result	All current trading pairs with no positions or orders are hedge-mode, and no adjustments will be made for trading pairs with positions and orders
     * list new symbol SOLUSDT	SOLUSDT is hedge-mode (Inherit coin rule)
     * Change 3	-	-	Set ASXUSDT to one-mode
     * Take effect result	AXSUSDT is one-way mode, other trading pairs have no change
     * list new symbol BITUSDT	BITUSDT is hedge-mode (Inherit coin rule)
     * The position-switch ability for each contract
     * Classic account	Unified account
     * USDT perpetual	Support one-way and hedge-mode	Support one-way and hedge-mode
     * USDC perpetual	Support one-way only	Support one-way only
     * Inverse perpetual	Support one-way only	Support one-way only
     * Inverse future	Support one-way and hedge-mode	Support one-way and hedge-mode
     * HTTP Request
     * POST /v5/position/switch-mode
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, USDT Perp; inverse, Inverse Futures
     * Classic account: linear, USDT Perp; inverse, Inverse Futures. Please note that category is not involved with business logic
     * symbol	false	string	Symbol name. Either symbol or coin is required. symbol has a higher priority
     * coin	false	string	Coin
     * mode	true	integer	Position mode. 0: Merged Single. 3: Both Sides
     * https://bybit-exchange.github.io/docs/v5/position/position-mode
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/switch-mode")
    Call<Object> switchPositionMode(
            @Body SwitchPositionModeRequest switchPositionModeRequest);

    /**
     * Set TP/SL Mode
     * TIP
     * To some extent, this endpoint is depreciated because now tpsl is based on order level. This API was used for position level change before.
     * However, you still can use it to set an implicit tpsl mode for a certain symbol because when you don't pass "tpslMode" in the place order or trading stop request, system will get the tpslMode by the default setting.
     * Set TP/SL mode to Full or Partial
     * Unified account covers: USDT perpetual / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * INFO
     * For partial TP/SL mode, you can set the TP/SL size smaller than position size.
     * HTTP Request
     * POST /v5/position/set-tpsl-mode
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse. Please note that category is not involved with business logic
     * symbol	true	string	Symbol name
     * tpSlMode	true	string	TP/SL mode. Full,Partial
     * https://bybit-exchange.github.io/docs/v5/position/tpsl-mode
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-tpsl-mode")
    Call<Object> setTpslMode(
            @Body SetTpSlModeRequest setTpSlModeRequest);

    /**
     * Set Risk Limit
     * The risk limit will limit the maximum position value you can hold under different margin requirements. If you want to hold a bigger position size, you need more margin. This interface can set the risk limit of a single position. If the order exceeds the current risk limit when placing an order, it will be rejected.
     * Click here to learn more about risk limit.
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * TIP
     * Set the risk limit of the position. You can get risk limit information for each symbol here.
     * HTTP Request
     * POST /v5/position/set-risk-limit
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse. Please note that category is not involved with business logic
     * symbol	true	string	Symbol name
     * riskId	true	integer	Risk limit ID
     * positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode, it is required
     * 0: one-way mode
     * 1: hedge-mode Buy side
     * 2: hedge-mode Sell side
     * https://bybit-exchange.github.io/docs/v5/position/set-risk-limit
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-risk-limit")
    Call<Object> setRiskLimit(
            @Body SetRiskLimitRequest setRiskLimitRequest);

    /**
     * Set Trading Stop
     * Set the take profit, stop loss or trailing stop for the position.
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * TIP
     * Passing these parameters will create conditional orders by the system internally. The system will cancel these orders if the position is closed,
     * and adjust the qty according to the size of the open position.
     * INFO
     * New version of TP/SL function supports both holding entire position TP/SL orders and holding partial position TP/SL orders.
     * Full position TP/SL orders: This API can be used to modify the parameters of existing TP/SL orders.
     * Partial position TP/SL orders: This API can only add partial position TP/SL orders.
     * NOTE
     * Under the new version of Tp/SL function, when calling this API to perform one-sided take profit or stop loss modification on existing TP/SL orders on the holding position,
     * it will cause the paired tp/sl orders to lose binding relationship. This means that when calling the cancel API through the tp/sl order ID, it will only cancel the corresponding one-sided take profit or stop loss order ID.
     * HTTP Request
     * POST /v5/position/trading-stop
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse. Please note that category is not involved with business logic
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
     * https://bybit-exchange.github.io/docs/v5/position/trading-stop
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/trading-stop")
    Call<Object> setTradingStop(
            @Body TradingStopRequest tradingStopRequest);

    /**
     * Set Auto Add Margin
     * Turn on/off auto-add-margin for isolated margin position
     * Unified account covers: USDT perpetual / USDC perpetual / USDC futures / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * HTTP Request
     * POST /v5/position/set-auto-add-margin
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse
     * symbol	true	string	Symbol name
     * autoAddMargin	true	integer	Turn on/off. 0: off. 1: on
     * positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode position, this param is required
     * 0: one-way mode
     * 1: hedge-mode Buy side
     * 2: hedge-mode Sell side
     * https://bybit-exchange.github.io/docs/v5/position/auto-add-margin
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-auto-add-margin")
    Call<Object> setAutoAddMargin(
            @Body SetAutoAddMarginRequest setAutoAddMarginRequest);

    /**
     * Add Or Reduce Margin
     * Manually add or reduce margin for isolated margin position
     * Unified account covers: USDT perpetual / USDC perpetual / USDC futures / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * HTTP Request
     * POST /v5/position/add-margin
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse
     * symbol	true	string	Symbol name
     * margin	true	string	Add or reduce. To add, then 10; To reduce, then -10. Support up to 4 decimal
     * positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode position, this param is required
     * 0: one-way mode
     * 1: hedge-mode Buy side
     * 2: hedge-mode Sell side
     * https://bybit-exchange.github.io/docs/v5/position/manual-add-margin
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/add-margin")
    Call<Object> modifyPositionMargin(
            @Body ModifyMarginRequest modifyMarginRequest);

    /**
     * Get Execution
     * Query users' execution records, sorted by execTime in descending order. However, for Classic spot, they are sorted by execId in descending order.
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * TIP
     * Response items will have sorting issues When 'execTime' is the same. This issue is currently being optimized and will be released at the end of October. If you want to receive real-time execution information, Use the websocket stream (recommended).
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * HTTP Request
     * GET /v5/execution/list
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: spot, linear, inverse, option
     * Classic account: spot, linear, inverse
     * symbol	false	string	Symbol name
     * orderId	false	string	Order ID
     * orderLinkId	false	string	User customised order ID. Classic account does not support this param
     * baseCoin	false	string	Base coin. Unified account - inverse and Classic account do not support this param
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * execType	false	string	Execution type. Classic spot is not supported
     * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/position/execution
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/execution/list")
    Call<Object> getExecutionList(@Query("category") String category,
                                  @Query("symbol") String symbol,
                                  @Query("orderId") String orderId,
                                  @Query("orderLinkId") String orderLinkId,
                                  @Query("baseCoin") String baseCoin,
                                  @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime,
                                  @Query("execType") String execType,
                                  @Query("limit") Integer limit,
                                  @Query("cursor") String cursor);

    /**
     * Get Closed PnL
     * Query user's closed profit and loss records. The results are sorted by createdTime in descending order.
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * HTTP Request
     * GET /v5/position/closed-pnl
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type
     * Unified account: linear, inverse
     * Classic account: linear, inverse. Please note that category is not involved with business logic
     * symbol	false	string	Symbol name
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/position/close-pnl
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/position/closed-pnl")
    Call<Object> getClosePnlList(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("startTime") Long startTime,
                                 @Query("endTime") Long endTime,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    // Pre upgrade data endpoints

    /**
     * Get Pre-upgrade Closed PnL
     * Query user's closed profit and loss records from before you upgraded the account to a Unified account. The results are sorted by createdTime in descending order.
     * For now, it only supports to query USDT perpetual, Inverse perpetual and futures.
     * HTTP Request
     * GET /v5/pre-upgrade/position/closed-pnl
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type linear, inverse
     * symbol	true	string	Symbol name
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/close-pnl
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/position/closed-pnl")
    Call<Object> getPreUpgradeClosePnl(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("startTime") Long startTime,
                                       @Query("endTime") Long endTime,
                                       @Query("limit") Integer limit,
                                       @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Option Delivery Record
     * Query delivery records of Option before you upgraded the account to a Unified account, sorted by deliveryTime in descending order
     * HTTP Request
     * GET /v5/pre-upgrade/asset/delivery-record
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. option
     * symbol	false	string	Symbol name
     * expDate	false	string	Expiry date. 25MAR22. Default: return all
     * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
     * cursor	false	string	Cursor. Used for pagination
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/delivery
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/asset/delivery-record")
    Call<Object> getPreUpgradeOptionDelivery(@Query("category") String category,
                                             @Query("symbol") String symbol,
                                             @Query("expDate") String expDate,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Order History
     * After the account is upgraded to a Unified account, you can get the orders which occurred before the upgrade.
     * INFO
     * can get all status in 7 days
     * can only get filled orders beyond 7 days
     * HTTP Request
     * GET /v5/pre-upgrade/order/history
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear, inverse, option
     * symbol	false	string	Symbol name.
     * If not passed, return settleCoin=USDT by default
     * To get USDC perp, please pass symbol
     * baseCoin	false	string	Base coin. Used for option query
     * orderId	false	string	Order ID
     * orderLinkId	false	string	User customised order ID
     * orderFilter	false	string	Order: active order, StopOrder: conditional order
     * orderStatus	false	string	Order status
     * startTime	false	integer	The start timestamp (ms)
     * startTime and endTime must be passed together
     * If not passed, query the past 7 days data by default
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/order-list
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/order/history")
    Call<Object> getPreUpgradeOrderHistory(@Query("category") String category,
                                           @Query("symbol") String symbol,
                                           @Query("baseCoin") String baseCoin,
                                           @Query("orderId") String orderId,
                                           @Query("orderLinkId") String orderLinkId,
                                           @Query("orderFilter") String orderFilter,
                                           @Query("orderStatus") String orderStatus,
                                           @Query("startTime") Long startTime,
                                           @Query("endTime") Long endTime,
                                           @Query("limit") Integer limit,
                                           @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Trade History
     * Get users' execution records which occurred before you upgraded the account to a Unified account, sorted by execTime in descending order
     * For now, it supports to query USDT perpetual, USDC perpetual, Inverse perpetual and futures, Option.
     * TIP
     * Response items will have sorting issues When 'execTime' is the same. This issue is currently being optimized and will be released at the end of October. If you want to receive real-time execution information, Use the websocket stream (recommended).
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * HTTP Request
     * GET /v5/pre-upgrade/execution/list
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type linear, inverse, option
     * symbol	false	string	Symbol name
     * orderId	false	string	Order ID
     * orderLinkId	false	string	User customised order ID
     * baseCoin	false	string	Base coin. Used for option
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * execType	false	string	Execution type
     * limit	false	integer	Limit for data size per page. [1, 100]. Default: 50
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/execution
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/execution/list")
    Call<Object> getPreUpgradeTradeHistory(@Query("category") String category,
                                           @Query("symbol") String symbol,
                                           @Query("orderId") String orderId,
                                           @Query("orderLinkId") String orderLinkId,
                                           @Query("baseCoin") String baseCoin,
                                           @Query("startTime") Long startTime,
                                           @Query("endTime") Long endTime,
                                           @Query("execType") String execType,
                                           @Query("limit") Integer limit,
                                           @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Transaction Log
     * Query transaction logs which occurred in the USDC Derivatives wallet before the account was upgraded to a Unified account.
     * You can get USDC Perpetual, Option records.
     * HTTP Request
     * GET /v5/pre-upgrade/account/transaction-log
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	false	string	Product type. linear,option
     * baseCoin	false	string	BaseCoin. e.g., BTC of BTCPERP
     * type	false	string	Types of transaction logs
     * startTime	false	integer	The start timestamp (ms) of creation
     * endTime	false	integer	The end timestamp (ms) of creation
     * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
     * cursor	false	string	Cursor. Used for pagination
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/transaction-log
     * @param category
     * @param baseCoin
     * @param type
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/account/transaction-log")
    Call<Object> getPreUpgradeTransaction(@Query("category") String category,
                                          @Query("baseCoin") String baseCoin,
                                          @Query("type") String type,
                                          @Query("startTime") Long startTime,
                                          @Query("endTime") Long endTime,
                                          @Query("limit") Integer limit,
                                          @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade USDC Session Settlement
     * Query session settlement records of USDC perpetual before you upgrade the account to Unified account.
     * HTTP Request
     * GET /v5/pre-upgrade/asset/settlement-record
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. linear
     * symbol	false	string	Symbol name
     * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
     * cursor	false	string	Cursor. Used for pagination
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/settlement
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/asset/settlement-record")
    Call<Object> getPreUpgradeUsdcSettlement(@Query("category") String category,
                                             @Query("symbol") String symbol,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    // Account Data endpoints

    /**
     * Get Wallet Balance
     * Obtain wallet balance, query asset information of each currency, and account risk rate information. By default, currency information with assets or liabilities of 0 is not returned.
     * TIP
     * The trading of UTA inverse contracts is conducted through the CONTRACT wallet.
     * To get Funding wallet balance, please go to this endpoint
     * HTTP Request
     * GET /v5/account/wallet-balance
     * Request Parameters
     * Parameter	Required	Type	Comments
     * accountType	true	string	Account type
     * Unified account: UNIFIED (trade spot/linear/options), CONTRACT(trade inverse)
     * Classic account: CONTRACT, SPOT
     * coin	false	string	Coin name
     * If not passed, it returns non-zero asset info
     * You can pass multiple coins to query, separated by comma. USDT,USDC
     * https://bybit-exchange.github.io/docs/v5/account/wallet-balance
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/wallet-balance")
    Call<Object> getWalletBalance(@Query("accountType") String accountType,
                                  @Query("coin") String coin);

    /**
     * Upgrade to Unified Account
     * Upgrade Unified Account
     * UPGRADE GUIDANCE
     * Check your current account status by calling this Get Account Info
     * if unifiedMarginStatus=1, then it is classic account, you can call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * if unifiedMarginStatus=2, then it is UMA, you need to call below upgrade endpoint twice. The first call, your account will be upgraded to UTA, please make sure you call this Get Account Info and unifiedMarginStatus=3, then you can start the 2nd call, if you see unifiedMarginStatus=4, then it is UTA Pro.
     * if unifiedMarginStatus=3, then it is UTA, you need to call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * IMPORTANT
     * Banned / Express path users cannot upgrade the account to Unified Account for now.
     * INFO
     * You can upgrade the normal acct to unified acct without closing positions now, but please note belows:
     * Please avoid upgrading during these period:
     * every hour	50th minute to 5th minute of next hour
     * Please ensure:
     * No open order and debt in the Spot account
     * No open order and hedge-mode USDT position or isolated margin USDT position in the Derivatives account
     * No open order in the USDC Derivatives account
     * Cannot have TPSL order either
     * When the unifiedUpgradeProcess = PROCESS, it means that the system needs asynchronous verification processing, and the upgrade result cannot be returned in real time.
     * You can check API Get Account Info after 3-5 minutes, check whether the upgrade is successful according to the "unifiedMarginStatus" field in the return.
     * During the account upgrade process, the data of Rest API/Websocket stream may be inaccurate due to the fact that the account-related asset data is in the processing state.
     * It is recommended to query and use it after the upgrade is completed.
     * HTTP Request
     * POST /v5/account/upgrade-to-uta
     * Request Parameters
     * None
     * Response Parameters
     * Parameter	Type	Comments
     * unifiedUpdateStatus	string	Upgrade status. FAIL,PROCESS,SUCCESS
     * unifiedUpdateMsg	Object	If PROCESS,SUCCESS, it returns null
     *  &gt;  msg	array	Error message array. Only FAIL will have this f
     * https://bybit-exchange.github.io/docs/v5/account/upgrade-unified-account
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/upgrade-to-uta")
    Call<Object> upgradeAccountToUTA();

    /**
     * Get Borrow History
     * Get interest records, sorted in reverse order of creation time.
     * Unified account
     * HTTP Request
     * GET /v5/account/borrow-history
     * Request Parameters
     * Parameter	Required	Type	Comments
     * currency	false	string	USDC,USDT,BTC,ETH
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end time. timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * https://bybit-exchange.github.io/docs/v5/account/borrow-history
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/borrow-history")
    Call<Object> getAccountBorrowHistory(@Query("currency") String currency,
                                         @Query("startTime") Long startTime,
                                         @Query("endTime") Long endTime,
                                         @Query("limit") Integer limit,
                                         @Query("cursor") String cursor);

    /**
     * Set Collateral Coin
     * You can decide whether the assets in the Unified account needs to be collateral coins.
     * HTTP Request
     * POST /v5/account/set-collateral-switch
     * Request Parameters
     * Parameter	Required	Type	Comments
     * coin	true	string	Coin name
     * You can get collateral coin from here
     * USDT, USDC cannot be switched off
     * collateralSwitch	true	string	ON: switch on collateral, OFF: switch off collateral
     * https://bybit-exchange.github.io/docs/v5/account/set-collateral
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-collateral-switch")
    Call<Object> setAccountCollateralCoin(@Body SetCollateralCoinRequest setCollateralCoinRequest);

    /**
     * Get Collateral Info
     * Get the collateral information of the current unified margin account, including loan interest rate, loanable amount, collateral conversion rate, whether it can be mortgaged as margin, etc.
     * HTTP Request
     * GET /v5/account/collateral-info
     * Request Parameters
     * Parameter	Required	Type	Comments
     * currency	false	string	Asset currency of all current collateral
     * Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     *  &gt;  currency	string	Currency of all current collateral
     *  &gt;  hourlyBorrowRate	string	Hourly borrow rate
     *  &gt;  maxBorrowingAmount	string	Max borrow amount. This value is shared across main-sub UIDs
     *  &gt;  freeBorrowingAmount	string	Depreciated field, always return "", please refer to freeBorrowingLimit
     *  &gt;  freeBorrowingLimit	string	The maximum limit for interest-free borrowing
     *  &gt;  freeBorrowAmount	string	The amount of borrowing within your total borrowing amount that is exempt from interest charges
     *  &gt;  borrowAmount	string	Borrow amount
     *  &gt;  availableToBorrow	string	Available amount to borrow. This value is shared across main-sub UIDs
     *  &gt;  borrowable	boolean	Whether currency can be borrowed
     *  &gt;  borrowUsageRate	string	Borrow usage rate: borrowAmount/maxBorrowingAmount. It is an actual value between 0 and 1
     *  &gt;  marginCollateral	boolean	Whether it can be used as a margin collateral currency (platform)
     * When marginCollateral=false, then collateralSwitch is meaningless
     *  &gt;  collateralSwitch	boolean	Whether the collateral is turned on by user (user)
     * When marginCollateral=true, then collateralSwitch is meaningful
     *  &gt;  collateralRatio	string	Collateral ratio
     * https://bybit-exchange.github.io/docs/v5/account/collateral-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/collateral-info")
    Call<Object> getAccountCollateralInfo(@Query("currency") String currency);

    /**
     * Get Coin Greeks
     * Get current account Greeks information
     * HTTP Request
     * GET /v5/asset/coin-greeks
     * Request Parameters
     * Parameter	Required	Type	Comments
     * baseCoin	false	string	Base coin. If not passed, all supported base coin greeks will be returned by default
     * Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     *  &gt;  baseCoin	string	Base coin. e.g.,BTC,ETH,SOL
     *  &gt;  totalDelta	string	Delta value
     *  &gt;  totalGamma	string	Gamma value
     *  &gt;  totalVega	string	Vega value
     *  &gt;  totalTheta	string	Theta value
     * https://bybit-exchange.github.io/docs/v5/account/coin-greeks
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/coin-greeks")
    Call<Object> getAccountCoinGeeks(@Query("baseCoin") String baseCoin);

    /**
     * Get Fee Rate
     * Get the trading fee rate.
     * Covers: Spot / USDT perpetual / USDC perpetual / USDC futures / Inverse perpetual / Inverse futures / Options
     * HTTP Request
     * GET /v5/account/fee-rate
     * Request Parameters
     * Parameter	Required	Type	Comments
     * category	true	string	Product type. spot, linear, inverse, option
     * symbol	false	string	Symbol name. Valid for linear, inverse, spot
     * baseCoin	false	string	Base coin. SOL, BTC, ETH. Valid for option
     * Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type. spot, option. Derivatives does not have this field
     * list	array	Object
     *  &gt;  symbol	string	Symbol name. Keeps "" for Options
     *  &gt;  baseCoin	string	Base coin. SOL, BTC, ETH
     * Derivatives does not have this field
     * Keeps "" for Spot
     *  &gt;  takerFeeRate	string	Taker fee rate
     *  &gt;  makerFeeRate	string	Maker fee rate
     * https://bybit-exchange.github.io/docs/v5/account/fee-rate
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/fee-rate")
    Call<Object> getAccountFreeRate(@Query("category") String category,
                                    @Query("symbol") String symbol,
                                    @Query("baseCoin") String baseCoin);

    /**
     * Get Account Info
     * Query the margin mode configuration of the account.
     * NOTE
     * Query the margin mode and the upgraded status of account
     * HTTP Request
     * GET /v5/account/info
     * Request Parameters
     * None
     * Response Parameters
     * Parameter	Type	Comments
     * unifiedMarginStatus	integer	Account status
     * marginMode	string	ISOLATED_MARGIN, REGULAR_MARGIN, PORTFOLIO_MARGIN
     * dcpStatus	string	Disconnected-CancelAll-Prevention status: ON, OFF
     * timeWindow	integer	DCP trigger time window which user pre-set. Between [3, 300] seconds, default: 10 sec
     * smpGroup	integer	Smp group ID. If the UID has no group, it is 0 by default
     * isMasterTrader	boolean	Whether the account is a master trader (copytrading). true, false
     * updatedTime	string	Account data updated timestamp (ms)
     * https://bybit-exchange.github.io/docs/v5/account/account-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/info")
    Call<Object> getAccountInfo();

    /**
     * Get Transaction Log
     * Query transaction logs in Unified account.
     * HTTP Request
     * GET /v5/account/transaction-log
     * Request Parameters
     * Parameter	Required	Type	Comments
     * accountType	false	string	Account Type. UNIFIED
     * category	false	string	Product type. spot,linear,option
     * currency	false	string	Currency
     * baseCoin	false	string	BaseCoin. e.g., BTC of BTCPERP
     * type	false	string	Types of transaction logs
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
     * cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     *  &gt;  id	string	Unique id
     *  &gt;  symbol	string	Symbol name
     *  &gt;  category	string	Product type
     *  &gt;  side	string	Side. Buy,Sell,None
     *  &gt;  transactionTime	string	Transaction timestamp (ms)
     *  &gt;  type	string	Type
     *  &gt;  qty	string	Quantity
     *  &gt;  size	string	Size
     *  &gt;  currency	string	USDC、USDT、BTC、ETH
     *  &gt;  tradePrice	string	Trade price
     *  &gt;  funding	string	Funding fee
     * Positive value means receiving funding fee
     * Negative value means deducting funding fee
     *  &gt;  fee	string	Trading fee
     * Positive fee value means expense
     * Negative fee value means rebates
     *  &gt;  cashFlow	string	Cash flow, e.g., (1) close the position, and unRPL converts to RPL, (2) 8-hour session settlement for USDC Perp and Futures, (3) transfer in or transfer out. This does not include trading fee, funding fee
     *  &gt;  change	string	Change = cashFlow + funding - fee
     *  &gt;  cashBalance	string	Cash balance. This is the wallet balance after a cash change
     *  &gt;  feeRate	string
     * When type=TRADE, then it is trading fee rate
     * When type=SETTLEMENT, it means funding fee rate. For side=Buy, feeRate=market fee rate; For side=Sell, feeRate= - market fee rate
     *  &gt;  bonusChange	string	The change of bonus
     *  &gt;  tradeId	string	Trade ID
     *  &gt;  orderId	string	Order ID
     *  &gt;  orderLinkId	string	User customised order ID
     * nextPageCursor	string	Refer to the cursor request parameter
     * https://bybit-exchange.github.io/docs/v5/account/transaction-log
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/transaction-log")
    Call<Object> getTransactionLog(@Query("accountType") String accountType,
                                   @Query("category") String category,
                                   @Query("currency") String currency,
                                   @Query("baseCoin") String baseCoin,
                                   @Query("type") String type,
                                   @Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime,
                                   @Query("limit") Integer limit,
                                   @Query("cursor") String cursor);

    /**
     * Set Margin Mode
     * Default is regular margin mode
     * INFO
     * UTA account can be switched between these 3 kinds of margin modes, which is across UID level, working for USDT Perp, USDC Perp, USDC Futures and Options (Option does not support ISOLATED_MARGIN)
     * Classic account can be switched between REGULAR_MARGIN and PORTFOLIO_MARGIN, only work for USDC Perp and Options trading.
     * HTTP Request
     * POST /v5/account/set-margin-mode
     * Request Parameters
     * Parameter	Required	Type	Comments
     * setMarginMode	true	string	ISOLATED_MARGIN, REGULAR_MARGIN(i.e. Cross margin), PORTFOLIO_MARGIN
     * Response Parameters
     * Parameter	Type	Comments
     * reasons	array	Object. If requested successfully, it is an empty array
     *  &gt;  reasonCode	string	Fail reason code
     *  &gt;  reasonMsg	string	Fail reason msg
     * https://bybit-exchange.github.io/docs/v5/account/set-margin-mode
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-margin-mode")
    Call<Object> setAccountMarginMode(@Body SetMarginModeRequest setMarginMode); // ISOLATED_MARGIN, REGULAR_MARGIN(i.e. Cross margin), PORTFOLIO_MARGIN

    /**
     * Set MMP
     * INFO
     * What is MMP?
     * Market Maker Protection (MMP) is an automated mechanism designed to protect market makers (MM) against liquidity risks and over-exposure in the market. It prevents simultaneous trade executions on quotes provided by the MM within a short time span. The MM can automatically pull their quotes if the number of contracts traded for an underlying asset exceeds the configured threshold within a certain time frame. Once MMP is triggered, any pre-existing MMP orders will be automatically canceled, and new orders tagged as MMP will be rejected for a specific duration — known as the frozen period — so that MM can reassess the market and modify the quotes.
     * How to enable MMP
     * Send an email to Bybit (financial.inst@bybit.com) or contact your business development (BD) manager to apply for MMP. After processed, the default settings are as below table:
     * Parameter	Type	Comments	Default value
     * baseCoin	string	Base coin	BTC
     * window	string	Time window (millisecond)	5000
     * frozenPeriod	string	Frozen period (millisecond)	100
     * qtyLimit	string	Quantity limit	100
     * deltaLimit	string	Delta limit	100
     * Applicable
     * Effective for options only. When you place an option order, set mmp=true, which means you mark this order as a mmp order.
     * HTTP Request
     * POST /v5/account/mmp-modify
     * Request Parameters
     * Parameter	Required	Type	Comments
     * baseCoin	true	string	Base coin
     * window	true	string	Time window (ms)
     * frozenPeriod	true	string	Frozen period (ms). "0" means the trade will remain frozen until manually reset
     * qtyLimit	true	string	Trade qty limit (positive and up to 2 decimal places)
     * deltaLimit	true	string	Delta limit (positive and up to 2 decimal places)
     * https://bybit-exchange.github.io/docs/v5/account/set-mmp
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/mmp-modify")
    Call<Object> modifyAccountMMP(@Body SetMMPRequest setMMPRequest);

    /**
     *Reset MMP
     * INFO
     * Once the mmp triggered, you can unfreeze the account by this endpoint, then qtyLimit and deltaLimit will be reset to 0.
     * If the account is not frozen, reset action can also remove previous accumulation, i.e., qtyLimit and deltaLimit will be reset to 0.
     * HTTP Request
     * POST /v5/account/mmp-reset
     * Request Parameters
     * Parameter	Required	Type	Comments
     * baseCoin	true	string	Base coin
     * https://bybit-exchange.github.io/docs/v5/account/reset-mmp
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/mmp-reset")
    Call<Object> resetAccountMMP(@Body ResetMMPRequest resetMMPRequest);

    /**
     * Get MMP State
     * HTTP Request
     * GET /v5/account/mmp-state
     *
     * Request Parameters
     * Parameter	Required	Type	Comments
     * baseCoin	true	string	Base coin
     * Response Parameters
     * Parameter	Type	Comments
     * result	array	Object
     *  &gt;  baseCoin	string	Base coin
     *  &gt;  mmpEnabled	boolean	Whether the account is enabled mmp
     *  &gt;  window	string	Time window (ms)
     *  &gt;  frozenPeriod	string	Frozen period (ms)
     *  &gt;  qtyLimit	string	Trade qty limit
     *  &gt;  deltaLimit	string	Delta limit
     *  &gt;  mmpFrozenUntil	string	Unfreeze timestamp (ms)
     *  &gt;  mmpFrozen	boolean	Whether the mmp is triggered.
     * true: mmpFrozenUntil is meaningful
     * false: please ignore the value of mmpFrozenUntil
     * https://bybit-exchange.github.io/docs/v5/account/get-mmp-state
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/mmp-state")
    Call<Object> getAccountMMPState(@Query("baseCoin") String baseCoin);

    // Asset Endpoints

    /**
     * Get Coin Exchange Records
     * Query the coin exchange records.
     * INFO
     * This endpoint currently is not available to get data after 12 Mar 2023. We will make it fully available later.
     * CAUTION
     * You may have a long delay of this endpoint.
     * https://bybit-exchange.github.io/docs/v5/asset/exchange
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/exchange/order-record")
    Call<Object> getAssetCoinExchangeRecords(@Query("fromCoin") String fromCoin,
                                             @Query("toCoin") String toCoin,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    /**
     * Get Delivery Record
     * Query delivery records of USDC futures and Options, sorted by deliveryTime in descending order
     * Unified account covers: USDC futures / Option
     * https://bybit-exchange.github.io/docs/v5/asset/delivery
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/delivery-record")
    Call<Object> getAssetDeliveryRecords(@Query("category") String category,
                                         @Query("symbol") String symbol,
                                         @Query("expDate") String expDate,
                                         @Query("limit") Integer limit,
                                         @Query("cursor") String cursor);

    /**
     * Get USDC Session Settlement
     * Query session settlement records of USDC perpetual and futures
     * Unified account covers: USDC perpetual / USDC futures
     * https://bybit-exchange.github.io/docs/v5/asset/settle

     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/settlement-record")
    Call<Object> getAssetUSDCSettlementRecords(@Query("category") String category,
                                               @Query("symbol") String symbol,
                                               @Query("limit") Integer limit,
                                               @Query("cursor") String cursor);

    /**
     * Get Asset Info
     * Query asset information
     * INFO
     * For now, it can query SPOT only.
     * https://bybit-exchange.github.io/docs/v5/asset/asset-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-asset-info")
    Call<Object> getAssetInfo(@Query("accountType") String accountType,
                              @Query("coin") String coin);


    /**
     * Get All Coins Balance
     * You could get all coin balance of all account types under the master account, and sub account.
     * IMPORTANT
     * It is not allowed to get master account coin balance via sub account api key.
     * https://bybit-exchange.github.io/docs/v5/asset/all-balance
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-account-coins-balance")
    Call<Object> getAssetAllCoinsBalance(@Query("accountType") String accountType,
                                         @Query("memberId") String memberId,
                                         @Query("coin") String coin,
                                         @Query("withBonus") String withBonus);

    /**
     * Get Single Coin Balance
     * Query the balance of a specific coin in a specific account type. Supports querying sub UID's balance. Also, you can check the transferable amount from master to sub account, sub to master account or sub to sub account, especially for user who has INS loan.
     * INFO
     * Sub account cannot query master account balance
     * Sub account can only check its own balance
     * Master account can check its own and its sub uids balance
     * https://bybit-exchange.github.io/docs/v5/asset/account-coin-balance
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-account-coin-balance")
    Call<Object> getAssetSingleCoinBalance(@Query("accountType") String accountType,
                                           @Query("toAccountType") String toAccountType,
                                           @Query("memberId") String memberId,
                                           @Query("toMemberId") String toMemberId,
                                           @Query("coin") String coin,
                                           @Query("withBonus") Integer withBonus,
                                           @Query("withTransferSafeAmount") Integer withTransferSafeAmount,
                                           @Query("withLtvTransferSafeAmount") Integer withLtvTransferSafeAmount);

    /**
     * Get Transferable Coins
     * Query the transferable coin list between each account type
     * https://bybit-exchange.github.io/docs/v5/asset/transferable-coin
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-transfer-coin-list")
    Call<Object> getAssetTransferableCoins(@Query("fromAccountType") String fromAccountType, @Query("toAccountType") String toAccountType);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     * https://bybit-exchange.github.io/docs/v5/asset/inter-transfer-list
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/transfer/inter-transfer")
    Call<Object> createAssetInternalTransfer(@Body AssetInternalTransferRequest assetInternalTransferRequest);

    /**
     * Get Sub UID
     * Query the sub UIDs under a main UID
     * CAUTION
     * Can query by the master UID's api key only
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-sub-member-list")
    Call<Object> getAssetTransferSubUidList();

    /**
     * Create Universal Transfer
     * Transfer between sub-sub or main-sub.
     * CAUTION
     * Can use master or sub acct api key to request
     * To use sub acct api key, it must have "SubMemberTransferList" permission
     * When use sub acct api key, it can only transfer to main account
     * If you encounter errorCode: 131228 and msg: your balance is not enough, please go to Get Single Coin Balance to check transfer safe amount.
     * You can not transfer between the same UID
     * https://bybit-exchange.github.io/docs/v5/asset/unitransfer
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/transfer/universal-transfer")
    Call<Object> createAssetUniversalTransfer(@Body AssetUniversalTransferRequest assetUniversalTransferRequest);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     * https://bybit-exchange.github.io/docs/v5/asset/inter-transfer-list

     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-inter-transfer-list")
    Call<Object> getAssetInternalTransferRecords(@Query("transferId") String transferId,
                                                 @Query("coin") String coin,
                                                 @Query("status") String status,
                                                 @Query("startTime") Long startTime,
                                                 @Query("endTime") Long endTime,
                                                 @Query("limit") Integer limit,
                                                 @Query("cursor") String cursor);

    /**
     * Get Universal Transfer Records
     * Query universal transfer records
     * TIP
     * Main acct api key or Sub acct api key are both supported
     * Main acct api key needs "SubMemberTransfer" permission
     * Sub acct api key needs "SubMemberTransferList" permission
     * https://bybit-exchange.github.io/docs/v5/asset/unitransfer-list
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-universal-transfer-list")
    Call<Object> getAssetUniversalTransferRecords(@Query("transferId") String transferId,
                                                  @Query("coin") String coin,
                                                  @Query("status") String status,
                                                  @Query("startTime") Long startTime,
                                                  @Query("endTime") Long endTime,
                                                  @Query("limit") Integer limit,
                                                  @Query("cursor") String cursor);

    /**
     * Get Allowed Deposit Coin Info
     * Query allowed deposit coin information. To find out paired chain of coin, please refer coin info api.
     * TIP
     * This is an endpoint that does not need authentication
     * https://bybit-exchange.github.io/docs/v5/asset/deposit-coin-
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-allowed-list")
    Call<Object> getAssetAllowedDepositCoinInfo(
            @Query("coin") String coin,
            @Query("chain") String chain,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);


    /**
     * Set Deposit Account
     * Set auto transfer account after deposit. The same function as the setting for Deposit on web GUI
     * INFO
     * Your funds will be deposited into FUND wallet by default. You can set the wallet for auto-transfer after deposit by this API.
     * Only main UID can access.
     * TIP
     * Unified trading account has FUND, UNIFIED, CONTRACT(for inverse derivatives)
     * Unified margin account has FUND, UNIFIED, CONTRACT(for inverse derivatives), SPOT
     * Normal account has FUND, OPTION(USDC account), CONTRACT(for inverse derivatives and derivatives), SPOT
     * https://bybit-exchange.github.io/docs/v5/asset/set-deposit-acct
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/deposit/deposit-to-account")
    Call<Object> setAssetDepositAccount(@Body SetAssetDepositAccountRequest setAssetDepositAccountRequest);

    /**
     * Get Deposit Records (on-chain)
     * Query deposit records.
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can use main or sub UID api key to query deposit records respectively.
     * https://bybit-exchange.github.io/docs/v5/asset/deposit-record
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-record")
    Call<Object> getAssetDepositRecords(
            @Query("coin") String coin,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Get Sub Deposit Records (on-chain)
     * Query subaccount's deposit records by main UID's API key.
     * TIP
     * endTime - startTime should be less than 30 days. Queries for the last 30 days worth of records by default.
     * https://bybit-exchange.github.io/docs/v5/asset/sub-deposit-record
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-sub-member-record")
    Call<Object> getAssetSubMembersDepositRecords(@Query("subMemberId") String subMemberId,
                                                  @Query("coin") String coin,
                                                  @Query("startTime") Long startTime,
                                                  @Query("endTime") Long endTime,
                                                  @Query("limit") Integer limit,
                                                  @Query("cursor") String cursor);

    /**
     * Get Internal Deposit Records (off-chain)
     * Query deposit records within the Bybit platform. These transactions are not on the blockchain.
     * RULES
     * The maximum difference between the start time and the end time is 30 days.
     * Support to get deposit records by Master or Sub Member Api Key
     * https://bybit-exchange.github.io/docs/v5/asset/internal-deposit-record
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-internal-record")
    Call<Object> getAssetInternalDepositRecords(@Query("coin") String coin,
                                                @Query("startTime") Long startTime,
                                                @Query("endTime") Long endTime,
                                                @Query("limit") Integer limit,
                                                @Query("cursor") String cursor);

    /**
     * Get Master Deposit Address
     * Query the deposit address information of MASTER account.
     * https://bybit-exchange.github.io/docs/v5/asset/master-deposit-addr
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-address")
    Call<Object> getAssetMasterDepositAddress(@Query("coin") String coin, @Query("chainType") String chainType);


    /**
     * Get Sub Deposit Address
     * Query the deposit address information of SUB account.
     * CAUTION
     * Can use master UID's api key only
     * https://bybit-exchange.github.io/docs/v5/asset/sub-deposit-addr
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-sub-member-address")
    Call<Object> getAssetSubMemberDepositAddress(@Query("coin") String coin,
                                                 @Query("chainType") String chainType,
                                                 @Query("subMemberId") String subMemberId);

    /**
     * Get Coin Info
     * Query coin information, including chain information, withdraw and deposit status.
     * https://bybit-exchange.github.io/docs/v5/asset/coin-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/coin/query-info")
    Call<Object> getAssetCoinInfo(@Query("coin") String coin);

    /**
     * Get Withdrawable Amount
     * INFO
     * How can partial funds be subject to delayed withdrawal requests?
     * On-chain deposit: If the number of on-chain confirmations has not reached a risk-controlled level, a portion of the funds will be frozen for a period of time until they are unfrozen.
     * Buying crypto: If there is a risk, the funds will be frozen for a certain period of time and cannot be withdrawn.
     * https://bybit-exchange.github.io/docs/v5/asset/delay-amount
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/withdraw/withdrawable-amount")
    Call<Object> getAssetWithdrawalAmount(@Query("coin") String coin);


    /**
     * Get Withdrawal Records
     * Query withdrawal records.
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can query by the master UID's api key only
     * https://bybit-exchange.github.io/docs/v5/asset/withdraw-record
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/withdraw/query-record")
    Call<Object> getAssetWithdrawalRecords(
            @Query("withdrawID") String withdrawID,
            @Query("coin") String coin,
            @Query("withdrawType") Integer withdrawType,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Cancel Withdrawal
     * Cancel the withdrawal
     * CAUTION
     * Can query by the master UID's api key only
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/withdraw/cancel")
    Call<Object> cancelAssetWithdraw(@Body AssetCancelWithdrawRequest assetCancelWithdrawRequest);

    /**
     * Withdraw
     * Withdraw assets from your Bybit account. You can make an off-chain transfer if the target wallet address is from Bybit. This means that no blockchain fee will be charged.
     * DANGER
     * UTA does not have SPOT account
     * How do I know if my account is a UTA account? Call this endpoint, and if uta=1, then it is a UTA account.
     * CAUTION
     * Make sure you have whitelisted your wallet address here
     * Can query by the master UID's api key only
     * FORMULA
     * feeType=0:
     * withdrawPercentageFee != 0: handlingFee = inputAmount / (1 - withdrawPercentageFee) * withdrawPercentageFee + withdrawFee
     * withdrawPercentageFee = 0: handlingFee = withdrawFee
     * feeType=1:
     * withdrawPercentageFee != 0: handlingFee = withdrawFee + (inputAmount - withdrawFee) * withdrawPercentageFee
     * withdrawPercentageFee = 0: handlingFee = withdrawFee
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/withdraw/create")
    Call<Object> createAssetWithdraw(@Body AssetWithdrawRequest assetWithdrawRequest);

    // Institution Endpoints
    /**
     * Get Product Info
     * TIP
     * This endpoint can be queried without api key and secret, then it returns public product data
     * If your uid is bound with OTC loan product, then you can get your private product data by calling the endpoint with api key and secret
     * If your uid is not bound with OTC loan product but api key and secret are also passed, it will return public data only
     * HTTP Request
     * GET /v5/ins-loan/product-infos
     * Request Parameters
     * Parameter	Required	Type	Comments
     * productId	false	string	Product Id. If not passed, then return all products info
     * https://bybit-exchange.github.io/docs/v5/otc/margin-product-info
     */
    @GET("/v5/ins-loan/product-infos")
    Call<Object> getInsProductInfo(@Query("productId") String productId);

    @GET("/v5/ins-loan/product-infos")
    Call<Object> getInsProductInfo();

    /**
     * Get Margin Coin Info
     * TIP
     * This endpoint can be queried without api key and secret, then it returns public margin data
     * If your uid is bound with OTC loan product, then you can get your private margin data by calling the endpoint with api key and secret
     * If your uid is not bound with OTC loan product but api key and secret are also passed, it will return public data only
     * Request Parameters
     * Parameter	Required	Type	Comments
     * productId	false	string	ProductId. If not passed, then return all product margin coin. For spot, it returns coin that convertRation greater than 0.
     * https://bybit-exchange.github.io/docs/v5/otc/margin-coin-convert-info
     */
    @GET("/v5/ins-loan/ensure-tokens-convert")
    Call<Object> getInsMarginCoinInfo(@Query("productId") String productId);

    @GET("/v5/ins-loan/ensure-tokens-convert")
    Call<Object> getInsMarginCoinInfo();

    /**
     * Get Loan Orders
     * Get loan orders information
     
     * TIP
     * Get the past 2 years data by default
     * Get up to the past 2 years of data
     * Request Parameters
     * Parameter	Required	Type	Comments
     * orderId	false	string	Loan order id. If not passed, then return all orders, sort by loanTime in descend
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size. [1, 100], Default: 10
     * https://bybit-exchange.github.io/docs/v5/otc/loan-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/loan-order")
    Call<Object> getInsLoanOrders(@Query("productId") String productId,
                                  @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime,
                                  @Query("limit") Integer limit);

    /**
     * Get Repay Orders
     * Get repaid order information
     * TIP
     * Get the past 2 years data by default
     * Get up to the past 2 years of data
     * HTTP Request
     * GET /v5/ins-loan/repaid-history
     * Request Parameters
     * Parameter	Required	Type	Comments
     * startTime	false	integer	The start timestamp (ms)
     * endTime	false	integer	The end timestamp (ms)
     * limit	false	integer	Limit for data size. [1, 100]. Default: 100
     * https://bybit-exchange.github.io/docs/v5/otc/repay-info
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/repaid-history")
    Call<Object> getInsRepayOrders(@Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime,
                                   @Query("limit") Integer limit);

    /**
     * Get LTV
     * HTTP Request
     * GET /v5/ins-loan/ltv-convert
     * https://bybit-exchange.github.io/docs/v5/otc/ltv-convert
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/ltv-convert")
    Call<Object> getInsLoanToValue();

    // Spot Data endpoints

    // Spot Leverage
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-lever-token/info")
    Call<Object> getSpotLeverageTokenInfo(@Query("ltCoin") String ltCoin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-lever-token/info")
    Call<Object> getSpotLeverageTokenInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-lever-token/reference")
    Call<Object> getSpotLeverageTokenMarket(@Query("ltCoin") String ltCoin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-lever-token/reference")
    Call<Object> getSpotLeverageTokenMarket();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-lever-token/purchase")
    Call<Object> purchaseSpotLeverageToken(@Body SpotLeverageTokenRequest spotLeverageTokenRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-lever-token/redeem")
    Call<Object> redeemSpotLeverageToken(@Body SpotLeverageTokenRequest spotLeverageTokenRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-lever-token/order-record")
    Call<Object> getSpotLeverageRecords(@Query("ltCoin") String ltCoin,
                                        @Query("orderId") String orderId,
                                        @Query("startTime") Long startTime,
                                        @Query("endTime") Long endTime,
                                        @Query("limit") Integer limit,
                                        @Query("ltOrderType") Integer ltOrderType,
                                        @Query("serialNo") String serialNo);

    // Spot Margin UTA
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-margin-trade/data")
    Call<Object> getUtaVipSpotMarginTradeData(@Query("vipLevel") String vipLevel,
                                              @Query("currency") String currency);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-margin-trade/switch-mode")
    Call<Object> setUTASpotMarginTrade(@Body String spotMarginMode);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-margin-trade/set-leverage")
    Call<Object> setUTASpotMarginTradeLeverage(@Body String leverage);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-margin-trade/state")
    Call<Object> getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/data")
    Call<Object> getNormalVipSpotMarginTradeData(@Query("vipLevel") String vipLevel,
                                                 @Query("currency") String currency);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/pledge-token")
    Call<Object> getNormalSpotMarginTradeCoinInfo(@Query("coin") String coin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/pledge-token")
    Call<Object> getNormalSpotMarginTradeCoinInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/borrow-token")
    Call<Object> getNormalSpotMarginTradeBorrowCoinInfo(@Query("coin") String coin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/borrow-token")
    Call<Object> getNormalSpotMarginTradeBorrowCoinInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/loan-info")
    Call<Object> getNormalSpotMarginTradeInterestQuota(@Query("coin") String coin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/account")
    Call<Object> getNormalSpotMarginTradeAccountInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-cross-margin-trade/switch")
    Call<Object> getNormalSpotToggleMarginTrade(@Body int switchStatus);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-cross-margin-trade/loan")
    Call<Object> loanNormalSpotMarginTrade(@Body SpotMarginTradeBorrowRequest spotMarginTradeBorrowRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-cross-margin-trade/repay")
    Call<Object> repayNormalSpotMarginTrade(@Body SpotMarginTradeRePayRequest spotMarginTradeRePayRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/orders")
    Call<Object> getNormalMarginTradeBorrowOrders(@Query("startTime") Long startTime,
                                                  @Query("endTime") Long endTime,
                                                  @Query("coin") String coin,
                                                  @Query("status") Integer status,
                                                  @Query("limit") Integer limit);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/spot-cross-margin-trade/repay-history")
    Call<Object> getNormalMarginTradeRepayOrders(@Query("startTime") Long startTime,
                                                 @Query("endTime") Long endTime,
                                                 @Query("coin") String coin,
                                                 @Query("limit") Integer limit);

    // Broker Endpoints
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/broker/earning-record")
    Call<Object> getBrokerEarningData(@Query("bizType") String bizType,
                                      @Query("startTime") Long startTime,
                                      @Query("endTime") Long endTime,
                                      @Query("limit") Integer limit,
                                      @Query("cursor") String cursor);

    // C2C Endpoints
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/lending/info")
    Call<Object> getC2CLendingCoinInfo(@Query("coin") String coin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/lending/info")
    Call<Object> getC2CLendingCoinInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/lending/purchase")
    Call<Object> C2cLendingDepositFunds(@Body ClientLendingFundsRequest depsoitFundRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/lending/redeem")
    Call<Object> C2cLendingRedeemFunds(@Body ClientLendingFundsRequest depsoitFundRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/lending/history-order")
    Call<Object> getC2cOrdersRecords(@Query("coin") String coin,
                                     @Query("orderId") String orderId,
                                     @Query("startTime") Long startTime,
                                     @Query("endTime") Long endTime,
                                     @Query("limit") Integer limit,
                                     @Query("orderType") String orderType);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/lending/account")
    Call<Object> getC2CLendingAccountInfo(@Query("coin") String coin);

    // Announcement
    @GET("/v5/announcements/index")
    Call<Object> getAnouncementInfo(
            @Query("locale") String locale,
            @Query("type") String type,
            @Query("tag") String tag,
            @Query("page") Integer page,
            @Query("limit") Integer limit);
}
