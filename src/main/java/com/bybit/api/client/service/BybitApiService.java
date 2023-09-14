package com.bybit.api.client.service;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.account.request.SetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.SetMMPRequest;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.preupgrade.*;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeRePayRequest;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.user.request.ApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Bybit's REST API URL mappings and endpoint security configuration.
 */
public interface BybitApiService {
    // Market data endpoints
    @GET("/v5/market/kline")
    Call<Object> getMarketLinesData(@Query("category") String category, @Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                    @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/v5/market/mark-price-kline")
    Call<Object> getMarketPriceLinesData(@Query("category") String category, @Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                         @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/v5/market/index-price-kline")
    Call<Object> getIndexPriceLinesData(@Query("category") String category, @Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                        @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/market/time")
    Call<Object> getServerTime();

    @GET("/v5/market/premium-index-price-kline")
    Call<Object> getPremiumIndexPriceLinesData(@Query("category") String category, @Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                               @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/v5/market/instruments-info")
    Call<Object> getInstrumentsInfo(@Query("category") String category, @Query("symbol") String symbol, @Query("status") String status, @Query("baseCoin") String baseCoin,
                                    @Query("limit") Integer limit, @Query("cursor") String cursor);

    @GET("/v5/market/orderbook")
    Call<Object> getMarketOrderbook(@Query("category") String category, @Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/v5/market/orderbook")
    Call<Object> getMarketOrderbook(@Query("category") String category, @Query("symbol") String symbol);

    @GET("/v5/market/tickers")
    Call<Object> getMarketTickers(@Query("category") String category, @Query("symbol") String symbol);

    @GET("/v5/market/tickers")
    Call<Object> getMarketTickers(@Query("category") String category, @Query("symbol") String symbol, @Query("baseCoin") String baseCoin, @Query("expDate") String expDate);

    @GET("/v5/market/funding/history")
    Call<Object> getFundingHistory(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit);

    @GET("/v5/market/recent-trade")
    Call<Object> getRecentTradeData(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("baseCoin") String baseCoin,
            @Query("optionType") String optionType,
            @Query("limit") Integer limit);

    @GET("/v5/market/kline")
    Call<Object> getOpenInterest(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("intervalTime") String intervalTime,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    @GET("/v5/market/historical-volatility")
    Call<Object> getHistoricalVolatility(
            @Query("category") String category,
            @Query("baseCoin") String baseCoin,
            @Query("period") Integer period,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime);

    @GET("/v5/market/insurance")
    Call<Object> getInsurance(@Query("coin") String coin);

    @GET("/v5/market/insurance")
    Call<Object> getInsurance();

    @GET("/v5/market/risk-limit")
    Call<Object> getRiskLimit(@Query("category") String category);

    @GET("/v5/market/risk-limit")
    Call<Object> getRiskLimit(@Query("category") String category,
                              @Query("symbol") String symbol);

    @GET("/v5/market/delivery-price")
    Call<Object> getDeliveryPrice(@Query("category") String category,
                                  @Query("symbol") String symbol,
                                  @Query("symbol") String baseCoin,
                                  @Query("symbol") Integer limit,
                                  @Query("symbol") String cursor);

    // Trade
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


    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/create")
    Call<Object> newOrder(@Query("category") String category,
                          @Query("symbol") String symbol,
                          @Query("isLeverage") Integer isLeverage,
                          @Query("side") String side,
                          @Query("orderType") String orderType,
                          @Query("qty") String qty,
                          @Query("price") String price,
                          @Query("triggerDirection") Integer triggerDirection,
                          @Query("orderFilter") String orderFilter,
                          @Query("triggerPrice") String triggerPrice,
                          @Query("triggerBy") TriggerBy triggerBy,
                          @Query("orderIv") String orderIv,
                          @Query("timeInForce") TimeInForce timeInForce,
                          @Query("positionIdx") PositionIdx positionIdx,
                          @Query("orderLinkId") String orderLinkId,
                          @Query("takeProfit") String takeProfit,
                          @Query("stopLoss") String stopLoss,
                          @Query("tpTriggerBy") TriggerBy tpTriggerBy,
                          @Query("slTriggerBy") TriggerBy slTriggerBy,
                          @Query("reduceOnly") Boolean reduceOnly,
                          @Query("closeOnTrigger") Boolean closeOnTrigger,
                          @Query("smpType") SmpType smpType,
                          @Query("mmp") Boolean mmp,
                          @Query("tpslMode") String tpslMode,
                          @Query("tpLimitPrice") String tpLimitPrice,
                          @Query("slLimitPrice") String slLimitPrice,
                          @Query("tpOrderType") String tpOrderType,
                          @Query("slOrderType") String slOrderType);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel")
    Call<Object> cancelOrder(@Query("category") String category,
                             @Query("symbol") String symbol,
                             @Query("orderId") String orderId,
                             @Query("orderLinkId") String orderLinkId,
                             @Query("orderFilter") String orderFilter);

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


    // User
    /*
    to do : modify & delete master and sub api key !! need to investigate
    * */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/query-api")
    Call<Object> getCurrentAPIKeyInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/query-sub-members")
    Call<Object> getSubUIDList();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/get-member-type")
    Call<Object> getUIDWalletType(@Query("memberIds") String memberIds);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/get-member-type")
    Call<Object> getUIDWalletType();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/user/aff-customer-info")
    Call<Object> getAffiliateUserInfo(@Query("iod") String uid);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/create-sub-member")
    Call<Object> createSubMember(@Query("username") String username,
                                 @Query("password") String password,
                                 @Query("memberType") Integer memberType,
                                 @Query("switch") Integer switchOption,
                                 @Query("isUta") boolean isUta,
                                 @Query("note") String note);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/create-sub-api")
    Call<Object> createSubAPI(
            @Body ApiKeyRequest apiKeyRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/frozen-sub-member")
    Call<Object> freezeSubMember(
            @Body FreezeSubUIDRquest freezeSubUIDRquest);

    // Position Data endpoints
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/position/list")
    Call<Object> getPositionInfo(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("baseCoin") String baseCoin,
                                 @Query("settleCoin") String settleCoin,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-leverage")
    Call<Object> setPositionLeverage(
            @Body SetLeverageRequest setLeverageRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/switch-isolated")
    Call<Object> swithMarginRequest(
            @Body SwitchMarginRequest switchMarginRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/switch-mode")
    Call<Object> switchPositionMode(
            @Body SwitchPositionModeRequest switchPositionModeRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-tpsl-mode")
    Call<Object> setTpslMode(
            @Body SetTpSlModeRequest setTpSlModeRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-risk-limit")
    Call<Object> setRiskLimit(
            @Body SetRiskLimitRequest setRiskLimitRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/trading-stop")
    Call<Object> setTradingStop(
            @Body TradingStopRequest tradingStopRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-auto-add-margin")
    Call<Object> setAutoAddMargin(
            @Body SetAutoAddMarginRequest setAutoAddMarginRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/add-margin")
    Call<Object> modifyPositionMargin(
            @Body ModifyMarginRequest modifyMarginRequest);

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

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/position/closed-pnl")
    Call<Object> getClosePnlList(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("startTime") Long startTime,
                                 @Query("endTime") Long endTime,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    // Pre upgrade data endpoints
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/position/closed-pnl")
    Call<Object> getPreUpgradeClosePnl(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("startTime") Long startTime,
                                       @Query("endTime") Long endTime,
                                       @Query("limit") Integer limit,
                                       @Query("cursor") String cursor);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/asset/delivery-record")
    Call<Object> getPreUpgradeOptionDelivery(@Query("category") String category,
                                             @Query("symbol") String symbol,
                                             @Query("expDate") String expDate,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

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

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/account/transaction-log")
    Call<Object> getPreUpgradeTransaction(@Query("category") String category,
                                          @Query("baseCoin") String baseCoin,
                                          @Query("type") String type,
                                          @Query("startTime") Long startTime,
                                          @Query("endTime") Long endTime,
                                          @Query("limit") Integer limit,
                                          @Query("cursor") String cursor);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/pre-upgrade/asset/settlement-record")
    Call<Object> getPreUpgradeUsdcSettlement(@Query("category") String category,
                                             @Query("symbol") String symbol,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    // Account Data endpoints
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/wallet-balance")
    Call<Object> getWalletBalance(@Query("accountType") String accountType,
                                  @Query("coin") String coin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/upgrade-to-uta")
    Call<Object> upgradeAccountToUTA();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/borrow-history")
    Call<Object> getAccountBorrowHistory(@Query("currency") String currency,
                                         @Query("startTime") Long startTime,
                                         @Query("endTime") Long endTime,
                                         @Query("limit") Integer limit,
                                         @Query("cursor") String cursor);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-collateral-switch")
    Call<Object> setAccountCollateralCoin(@Body SetCollateralCoinRequest setCollateralCoinRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/collateral-info")
    Call<Object> getAccountCollateralInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/collateral-info")
    Call<Object> getAccountCollateralInfo(@Query("currency") String currency);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/coin-greeks")
    Call<Object> getAccountCoinGeeks();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/coin-greeks")
    Call<Object> getAccountCoinGeeks(@Query("baseCoin") String baseCoin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/fee-rate")
    Call<Object> getAccountFreeRate(@Query("category") String category,
                                    @Query("symbol") String symbol,
                                    @Query("baseCoin") String baseCoin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/info")
    Call<Object> getAccountInfo();

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

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-margin-mode")
    Call<Object> setAccountMarginMode(@Query("setMarginMode") String setMarginMode); // ISOLATED_MARGIN, REGULAR_MARGIN(i.e. Cross margin), PORTFOLIO_MARGIN

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/mmp-modify")
    Call<Object> modifyAccountMMP(@Body SetMMPRequest setMMPRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/mmp-reset")
    Call<Object> resetAccountMMP(@Query("baseCoin") String baseCoin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/account/mmp-state")
    Call<Object> getAccountMMPState(@Query("baseCoin") String baseCoin);

    // Institution Endpoints
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/product-infos")
    Call<Object> getInsProductInfo(@Query("productId") String productId);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/product-infos")
    Call<Object> getInsProductInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/ensure-tokens-convert")
    Call<Object> getInsMarginCoinInfo(@Query("productId") String productId);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/ensure-tokens-convert")
    Call<Object> getInsMarginCoinInfo();

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/loan-order")
    Call<Object> getInsLoanOrders(@Query("productId") String productId,
                                  @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime,
                                  @Query("limit") Integer limit);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/ins-loan/repaid-history")
    Call<Object> getInsRepayOrders(@Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime,
                                   @Query("limit") Integer limit);

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
}
