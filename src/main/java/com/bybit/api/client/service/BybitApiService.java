package com.bybit.api.client.service;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.user.request.ApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.SubUserRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Bybit's REST API URL mappings and endpoint security configuration.
 */
public interface BybitApiService {
    // Market data endpoints
    /*
     * to do : insurance ; risk limit and delivery price
     * */
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

}
