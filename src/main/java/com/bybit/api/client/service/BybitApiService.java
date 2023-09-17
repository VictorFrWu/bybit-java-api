package com.bybit.api.client.service;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.account.request.SetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.SetMMPRequest;
import com.bybit.api.client.domain.asset.request.AssetInternalTransferRequest;
import com.bybit.api.client.domain.asset.request.AssetUniversalTransferRequest;
import com.bybit.api.client.domain.asset.request.AssetWithdrawRequest;
import com.bybit.api.client.domain.c2c.ClientLendingFundsRequest;
import com.bybit.api.client.domain.position.request.*;
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

    // Asset Endpoints

    /**
     * Get Coin Exchange Records
     * Query the coin exchange records.
     * <p>
     * INFO
     * This endpoint currently is not available to get data after 12 Mar 2023. We will make it fully available later.
     * <p>
     * CAUTION
     * You may have a long delay of this endpoint.
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/exchange">...</a>
     *
     * @param fromCoin
     * @param toCoin
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * Unified account covers: USDC futures / Option
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/delivery">...</a>
     *
     * @param category
     * @param symbol
     * @param expDate
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * Unified account covers: USDC perpetual / USDC futures
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/settle">...</a>">...</a>
     *
     * @param category
     * @param symbol
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * INFO
     * For now, it can query SPOT only.
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/asset-info">...</a>
     *
     * @param accountType
     * @param coin
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-asset-info")
    Call<Object> getAssetInfo(@Query("accountType") String accountType,
                              @Query("coin") String coin);


    /**
     * Get All Coins Balance
     * You could get all coin balance of all account types under the master account, and sub account.
     * <p>
     * IMPORTANT
     * It is not allowed to get master account coin balance via sub account api key.
     * <p>
     * <a href="  * https://bybit-exchange.github.io/docs/v5/asset/all-bal">...</a>ance
     *
     * @param accountType
     * @param memberId
     * @param coin
     * @param withBonus
     * @return
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
     * <p>
     * INFO
     * Sub account cannot query master account balance
     * Sub account can only check its own balance
     * Master account can check its own and its sub uids balance
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/account-coin-balance">...</a>
     *
     * @param accountType
     * @param toAccountType
     * @param memberId
     * @param toMemberId
     * @param coin
     * @param withBonus
     * @param withTransferSafeAmount
     * @param withLtvTransferSafeAmount
     * @return
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
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/transferable-coin">...</a>
     *
     * @param fromAccountType
     * @param toAccountType
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-transfer-coin-list")
    Call<Object> getAssetTransferableCoins(@Query("fromAccountType") String fromAccountType, @Query("toAccountType") String toAccountType);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/inter-transfer-list">...</a>
     * HTTP Request
     *
     * @param assetInternalTransferRequest
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/transfer/inter-transfer")
    Call<Object> createAssetInternalTransfer(@Body AssetInternalTransferRequest assetInternalTransferRequest);

    /**
     * Get Sub UID
     * Query the sub UIDs under a main UID
     * <p>
     * CAUTION
     * Can query by the master UID's api key only
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/sub-uid-list">...</a>
     *
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/transfer/query-sub-member-list")
    Call<Object> getAssetTransferSubUidList();

    /**
     * Create Universal Transfer
     * Transfer between sub-sub or main-sub.
     * <p>
     * CAUTION
     * Can use master or sub acct api key to request
     * To use sub acct api key, it must have "SubMemberTransferList" permission
     * When use sub acct api key, it can only transfer to main account
     * If you encounter errorCode: 131228 and msg: your balance is not enough, please go to Get Single Coin Balance to check transfer safe amount.
     * You can not transfer between the same UID
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/unitransfer">...</a>
     *
     * @param assetUniversalTransferRequest
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/transfer/universal-transfer")
    Call<Object> createAssetUniversalTransfer(@Body AssetUniversalTransferRequest assetUniversalTransferRequest);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/inter-transfer-list">...</a>
     *
     * @param transferId
     * @param coin
     * @param status
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * TIP
     * Main acct api key or Sub acct api key are both supported
     * Main acct api key needs "SubMemberTransfer" permission
     * Sub acct api key needs "SubMemberTransferList" permission
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/unitransfer-list">...</a>
     *
     * @param transferId
     * @param coin
     * @param status
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * TIP
     * This is an endpoint that does not need authentication
     * <p>
     * <a href="  * https://bybit-exchange.github.io/docs/v5/asset/deposit-coin-">...</a>
     *
     * @param coin
     * @param chain
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * INFO
     * Your funds will be deposited into FUND wallet by default. You can set the wallet for auto-transfer after deposit by this API.
     * Only main UID can access.
     * TIP
     * Unified trading account has FUND, UNIFIED, CONTRACT(for inverse derivatives)
     * Unified margin account has FUND, UNIFIED, CONTRACT(for inverse derivatives), SPOT
     * Normal account has FUND, OPTION(USDC account), CONTRACT(for inverse derivatives and derivatives), SPOT
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/set-deposit-acct">...</a>
     *
     * @param accountType
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/deposit/deposit-to-account")
    Call<Object> setAssetDepositAccount(@Query("accountType") String accountType);

    /**
     * Get Deposit Records (on-chain)
     * Query deposit records.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can use main or sub UID api key to query deposit records respectively.
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/deposit-record">...</a>
     *
     * @param coin
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Queries for the last 30 days worth of records by default.
     * <p> <a href="
     ">* https://bybit-exchange.github.io/docs/v5/asset/sub-deposit-record</a>
     * @param subMemberId
     * @param coin
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
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
     * <p>
     * RULES
     * The maximum difference between the start time and the end time is 30 days.
     * Support to get deposit records by Master or Sub Member Api Key
     * <p>
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/internal-deposit-record">...</a>
     * @param coin
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
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
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/master-deposit-addr">...</a>
     * @param coin
     * @param chainType
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-address")
    Call<Object> getAssetMasterDepositAddress(@Query("coin") String coin, @Query("chainType") String chainType);


    /**
     * Get Sub Deposit Address
     * Query the deposit address information of SUB account.
     *
     * CAUTION
     * Can use master UID's api key only
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/sub-deposit-addr">...</a>
     * @param coin
     * @param chainType
     * @param subMemberId
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/deposit/query-sub-member-address")
    Call<Object> getAssetSubMemberDepositAddress(@Query("coin") String coin,
                                                 @Query("chainType") String chainType,
                                                 @Query("subMemberId") String subMemberId);

    /**
     * Get Coin Info
     * Query coin information, including chain information, withdraw and deposit status.
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/coin-info">...</a>
     * @param coin
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/coin/query-info")
    Call<Object> getAssetCoinInfo(@Query("coin") String coin);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/coin/query-info")
    Call<Object> getAssetCoinInfo();

    /**
     * Get Withdrawable Amount
     * INFO
     * How can partial funds be subject to delayed withdrawal requests?
     *
     * On-chain deposit: If the number of on-chain confirmations has not reached a risk-controlled level, a portion of the funds will be frozen for a period of time until they are unfrozen.
     * Buying crypto: If there is a risk, the funds will be frozen for a certain period of time and cannot be withdrawn.
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/delay-amount">...</a>
     * @param coin
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/v5/asset/withdraw/withdrawable-amount")
    Call<Object> getAssetWithdrawalAmount(@Query("coin") String coin);


    /**
     * Get Withdrawal Records
     * Query withdrawal records.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can query by the master UID's api key only
     * <a href="https://bybit-exchange.github.io/docs/v5/asset/withdraw-record">...</a>
     * @param withdrawID
     * @param coin
     * @param withdrawType
     * @param startTime
     * @param endTime
     * @param limit
     * @param cursor
     * @return
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
     *
     * CAUTION
     * Can query by the master UID's api key only
     * @param withdrawId
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/withdraw/cancel")
    Call<Object> cancelAssetWithdraw(@Body String withdrawId);

    /**
     * Withdraw
     * Withdraw assets from your Bybit account. You can make an off-chain transfer if the target wallet address is from Bybit. This means that no blockchain fee will be charged.
     *
     * DANGER
     * UTA does not have SPOT account
     * How do I know if my account is a UTA account? Call this endpoint, and if uta=1, then it is a UTA account.
     * CAUTION
     * Make sure you have whitelisted your wallet address here
     * Can query by the master UID's api key only
     * FORMULA
     * feeType=0:
     *
     * withdrawPercentageFee != 0: handlingFee = inputAmount / (1 - withdrawPercentageFee) * withdrawPercentageFee + withdrawFee
     * withdrawPercentageFee = 0: handlingFee = withdrawFee
     * feeType=1:
     *
     * withdrawPercentageFee != 0: handlingFee = withdrawFee + (inputAmount - withdrawFee) * withdrawPercentageFee
     * withdrawPercentageFee = 0: handlingFee = withdrawFee
     * @param assetWithdrawRequest
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/withdraw/create")
    Call<Object> createAssetWithdraw(@Body AssetWithdrawRequest assetWithdrawRequest);
}
