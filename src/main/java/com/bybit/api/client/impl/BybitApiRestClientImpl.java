package com.bybit.api.client.impl;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.MarketKlineResult;
import com.bybit.api.client.domain.market.MarketKlineInterval;
import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.trade.requests.*;
import com.bybit.api.client.domain.trade.response.OrderResponse;
import com.bybit.api.client.domain.trade.response.OrderResult;
import com.bybit.api.client.service.BybitApiService;
import retrofit2.Call;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiRestClientImpl implements BybitApiRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiRestClientImpl(String apiKey, String secret) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret);
    }

    // Market Data endpoints
    @Override
    public Object getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(
                bybitApiService.getMarketLinesData(category.getProductTypeId(), symbol, interval.getIntervalId(), limit, startTime, endTime));
    }

    @Override
    public Object  getMarketLinesData(ProductType category, String symbol, MarketKlineInterval interval) {
        return getMarketLinesData(category, symbol, interval, null, null, null);
    }

    @Override
    public Object getHistoryOrderResult(OrderHistoryRequest orderHistoryRequest) {
        return executeSync(bybitApiService.getHistoryOrderResult(
                orderHistoryRequest.getCategory().getProductTypeId(),
                orderHistoryRequest.getSymbol(),
                orderHistoryRequest.getBaseCoin(),
                orderHistoryRequest.getSettleCoin(),
                orderHistoryRequest.getOrderId(),
                orderHistoryRequest.getOrderLinkId(),
                orderHistoryRequest.getOrderFilter(),
                orderHistoryRequest.getOrderStatus(),
                orderHistoryRequest.getStartTime(),
                orderHistoryRequest.getEndTime(),
                orderHistoryRequest.getLimit(),
                orderHistoryRequest.getCursor()));
    }

    @Override
    public Object newOrder(NewOrderRequest order) {
        return executeSync(bybitApiService.newOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getIsLeverage(),
                order.getSide(),
                order.getOrderType(),
                order.getQty(),
                order.getPrice(),
                order.getTriggerDirection(),
                order.getOrderFilter(),
                order.getTriggerPrice(),
                order.getTriggerBy(),
                order.getOrderIv(),
                order.getTimeInForce(),
                order.getPositionIdx(),
                order.getOrderLinkId(),
                order.getTakeProfit(),
                order.getStopLoss(),
                order.getTpTriggerBy(),
                order.getSlTriggerBy(),
                order.getReduceOnly(),
                order.getCloseOnTrigger(),
                order.getSmpType(),
                order.getMmp(),
                order.getTpslMode(),
                order.getTpLimitPrice(),
                order.getSlLimitPrice(),
                order.getTpOrderType(),
                order.getSlOrderType()
        ));
    }

    @Override
    public Object amendOrder(AmendOrderRequest order) {
        return executeSync(bybitApiService.amendOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderIv(),
                order.getTriggerPrice(),
                order.getQty(),
                order.getPrice(),
                order.getTakeProfit(),
                order.getStopLoss(),
                order.getTpTriggerBy(),
                order.getSlTriggerBy(),
                order.getTriggerBy(),
                order.getTpLimitPrice(),
                order.getSlLimitPrice()
        ));
    }

    @Override
    public Object cancelOrder(CancelOrderRequest order) {
        return executeSync(bybitApiService.cancelOrder(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOrderFilter()
        ));
    }

    @Override
    public Object getOpenOrders(OpenOrderRequest order) {
        return executeSync(bybitApiService.getOpenOrders(
                order.getCategory().getProductTypeId(),
                order.getSymbol(),
                order.getBaseCoin(),
                order.getSettleCoin(),
                order.getOrderId(),
                order.getOrderLinkId(),
                order.getOpenOnly(),
                order.getOrderFilter(),
                order.getLimit(),
                order.getCursor()
        ));
    }
}
