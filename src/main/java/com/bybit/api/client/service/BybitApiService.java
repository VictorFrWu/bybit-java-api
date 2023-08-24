package com.bybit.api.client.service;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.trade.OrderResult;
import com.bybit.api.client.domain.trade.OrderStatus;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

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


    // Market data endpoints
    @GET("/v5/market/kline")
    Call<GenericResponse<MarketKlineResult>> getMarketLinesData(@Query("category") String category, @Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);
}
