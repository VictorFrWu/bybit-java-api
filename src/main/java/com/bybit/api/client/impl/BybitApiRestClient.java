package com.bybit.api.client.impl;

import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.institution.InstitutionLoanOrdersRequest;
import com.bybit.api.client.domain.account.institution.InstitutionRepayOrdersRequest;
import com.bybit.api.client.domain.account.request.*;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.broker.request.BrokerEarningRequest;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.c2c.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.market.MarketInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.request.*;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.preupgrade.request.*;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageOrdersRecordRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.*;
import com.bybit.api.client.domain.trade.requests.*;
import com.bybit.api.client.domain.user.request.ApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.SubUserRequest;

public interface BybitApiRestClient {
    // Market Data

    /**
     * Get Bybit Server Time
     */
    Object getServerTime();

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @param category  product type. spot,linear, inverse (mandatory)
     * @param symbol    symbol to aggregate (mandatory)
     * @param interval  candlestick interval (mandatory)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    Object getMarketLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getMarketLinesData(ProductType, String, MarketInterval, Integer, Long, Long)
     */
    Object getMarketLinesData(ProductType category, String symbol, MarketInterval interval);

    /**
     * Query for historical mark price klines. Charts are returned in groups based on the requested interval.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     *
     * @param category  product type. spot,linear, inverse (mandatory)
     * @param symbol    symbol to aggregate (mandatory)
     * @param interval  candlestick interval (mandatory)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    Object getMarketPriceLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getMarketLinesData(ProductType, String, MarketInterval, Integer, Long, Long)
     */
    Object getMarketPriceLinesData(ProductType category, String symbol, MarketInterval interval);


