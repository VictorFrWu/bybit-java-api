package com.bybit.api.client.service;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.trade.response.OrderResponse;
import com.bybit.api.client.domain.trade.response.OrderResult;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Bybit's REST API URL mappings and endpoint security configuration.
 */
public interface BybitApiService {
    // Trade
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/history")
    Call<GenericResponse<OrderResult>> getHistoryOrderResult(@Query("category") String category,
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
    Call<GenericResponse<OrderResponse>> newOrder(@Query("category") ProductType category,
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
    Call<GenericResponse<OrderResponse>> cancelOrder(@Query("category") ProductType category,
                                                     @Query("symbol") String symbol,
                                                     @Query("orderId") String orderId,
                                                     @Query("orderLinkId") String orderLinkId,
                                                     @Query("orderFilter") String orderFilter);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/amend")
    Call<GenericResponse<OrderResponse>> amendOrder(@Query("category") ProductType category,
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

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/realtime")
    Call<GenericResponse<OrderResult>> getOpenOrders(@Query("category") ProductType category,
                                                     @Query("symbol") String symbol,
                                                     @Query("baseCoin") String baseCoin,
                                                     @Query("settleCoin") String settleCoin,
                                                     @Query("orderId") String orderId,
                                                     @Query("orderLinkId") String orderLinkId,
                                                     @Query("openOnly") Integer openOnly,
                                                     @Query("orderFilter") String orderFilter,
                                                     @Query("limit") Integer limit,
                                                     @Query("cursor") String cursor);


    // Market data endpoints
    @GET("/v5/market/kline")
    Call<GenericResponse<MarketKlineResult>> getMarketLinesData(@Query("category") String category, @Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);
 }