    /**
     * Query for historical index price klines. Charts are returned in groups based on the requested interval.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     *
     * @param category  product type. spot,linear, inverse (mandatory)
     * @param symbol    symbol to aggregate (mandatory)
     * @param interval  candlestick interval (mandatory)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    Object getIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getMarketLinesData(ProductType, String, MarketInterval, Integer, Long, Long)
     */
    Object getIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval);

    /**
     * Query for historical index price klines. Charts are returned in groups based on the requested interval.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     *
     * @param category  product type. spot,linear, inverse (mandatory)
     * @param symbol    symbol to aggregate (mandatory)
     * @param interval  candlestick interval (mandatory)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    Object getPremiumIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Query for the instrument specification of online trading pairs.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * CAUTION
     * Spot does not support pagination, so limit, cursor are invalid.
     * When query by baseCoin, regardless of category=linear or inverse, the result will have USDT perpetual, USDC contract and Inverse contract symbols.
     *
     * @see #getMarketLinesData(ProductType, String, MarketInterval, Integer, Long, Long)
     */
    Object getPremiumIndexPriceLinesData(ProductType category, String symbol, MarketInterval interval);

    /**
     * Query for the instrument specification of online trading pairs.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * CAUTION
     * Spot does not support pagination, so limit, cursor are invalid.
     * When query by baseCoin, regardless of category=linear or inverse, the result will have USDT perpetual, USDC contract and Inverse contract symbols.
     *
     * @param instrumentInfoRequest
     * @return
     */
    Object getInstrumentsInfo(InstrumentInfoRequest instrumentInfoRequest);

    /**
     * Query for orderbook depth data.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * future: 200-level of orderbook data
     * spot: 50-level of orderbook data
     * option: 25-level of orderbook data
     * TIP
     * The response is in the snapshot format.
     *
     * @param category
     * @param symbol
     * @return
     */
    Object getMarketOrderbook(ProductType category, String symbol);

    Object getMarketOrderbook(ProductType category, String symbol, Integer limit);

    /**
     * Query for the latest price snapshot, best bid/ask price, and trading volume in the last 24 hours.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * TIP
     * If category=option, symbol or baseCoin must be passed.
     *
     * @param category
     * @param symbol
     * @return
     */
    Object getMarketTickers(ProductType category, String symbol);

    Object getMarketTickers(ProductType category, String symbol, String baseCoin, String expDate);

    /**
     * Query for historical funding rates. Each symbol has a different funding interval. For example, if the interval is 8 hours and the current time is UTC 12, then it returns the last funding rate, which settled at UTC 8.
     * <p>
     * To query the funding rate interval, please refer to the instruments-info endpoint.
     * <p>
     * Covers: USDT and USDC perpetual / Inverse perpetual
     * <p>
     * TIP
     * Passing only startTime returns an error.
     * Passing only endTime returns 200 records up till endTime.
     * Passing neither returns 200 records up till the current time.
     *
     * @param fundingHistoryRequest
     * @return
     */
    Object getFundingHistory(FundingHistoryRequest fundingHistoryRequest);

    /**
     * Query recent public trading data in Bybit.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * You can download archived historical trades here:
     * <p>
     * USDT Perpetual, Inverse Perpetual & Inverse Futures
     * Spot
     *
     * @param recentTradeRequest
     * @return
     */
    Object getRecentTradeData(RecentTradeDataRequest recentTradeRequest);

    /**
     * Get the open interest of each symbol.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * <p>
     * INFO
     * Returns single side data
     * The upper limit time you can query is the launch time of the symbol.
     *
     * @param openInterestRequest
     * @return
     */
    Object getOpenInterest(OpenInterestRequest openInterestRequest);

    /**
     * Query option historical volatility
     * <p>
     * Covers: Option
     * <p>
     * INFO
     * The data is hourly.
     * If both startTime and endTime are not specified, it will return the most recent 1 hours worth of data.
     * startTime and endTime are a pair of params. Either both are passed or they are not passed at all.
     * This endpoint can query the last 2 years worth of data, but make sure [endTime - startTime] <= 30 days.
     *
     * @param HistoricalVolatilityRequest
     * @return
     */
    Object getHistoricalVolatility(HistoricalVolatilityRequest HistoricalVolatilityRequest);
    // Trade

    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param orderHistoryRequest order request parameters
     * @return a list of all history orders 2 years
     */
    Object getHistoryOrderResult(OrderHistoryRequest orderHistoryRequest);

    /**
     * Get Insurance
     * Query for Bybit insurance pool data (BTC/USDT/USDC etc). The data is updated every 24 hours.
     *
     * @param coin
     * @return
     */
    Object getInsurance(String coin);

    Object getInsurance();

    /**
     * Get Risk Limit
     * Query for the risk limit.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     *
     * @param category
     * @param symbol
     * @return
     */
    Object getRiskLimit(ProductType category, String symbol);

    Object getRiskLimit(ProductType category);

    /**
     * Get Delivery Price
     * Get the delivery price.
     * <p>
     * Covers: USDC futures / Inverse futures / Option
     *
     * @param deliveryPriceRequest
     * @return
     */
    Object getDeliveryPrice(DeliveryPriceRequest deliveryPriceRequest);

    /**
     * This endpoint supports to create the order for spot, spot margin, USDT perpetual, USDC perpetual, USDC futures, inverse futures and options.
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * INFO
     * Supported order type (orderType):
     * Limit order: orderType=Limit, it is necessary to specify order qty and price.
     * <p>
     * Market order: orderType=Market, execute at the best price in the Bybit market until the transaction is completed. When selecting a market order, the `price` is empty. In the futures trading system, in order to protect the serious slippage of the market order, the Bybit trading system will convert the market order into a limit order for matching. will be cancelled. The slippage threshold refers to the percentage that the order price deviates from the latest transaction price. The current threshold is set to 3% for BTC contracts and 5% for other contracts.
     * Supported timeInForce strategy:
     * GTC
     * IOC
     * FOK
     * PostOnly: If the order would be filled immediately when submitted, it will be cancelled. The purpose of this is to protect your order during the submission process. If the matching system cannot entrust the order to the order book due to price changes on the market, it will be cancelled. For the PostOnly order type, the quantity that can be submitted in a single order is more than other types of orders, please refer to the parameter lotSizeFilter > postOnlyMaxOrderQty in the instruments-info endpoint.
     * <p>
     * How to create conditional order:
     * When submitting an order, if triggerPrice is set, the order will be automatically converted into a conditional order. In addition, the conditional order does not occupy the margin. If the margin is insufficient after the conditional order is triggered, the order will be cancelled.
     * <p>
     * Take profit / Stop loss: You can set TP/SL while placing orders. Besides, you could modify the position's TP/SL.
     * <p>
     * Order quantity: The quantity of perpetual contracts you are going to buy/sell. For the order quantity, Bybit only supports positive number at present.
     * <p>
     * Order price: Place a limit order, this parameter is required. If you have position, the price should be higher than the liquidation price. For the minimum unit of the price change, please refer to the priceFilter > tickSize field in the instruments-info endpoint.
     * <p>
     * orderLinkId: You can customize the active order ID. We can link this ID to the order ID in the system. Once the active order is successfully created, we will send the unique order ID in the system to you. Then, you can use this order ID to cancel active orders, and if both orderId and orderLinkId are entered in the parameter input, Bybit will prioritize the orderId to process the corresponding order. Meanwhile, your customized order ID should be no Longer than 36 characters and should be unique.
     * <p>
     * Open orders up limit:
     * Future: Each account can hold a maximum of 500 active orders simultaneously. This is contract-specific, so the following situation is allowed: the same account can hold 300 BTCUSD active orders and 280 ETHUSD active orders at the same time. For conditional orders, each account can hold a maximum of 10 active orders simultaneously. When the upper limit of orders is reached, you can still place orders with parameters of reduceOnly or closeOnTrigger.
     * Spot: No limit for normal order but a maximum of 30 open TP/SL orders
     * Option: a maximum of 100 open orders
     * <p>
     * Rate limit:
     * Please refer to rate limit table. If you need to raise the rate limit, please contact your client manager or submit an application via here
     * <p>
     * TIP
     * To margin trade on spot on a normal account, you need to go here to borrow margin first.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    Object newOrder(NewOrderRequest order);

    /**
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Option
     * Normal account covers: USDT perpetual / Inverse contract
     * <p>
     * IMPORTANT
     * You can only modify unfilled or partially filled orders.
     *
     * @param order the existed order to amend.
     * @return a response containing details about the newly placed order.
     */
    Object amendOrder(AmendOrderRequest order);

    /**
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * IMPORTANT
     * You must specify orderId or orderLinkId to cancel the order.
     * If orderId and orderLinkId do not match, the system will process orderId first.
     * You can only cancel unfilled or partially filled orders.
     *
     * @param order the existed order to cancel.
     * @return a response containing details about the newly placed order.
     */
    Object cancelOrder(CancelOrderRequest order);

    /**
     * Query unfilled or partially filled orders in real-time. To query older order records, please use the order history interface.
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * TIP
     * It also supports querying filled, cancelled, and rejected orders which occurred in last 10 minutes (check the openOnly param). At most, 500 orders will be returned.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId > orderLinkId > symbol > baseCoin.
     * The records are sorted by the createdTime from newest to oldest.
     *
     * @param order get all real time open orders
     * @return
     */
    Object getOpenOrders(OpenOrderRequest order);

    // User

    /**
     * Get the information of the api key. Use the api key pending to be checked to call the endpoint. Both master and sub user's api key are applicable.
     * <p>
     * TIP
     * Any permission can access this endpoint.
     *
     * @return
     */
    Object getCurrentAPIKeyInfo();

    /**
     * Get all sub uid of master account. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     */
    Object getSubUIDList();

    /**
     * Create a new sub user id. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     */
    Object createSubMember(SubUserRequest subUserRequest);

    /**
     * To create new API key for those newly created sub UID. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     */
    Object createSubAPI(ApiKeyRequest apiKeyRequest);

    /**
     * Freeze Sub UID. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     */
    Object freezeSubMember(FreezeSubUIDRquest freezeSubUIDRquest);

    /**
     * Get available wallet types for the master account or sub account
     * <p>
     * TIP
     * Master api key: you can get master account and appointed sub account available wallet types, and support up to 200 sub uid in one request.
     * Sub api key: you can get its own available wallet types
     * PRACTICE
     * "FUND" - If you never deposit or transfer capital into it, this wallet type will not be shown in the array, but your account indeed has this wallet.
     * <p>
     * ["SPOT","OPTION","FUND","CONTRACT"] : Normal account and Funding wallet was operated before
     * ["SPOT","OPTION","CONTRACT"] : Normal account and Funding wallet is never operated
     * ["SPOT","UNIFIED","FUND","CONTRACT"] : UMA account and Funding wallet was operated before. (No UMA account after we forced upgrade to UTA)
     * ["SPOT","UNIFIED","CONTRACT"] : UMA account and Funding wallet is never operated. (No UMA account after we forced upgrade to UTA)
     * ["UNIFIED""FUND","CONTRACT"] : UTA account and Funding wallet was operated before.
     * ["UNIFIED","CONTRACT"] : UTA account and Funding wallet is never operated.
     */
    Object getUIDWalletType(String memberIds);

    Object getUIDWalletType();

    /**
     * Get Affiliate User Info
     * This API is used for affiliate to get their users information
     * <p>
     * TIP
     * Use master UID only
     * The api key can only have "Affiliate" permission
     * The transaction volume and deposit amount are the total amount of the user done on Bybit, and have nothing to do with commission settlement.
     * Any transaction volume data related to commission settlement is subject to the Affiliate Portal.
     */
    Object getAffiliateUserInfo(String uid);

    // Position Data

    /**
     * Get Position Info
     * Query real-time position data, such as position size, cumulative realizedPNL.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * @param positionListRequest
     * @return
     */
    Object getPositionInfo(PositionListRequest positionListRequest);

    /**
     * Set Leverage
     * Set the leverage
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * @param setLeverageRequest
     * @return
     */
    Object setPositionLeverage(SetLeverageRequest setLeverageRequest);

    /**
     * Switch Cross/Isolated Margin
     * Select cross margin mode or isolated margin mode per symbol level
     * <p>
     * Unified account covers: Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * @param switchMarginRequest
     * @return
     */
    Object swithMarginRequest(SwitchMarginRequest switchMarginRequest);

    /**
     * Switch Position Mode
     * It supports to switch the position mode for USDT perpetual and Inverse futures. If you are in one-way Mode, you can only open one position on Buy or Sell side. If you are in hedge mode, you can open both Buy and Sell side positions simultaneously.
     * <p>
     * Unified account covers: USDT perpetual / Inverse Futures
     * Normal account covers: USDT perpetual / Inverse Futures
     * <p>
     * TIP
     * Priority for configuration to take effect: symbol > coin > system default     * : one-way mode
     * If the request is by coin (settleCoin), then all symbols based on this setteCoin that do not have position and open order will be batch switched, and new listed symbol based on this settleCoin will be the same mode you set.
     *
     * @param switchPositionModeRequest
     * @return
     */
    Object switchPositionMode(SwitchPositionModeRequest switchPositionModeRequest);

    /**
     * Set TP/SL Mode
     * TIP
     * To some extent, this endpoint is depreciated because now tpsl is based on order level. This API was used for position level change before.
     * <p>
     * However, you still can use it to set an implicit tpsl mode for a certain symbol because when you don't pass "tpslMode" in the place order or trading stop request, system will get the tpslMode by the default setting.
     * <p>
     * Set TP/SL mode to Full or Partial
     * <p>
     * Unified account covers: USDT perpetual / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     * <p>
     * INFO
     * For partial TP/SL mode, you can set the TP/SL size smaller than position size.
     *
     * @param setTpSlModeRequest
     * @return
     */
    Object setTpslMode(SetTpSlModeRequest setTpSlModeRequest);

    /**
     * Set Risk Limit
     * The risk limit will limit the maximum position value you can hold under different margin requirements. If you want to hold a bigger position size, you need more margin. This interface can set the risk limit of a single position. If the order exceeds the current risk limit when placing an order, it will be rejected. Click here to learn more about risk limit.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     * <p>
     * TIP
     * Set the risk limit of the position. You can get risk limit information for each symbol here.
     *
     * @param setRiskLimitRequest
     * @return
     */
    Object setRiskLimit(SetRiskLimitRequest setRiskLimitRequest);

    /**
     * Set Trading Stop
     * Set the take profit, stop loss or trailing stop for the position.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     * <p>
     * TIP
     * Passing these parameters will create conditional orders by the system internally. The system will cancel these orders if the position is closed, and adjust the qty according to the size of the open position.
     * <p>
     * INFO
     * New version of TP/SL function supports both holding entire position TP/SL orders and holding partial position TP/SL orders.
     * <p>
     * Full position TP/SL orders: This API can be used to modify the parameters of existing TP/SL orders.
     * Partial position TP/SL orders: This API can only add partial position TP/SL orders.
     * NOTE
     * Under the new version of Tp/SL function, when calling this API to perform one-sided take profit or stop loss modification on existing TP/SL orders on the holding position, it will cause the paired tp/sl orders to lose binding relationship. This means that when calling the cancel API through the tp/sl order ID, it will only cancel the corresponding one-sided take profit or stop loss order ID.
     *
     * @param tradingStopRequest
     * @return
     */
    Object setTradingStop(TradingStopRequest tradingStopRequest);

    /**
     * Set Auto Add Margin
     * Turn on/off auto-add-margin for isolated margin position
     * <p>
     * Unified account covers: USDT perpetual / USDC perpetual / USDC futures / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * @param setAutoAddMarginRequest
     * @return
     */
    Object setAutoAddMargin(SetAutoAddMarginRequest setAutoAddMarginRequest);

    /**
     * Add Or Reduce Margin
     * Manually add or reduce margin for isolated margin position
     * <p>
     * Unified account covers: USDT perpetual / USDC perpetual / USDC futures / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * @param modifyMarginRequest
     * @return
     */
    Object modifyPositionMargin(ModifyMarginRequest modifyMarginRequest);

    /**
     * Get Execution
     * Query users' execution records, sorted by execTime in descending order. However, for Normal spot, they are sorted by execId in descending order.
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Normal account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * TIP
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId > orderLinkId > symbol > baseCoin.
     *
     * @param executionHistoryRequest
     * @return
     */
    Object getExecutionList(ExecutionHistoryRequest executionHistoryRequest);

    /**
     * Get Closed PnL
     * Query user's closed profit and loss records. The results are sorted by createdTime in descending order.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Normal account covers: USDT perpetual / Inverse contract
     *
     * @param closePnlHistoryRequest
     * @return
     */
    Object getClosePnlList(ClosePnlHistoryRequest closePnlHistoryRequest);

    // Pre Upgrade

    /**
     * Get Pre-upgrade Order History
     * After the account is upgraded to a Unified account, you can get the orders which occurred before the upgrade.
     * <p>
     * INFO
     * can get all status in 7 days
     * can only get filled orders beyond 7 days
     *
     * @param preupgradeOderHistoryRequest
     * @return
     */
    Object getPreUpgradeOrderHistory(PreUpgradeOrderHistoryRequest preupgradeOderHistoryRequest);

    /**
     * Get Pre-upgrade Trade History
     * Get users' execution records which occurred before you upgraded the account to a Unified account, sorted by execTime in descending order
     * <p>
     * For now, it supports to query USDT perpetual, USDC perpetual, Inverse perpetual and futures, Option.
     * <p>
     * TIP
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId > orderLinkId > symbol > baseCoin.
     *
     * @param preUpgradeTradeHistoryRequest
     * @return
     */
    Object getPreUpgradeTradeHistory(PreUpgradeTradeHistoryRequest preUpgradeTradeHistoryRequest);

    /**
     * Get Pre-upgrade Closed PnL
     * Query user's closed profit and loss records from before you upgraded the account to a Unified account. The results are sorted by createdTime in descending order.
     * <p>
     * For now, it only supports to query USDT perpetual, Inverse perpetual and futures.
     *
     * @param preUpgradeClosePnlRequest
     * @return
     */
    Object getPreUpgradeClosePnl(PreUpgradeClosePnlRequest preUpgradeClosePnlRequest);

    /**
     * Get Pre-upgrade Transaction Log
     * Query transaction logs which occurred in the USDC Derivatives wallet before the account was upgraded to a Unified account.
     * <p>
     * You can get USDC Perpetual, Option records.
     *
     * @param preUpgradeTransactionRequest
     * @return
     */
    Object getPreUpgradeTransaction(PreUpgradeTransactionRequest preUpgradeTransactionRequest);

    /**
     * Get Pre-upgrade Option Delivery Record
     * Query delivery records of Option before you upgraded the account to a Unified account, sorted by deliveryTime in descending order
     *
     * @param preUpgradeOptionDeliveryRequest
     * @return
     */
    Object getPreUpgradeOptionDelivery(PreUpgradeOptionDeliveryRequest preUpgradeOptionDeliveryRequest);

    /**
     * Get Pre-upgrade USDC Session Settlement
     * Query session settlement records of USDC perpetual before you upgrade the account to Unified account.
     *
     * @param preUpgradeUsdcSettlementRequest
     * @return
     */
    Object getPreUpgradeUsdcSettlement(PreUpgradeUsdcSettlementRequest preUpgradeUsdcSettlementRequest);

    // Account endpoints

    /**
     * Get Wallet Balance
     * Obtain wallet balance, query asset information of each currency, and account risk rate information. By default, currency information with assets or liabilities of 0 is not returned.
     * <p>
     * TIP
     * The trading of UTA inverse contracts is conducted through the CONTRACT wallet.
     * To get Funding wallet balance, please go to this endpoint
     *
     * @param walletBalanceRequest
     * @return
     */
    Object getWalletBalance(WalletBalanceRequest walletBalanceRequest);

    /**
     * Upgrade Unified Account
     * <p>
     * UPGRADE GUIDANCE
     * Check your current account status by calling this Get Account Info
     * <p>
     * if unifiedMarginStatus=1, then it is classic account, you can call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * <p>
     * if unifiedMarginStatus=2, then it is UMA, you need to call below upgrade endpoint twice. The first call, your account will be upgraded to UTA, please make sure you call this Get Account Info and unifiedMarginStatus=3, then you can start the 2nd call, if you see unifiedMarginStatus=4, then it is UTA Pro.
     * <p>
     * if unifiedMarginStatus=3, then it is UTA, you need to call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * <p>
     * IMPORTANT
     * Banned / Express path users cannot upgrade the account to Unified Account for now.
     * <p>
     * INFO
     * You can upgrade the normal acct to unified acct without closing positions now, but please note belows:
     * <p>
     * Please avoid upgrading during these period:
     * every hour	50th minute to 5th minute of next hour
     * Please ensure:
     * No open order and debt in the Spot account
     * No open order and hedge-mode USDT position or isolated margin USDT position in the Derivatives account
     * No open order in the USDC Derivatives account
     * Cannot have TPSL order either
     * When the unifiedUpgradeProcess = PROCESS, it means that the system needs asynchronous verification processing, and the upgrade result cannot be returned in real time. You can check API Get Account Info after 3-5 minutes, check whether the upgrade is successful according to the "unifiedMarginStatus" field in the return.
     * <p>
     * During the account upgrade process, the data of Rest API/Websocket stream may be inaccurate due to the fact that the account-related asset data is in the processing state. It is recommended to query and use it after the upgrade is completed.
     *
     * @return
     */
    Object upgradeAccountToUTA();

    /**
     * Get Borrow History
     * Get interest records, sorted in reverse order of creation time.
     * <p>
     * Unified account
     *
     * @param borrowHistoryRequest
     * @return
     */
    Object getAccountBorrowHistory(BorrowHistoryRequest borrowHistoryRequest);

    /**
     * Set Collateral Coin
     * You can decide whether the assets in the Unified account needs to be collateral coins.
     *
     * @param setCollateralCoinRequest
     * @return
     */
    Object setAccountCollateralCoin(SetCollateralCoinRequest setCollateralCoinRequest);

    /**
     * Get Collateral Info
     * Get the collateral information of the current unified margin account, including loan interest rate, loanable amount, collateral conversion rate, whether it can be mortgaged as margin, etc.
     *
     * @return
     */
    Object getAccountCollateralInfo(String currency);

    Object getAccountCollateralInfo();

    /**
     * Get Coin Greeks
     * Get current account Greeks information
     *
     * @param baseCoin
     * @return
     */
    Object getAccountCoinGeeks(String baseCoin);

    Object getAccountCoinGeeks();

    /**
     * Get Fee Rate
     * Get the trading fee rate.
     * <p>
     * Covers: Spot / USDT perpetual / USDC perpetual / USDC futures / Inverse perpetual / Inverse futures / Options
     * <p>
     * HTTP Request
     *
     * @param getFeeRateRequest
     * @return
     */
    Object getAccountFreeRate(GetFeeRateRequest getFeeRateRequest);

    /**
     * Get Account Info
     * Query the margin mode configuration of the account.
     *
     * @return
     */
    Object getAccountInfo();

    /**
     * Get Transaction Log
     * Query transaction logs in Unified account.
     *
     * @param getTransactionLogRequest
     * @return
     */
    Object getTransactionLog(GetTransactionLogRequest getTransactionLogRequest);

    /**
     * Set Margin Mode
     * Default is regular margin mode
     * <p>
     * INFO
     * UTA account can be switched between these 3 kinds of margin modes, which is across UID level, working for USDT Perp, USDC Perp, USDC Futures and Options (Option does not support ISOLATED_MARGIN)
     * Normal account can be switched between REGULAR_MARGIN and PORTFOLIO_MARGIN, only work for USDC Perp and Options trading.
     *
     * @param setMarginMode
     * @return
     */
    Object setAccountMarginMode(String setMarginMode);

    /**
     * Set MMP
     * INFO
     * What is MMP?
     * Market Maker Protection (MMP) is an automated mechanism designed to protect market makers (MM) against liquidity risks and over-exposure in the market. It prevents simultaneous trade executions on quotes provided by the MM within a short time span. The MM can automatically pull their quotes if the number of contracts traded for an underlying asset exceeds the configured threshold within a certain time frame. Once MMP is triggered, any pre-existing MMP orders will be automatically canceled, and new orders tagged as MMP will be rejected for a specific duration — known as the frozen period — so that MM can reassess the market and modify the quotes.
     * <p>
     * How to enable MMP
     * Send an email to Bybit (financial.inst@bybit.com) or contact your business development (BD) manager to apply for MMP. After processed, the default settings are as below table:
     * <p>
     * Parameter	Type	Comments	Default value
     * baseCoin	string	Base coin	BTC
     * window	string	Time window (millisecond)	5000
     * frozenPeriod	string	Frozen period (millisecond)	100
     * qtyLimit	string	Quantity limit	100
     * deltaLimit	string	Delta limit	100
     * Applicable
     * Effective for options only. When you place an option order, set mmp=true, which means you mark this order as a mmp order.
     *
     * @param setMMPRequest
     * @return
     */
    Object modifyAccountMMP(SetMMPRequest setMMPRequest);

    /**
     * Reset MMP
     * INFO
     * Once the mmp triggered, you can unfreeze the account by this endpoint, then qtyLimit and deltaLimit will be reset to 0.
     * If the account is not frozen, reset action can also remove previous accumulation, i.e., qtyLimit and deltaLimit will be reset to 0.
     *
     * @param baseCoin
     * @return
     */
    Object resetAccountMMP(String baseCoin);

    /**
     * Get MMP State
     *
     * @param baseCoin
     * @return
     */
    Object getAccountMMPState(String baseCoin);

    // Institution Endpoints

    /**
     * Get Product Info
     * TIP
     * This is a public endpoint, so it does not need to authenticate.
     *
     * @param productId
     * @return
     */
    Object getInsProductInfo(String productId);

    Object getInsProductInfo();

    /**
     * Get Margin Coin Info
     * TIP
     * This is a public endpoint, so it does not need to authenticate.
     *
     * @param productId
     * @return
     */
    Object getInsMarginCoinInfo(String productId);

    Object getInsMarginCoinInfo();

    /**
     * Get Loan Orders
     * Get loan orders information
     * <p>
     * TIP
     * Get the past 2 years data by default
     * Get up to the past 2 years of data
     *
     * @param institutionLoanOrdersRequest
     * @return
     */
    Object getInsLoanOrders(InstitutionLoanOrdersRequest institutionLoanOrdersRequest);

    /**
     * Get Repay Orders
     * Get repaid order information
     * <p>
     * TIP
     * Get the past 2 years data by default
     * Get up to the past 2 years of data
     *
     * @param institutionRepayOrdersRequest
     * @return
     */
    Object getInsRepayOrders(InstitutionRepayOrdersRequest institutionRepayOrdersRequest);

    /**
     * Get LTV
     *
     * @return
     */
    Object getInsLoanToValue();

    // Spot Endpoints
    // Spot Leverage Token

    /**
     * Get Leverage Token Info
     * Query leverage token information
     *
     * @param ltCoin
     * @return
     */
    Object getSpotLeverageTokenInfo(String ltCoin);

    Object getSpotLeverageTokenInfo();

    /**
     * Get Leveraged Token Market
     * Get leverage token market information
     *
     * @param ltCoin
     * @return
     */
    Object getSpotLeverageTokenMarket(String ltCoin);

    Object getSpotLeverageTokenMarket();

    /**
     * Purchase
     * Purchase levearge token
     *
     * @param spotLeverageTokenRequest
     * @return
     */
    Object purchaseSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest);

    /**
     * Redeem
     * Redeem leverage token
     *
     * @param spotLeverageTokenRequest
     * @return
     */
    Object redeemSpotLeverageToken(SpotLeverageTokenRequest spotLeverageTokenRequest);

    /**
     * Get Purchase/Redemption Records
     * Get purchase or redeem history
     *
     * @param spotLeverageOrdersRecordRequest
     * @return
     */
    Object getSpotLeverageRecords(SpotLeverageOrdersRecordRequest spotLeverageOrdersRecordRequest);

    // Spot Margin UTA

    /**
     * Get VIP Margin Data
     * This margin data is for Unified account in particular.
     *
     * @param utaMarginDataRequest
     * @return
     */
    Object getUtaVipSpotMarginTradeData(VIPMarginDataRequest utaMarginDataRequest);

    /**
     * Toggle Margin Trade
     * Turn on / off spot margin trade
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * CAUTION
     * Your account needs to activate spot margin first; i.e., you must have finished the quiz on web / app.
     * <p>
     * Request Parameters
     * Parameter	Required	Type	Comments
     * spotMarginMode	true	string	1: on, 0: off
     * Response Parameters
     * Parameter	Type	Comments
     * spotMarginMode	string	Spot margin status. 1: on, 0: off
     *
     * @param spotMarginMode
     * @return
     */
    Object setUTASpotMarginTrade(String spotMarginMode);

    /**
     * et Leverage
     * Set the user's maximum leverage in spot cross margin
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * CAUTION
     * Your account needs to activate spot margin first; i.e., you must have finished the quiz on web / app.
     * <p>
     * Request Parameters
     * Parameter	Required	Type	Comments
     * leverage	true	string	Leverage. [2, 10].
     *
     * @param leverage
     * @return
     */
    Object setUTASpotMarginTradeLeverage(String leverage);

    /**
     * Get Status And Leverage
     * Query the Spot margin status and leverage of Unified account
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * Response Parameters
     * Parameter	Type	Comments
     * spotLeverage	string	Spot margin leverage. Returns "" if the margin trade is turned off
     * spotMarginMode	string	Spot margin status. 1: on, 0: off
     *
     * @return
     */
    Object getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal

    /**
     * Get VIP Margin Data
     * This margin data is for Classic account in particular.
     * <p>
     * INFO
     * Do not need authentication
     *
     * @param normalMarginDataRequest
     * @return
     */
    Object getNormalVipSpotMarginTradeData(VIPMarginDataRequest normalMarginDataRequest);


    /**
     * Get Margin Coin Info
     * INFO
     * Do not need authentication
     *
     * @param coin
     * @return
     */
    Object getNormalSpotMarginTradeCoinInfo(String coin);

    Object getNormalSpotMarginTradeCoinInfo();

    /**
     * Get Borrowable Coin Info
     * INFO
     * Do not need authentication
     *
     * @param coin
     * @return
     */
    Object getNormalSpotMarginTradeBorrowCoinInfo(String coin);

    Object getNormalSpotMarginTradeBorrowCoinInfo();

    /**
     * Get Interest & Quota
     * Covers: Margin trade (Normal Account)
     *
     * @param coin
     * @return
     */
    Object getNormalSpotMarginTradeInterestQuota(String coin);

    /**
     * Get Loan Account Info
     * Covers: Margin trade (Normal Account)
     *
     * @return
     */
    Object getNormalSpotMarginTradeAccountInfo();

    /**
     * Toggle Margin Trade
     * Turn on / off spot margin trade
     *
     * Covers: Margin trade (Normal Account)
     *
     * @param switchStatus
     * @return
     */
    Object getNormalSpotToggleMarginTrade(int switchStatus);

    /**
     * Borrow
     * Covers: Margin trade (Normal Account)
     *
     * @param spotMarginTradeBorrowRequest
     * @return
     */
    Object loanNormalSpotMarginTrade(SpotMarginTradeBorrowRequest spotMarginTradeBorrowRequest);

    /**
     * Repay
     * Covers: Margin trade (Normal Account)
     * @param spotMarginTradeRePayRequest
     * @return
     */
    Object repayNormalSpotMarginTrade(SpotMarginTradeRePayRequest spotMarginTradeRePayRequest);

    /**
     *Get Borrow Order Detail
     * Covers: Margin trade (Normal Account)
     * @param spotMarginTradeBorrowOrdersRequest
     * @return
     */
    Object getNormalSpotMarginTradeBorrowOrders(SpotMarginTradeBorrowOrdersRequest spotMarginTradeBorrowOrdersRequest);

    /**
     * Get Repayment Order Detail
     * Covers: Margin trade (Normal Account)
     * @param spotMarginTradeRepayOrdersRequest
     * @return
     */
    Object getNormalSpotMarginTradeRepayOrders(SpotMarginTradeRepayOrdersRequest spotMarginTradeRepayOrdersRequest);

    // Broker endpoints

    /**
     * Get Broker Earning
     * INFO
     * Use exchange broker master account to query
     * The data can support up to past 6 months until T-1
     * startTime & endTime are either entered at the same time or not entered
     * @param brokerEarningRequest
     * @return
     */
    Object getBrokerEarningData(BrokerEarningRequest brokerEarningRequest);

    // C2C Endpoints

    /**
     * Get Lending Coin Info
     * Get the basic information of lending coins
     *
     * INFO
     * All v5/lending APIs need SPOT permission.
     * @param coin
     * @return
     */
    Object getC2CLendingCoinInfo(String coin);
    Object getC2CLendingCoinInfo();

    /**
     * Deposit Funds
     * Lending funds to Bybit asset pool
     *
     * INFO
     * normal & UMA account: deduct funds from Spot wallet
     * UTA account: deduct funds from Unified wallet
     * @param despoitFundRequest
     * @return
     */
    Object C2cLendingDepositFunds(ClientLendingFundsRequest despoitFundRequest);

    /**
     * Redeem Funds
     * Withdraw funds from the Bybit asset pool.
     *
     * TIP
     * There will be two redemption records: one for the redeemed quantity, and the other one is for the total interest occurred.
     * @param despoitFundRequest
     * @return
     */
    Object C2cLendingRedeemFunds(ClientLendingFundsRequest despoitFundRequest);

    /**
     * Get Order Records
     * Get lending or redeem history
     *
     * @param c2cOrdersRecordsRequest
     * @return
     */
    Object getC2cOrdersRecords(ClientLendingOrderRecordsRequest c2cOrdersRecordsRequest);

    /**
     * Get Lending Account Info
     * HTTP Request
     * GET /v5/lending/account
     *
     * Request Parameters
     * Parameter	Required	Type	Comments
     * coin	true	string	Coin name
     * Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin name
     * principalInterest	string	User Redeemable interest
     * principalQty	string	Leftover quantity you can redeem for today (measured from 0 - 24 UTC)
     * principalTotal	string	Total amount redeemable by user
     * quantity	string	Current deposit quantity
     * @param coin
     * @return
     */
    Object getC2CLendingAccountInfo(String coin);

    // Asset Endpoints

    /**
     * Get Coin Exchange Records
     * Query the coin exchange records.
     *
     * INFO
     * This endpoint currently is not available to get data after 12 Mar 2023. We will make it fully available later.
     *
     * CAUTION
     * You may have a long delay of this endpoint.
     * @param coinExchangeRecordsRequest
     * @return
     */
    Object getAssetCoinExchangeRecords(CoinExchangeRecordsRequest coinExchangeRecordsRequest);

    /**
     * Get Delivery Record
     * Query delivery records of USDC futures and Options, sorted by deliveryTime in descending order
     *
     * Unified account covers: USDC futures / Option
     * @param deliveryRecordsRequest
     * @return
     */
    Object getAssetDeliveryRecords(AssetDeliveryRecordsRequest deliveryRecordsRequest);

    /**
     * Get USDC Session Settlement
     * Query session settlement records of USDC perpetual and futures
     *
     * Unified account covers: USDC perpetual / USDC futures
     * @param usdcSettlementRequest
     * @return
     */
    Object getAssetUSDCSettlementRecords(USDCSessionSettlementRequest usdcSettlementRequest);

    /**
     * Get Asset Info
     * Query asset information
     *
     * INFO
     * For now, it can query SPOT only.
     * @param assetInfoRequest
     * @return
     */
    Object getAssetInfo(AssetInfoRequest assetInfoRequest);

    /**
     * Get All Coins Balance
     * You could get all coin balance of all account types under the master account, and sub account.
     *
     * IMPORTANT
     * It is not allowed to get master account coin balance via sub account api key.
     * @param allCoinsBalanceRequest
     * @return
     */
    Object getAssetAllCoinsBalance(AssetCoinsBalanceRequest allCoinsBalanceRequest);

    /**
     * Get Transferable Coin
     * Query the transferable coin list between each account type
     * @param fromAccountType
     * @param toAccountType
     * @return
     */
    Object getAssetTransferableCoins(AccountType fromAccountType, AccountType toAccountType);

    /**
     * Get Single Coin Balance
     * Query the balance of a specific coin in a specific account type. Supports querying sub UID's balance. Also, you can check the transferable amount from master to sub account, sub to master account or sub to sub account, especially for user who has INS loan.
     *
     * INFO
     * Sub account cannot query master account balance
     * Sub account can only check its own balance
     * Master account can check its own and its sub uids balance
     * @param singleCoinBalanceRequest
     * @return
     */
    Object getAssetSingleCoinBalance(AssetSingleCoinBalanceRequest singleCoinBalanceRequest);

    /**
     * Create Internal Transfer
     * Create the internal transfer between different account types under the same UID.
     *
     * TIP
     * Each account type has its own acceptable coins, e.g, you cannot transfer USDC from SPOT to CONTRACT. Please refer to transferable coin list API to find out more.
     *
     * HTTP Request
     * POST /v5/asset/transfer/inter-transfer
     * @param assetInternalTransferRequest
     * @return
     */
    Object createAssetInternalTransfer(AssetInternalTransferRequest assetInternalTransferRequest);

    /**
     * Get Sub UID
     * Query the sub UIDs under a main UID
     *
     * CAUTION
     * Can query by the master UID's api key only
     * @return
     */
    Object getAssetTransferSubUidList();

    /**
     * Create Universal Transfer
     * Transfer between sub-sub or main-sub.
     *
     * CAUTION
     * Can use master or sub acct api key to request
     * To use sub acct api key, it must have "SubMemberTransferList" permission
     * When use sub acct api key, it can only transfer to main account
     * If you encounter errorCode: 131228 and msg: your balance is not enough, please go to Get Single Coin Balance to check transfer safe amount.
     * You can not transfer between the same UID
     * @param assetUniversalTransferRequest
     * @return
     */
    Object createAssetUniversalTransfer(AssetUniversalTransferRequest assetUniversalTransferRequest);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     * @param internalTransferRequest
     * @return
     */
    Object getAssetInternalTransferRecords(AssetTransferRecordsRequest internalTransferRequest);

    /**
     * Get Universal Transfer Records
     * Query universal transfer records
     *
     * TIP
     * Main acct api key or Sub acct api key are both supported
     * Main acct api key needs "SubMemberTransfer" permission
     * Sub acct api key needs "SubMemberTransferList" permission
     * @param universalTransferRequest
     * @return
     */
    Object getAssetUniversalTransferRecords(AssetTransferRecordsRequest universalTransferRequest);

    /**
     * Get Allowed Deposit Coin Info
     * Query allowed deposit coin information. To find out paired chain of coin, please refer coin info api.
     *
     * TIP
     * This is an endpoint that does not need authentication
     * @param allowedDepositCoinRequest
     * @return
     */
    Object getAssetAllowedDepositCoinInfo(AssetAllowedDepositCoinRequest allowedDepositCoinRequest);

    /**
     * HTTP Request
     * POST /v5/asset/deposit/deposit-to-account
     *
     * Request Parameters
     * Parameter	Required	Type	Comments
     * accountType	true	string	Account type
     * UNIFIED
     * SPOT
     * OPTION
     * CONTRACT
     * FUND
     * Response Parameters
     * Parameter	Type	Comments
     * status	integer	Request result:
     * 1: SUCCESS
     * 0: FAIL
     * @param accountType
     * @return
     */
    Object setAssetDepositAccount(AccountType accountType);

    /**
     * Get Deposit Records (on-chain)
     * Query deposit records.
     *
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can use main or sub UID api key to query deposit records respectively.
     * @param assetDepositRecordsRequest
     * @return
     */
    Object getAssetDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest);

    /**
     * Get Sub Deposit Records (on-chain)
     * Query subaccount's deposit records by main UID's API key.
     *
     * TIP
     * endTime - startTime should be less than 30 days. Queries for the last 30 days worth of records by default.
     * @param assetDepositRecordsRequest
     * @return
     */
    Object getAssetSubMembersDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest);

    /**
     * Get Internal Deposit Records (off-chain)
     * Query deposit records within the Bybit platform. These transactions are not on the blockchain.
     *
     * RULES
     * The maximum difference between the start time and the end time is 30 days.
     * Support to get deposit records by Master or Sub Member Api Key
     * @param assetDepositRecordsRequest
     * @return
     */
    Object getAssetInternalDepositRecords(AssetDepositRecordsRequest assetDepositRecordsRequest);

    Object getAssetMasterDepositAddress(AssetDepositRequest masterDepositRequest);

    Object getAssetSubMemberDepositAddress(AssetDepositRequest subDepositRequest);

    Object getAssetCoinInfo();
    Object getAssetCoinInfo(String coin);

    Object getAssetWithdrawalAmount(String coin);

    Object getAssetWithdrawalRecords(AssetWithdrawRecordsRequest assetWithdrawRecordsRequest);

    Object cancelAssetWithdraw(String withdrawId);

    Object createAssetWithdraw(AssetWithdrawRequest assetWithdrawRequest);
}
