package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiMarketRestClient;
import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.market.request.MarketDataRequest;
import lombok.Getter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

@Getter
public class BybitApiMarketRestClientImpl implements BybitApiMarketRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiMarketRestClientImpl() {
        bybitApiService = createService(BybitApiService.class);
    }

    // Market Data endpoints
    @Override
    public Object getAnnouncementInfo(AnnouncementInfoRequest announcementInfoRequest) {
        return executeSync(bybitApiService.getAnouncementInfo(
                announcementInfoRequest.getLocale() == null ? null : announcementInfoRequest.getLocale().getLanguageSymbol(),
                announcementInfoRequest.getType() == null ? null : announcementInfoRequest.getType().getAnnouncementType(),
                announcementInfoRequest.getTag() == null ? null : announcementInfoRequest.getTag().getEnglishTranslation(),
                announcementInfoRequest.getPage(),
                announcementInfoRequest.getLimit()
        ));
    }

    @Override
    public Object getServerTime() {
        return executeSync(
                bybitApiService.getServerTime());
    }

    @Override
    public Object getMarketLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getMarketLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getMarketPriceLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getMarketPriceLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getIndexPriceLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getIndexPriceLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest) {
        return executeSync(
                bybitApiService.getPremiumIndexPriceLinesData(
                        marketKlineRequest.getCategory().getProductTypeId(),
                        marketKlineRequest.getSymbol(),
                        marketKlineRequest.getMarketInterval() == null ? null : marketKlineRequest.getMarketInterval().getIntervalId(),
                        marketKlineRequest.getStart(),
                        marketKlineRequest.getEnd(),
                        marketKlineRequest.getLimit()
                )
        );
    }

    @Override
    public Object getInstrumentsInfo(MarketDataRequest instrumentInfoRequest) {
        return executeSync(bybitApiService.getInstrumentsInfo(
                instrumentInfoRequest.getCategory().getProductTypeId(),
                instrumentInfoRequest.getSymbol(),
                instrumentInfoRequest.getInstrumentStatus() == null ? null : instrumentInfoRequest.getInstrumentStatus().getStatus(),
                instrumentInfoRequest.getBaseCoin(),
                instrumentInfoRequest.getLimit(),
                instrumentInfoRequest.getCursor()
        ));
    }

    @Override
    public Object getMarketOrderBook(MarketDataRequest marketOrderBookRequest) {
        return executeSync(bybitApiService.getMarketOrderBook(
                marketOrderBookRequest.getCategory().getProductTypeId(),
                marketOrderBookRequest.getSymbol(),
                marketOrderBookRequest.getLimit()
        ));
    }

    @Override
    public Object getMarketTickers(MarketDataRequest marketDataTickerRequest) {
        return executeSync(bybitApiService.getMarketTickers(
                marketDataTickerRequest.getCategory().getProductTypeId(),
                marketDataTickerRequest.getSymbol(),
                marketDataTickerRequest.getBaseCoin(),
                marketDataTickerRequest.getExpDate()
        ));
    }

    @Override
    public Object getFundingHistory(MarketDataRequest fundingHistoryRequest) {
        return executeSync(bybitApiService.getFundingHistory(
                fundingHistoryRequest.getCategory().getProductTypeId(),
                fundingHistoryRequest.getSymbol(),
                fundingHistoryRequest.getStartTime(),
                fundingHistoryRequest.getEndTime(),
                fundingHistoryRequest.getLimit()
        ));
    }

    @Override
    public Object getRecentTradeData(MarketDataRequest recentTradeRequest) {
        return executeSync(bybitApiService.getRecentTradeData(
                recentTradeRequest.getCategory().getProductTypeId(),
                recentTradeRequest.getBaseCoin(),
                recentTradeRequest.getOptionType() == null ? null : recentTradeRequest.getOptionType().getOpType(),
                recentTradeRequest.getSymbol(),
                recentTradeRequest.getLimit()
        ));
    }

    @Override
    public Object getOpenInterest(MarketDataRequest openInterestRequest) {
        return executeSync(bybitApiService.getOpenInterest(
                openInterestRequest.getCategory().getProductTypeId(),
                openInterestRequest.getSymbol(),
                openInterestRequest.getMarketIntervalTime() == null ? null : openInterestRequest.getMarketIntervalTime().getInterval(),
                openInterestRequest.getStartTime(),
                openInterestRequest.getEndTime(),
                openInterestRequest.getLimit(),
                openInterestRequest.getCursor()
        ));
    }

    @Override
    public Object getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest) {
        return executeSync(bybitApiService.getHistoricalVolatility(
                historicalVolatilityRequest.getCategory().getProductTypeId(),
                historicalVolatilityRequest.getBaseCoin(),
                historicalVolatilityRequest.getOptionPeriod(),
                historicalVolatilityRequest.getStartTime(),
                historicalVolatilityRequest.getEndTime())
        );
    }

    @Override
    public Object getRiskLimit(MarketDataRequest marketRiskLimitRequest) {
        return executeSync(bybitApiService.getRiskLimit(
                marketRiskLimitRequest.getCategory().getProductTypeId(),
                marketRiskLimitRequest.getSymbol()));
    }

    @Override
    public Object getInsurance(String coin) {
        return executeSync(bybitApiService.getInsurance(coin));
    }

    @Override
    public Object getInsurance() {
        return executeSync(bybitApiService.getInsurance());
    }

    @Override
    public Object getDeliveryPrice(MarketDataRequest deliveryPriceRequest) {
        return executeSync(bybitApiService.getDeliveryPrice(deliveryPriceRequest.getCategory().getProductTypeId(),
                deliveryPriceRequest.getSymbol(),
                deliveryPriceRequest.getBaseCoin(),
                deliveryPriceRequest.getLimit(),
                deliveryPriceRequest.getCursor()
        ));
    }

    @Override
    public Object getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest) {
        return executeSync(bybitApiService.getMarketAccountRatio(marketAccountRatioRequest.getCategory().getProductTypeId(),
                marketAccountRatioRequest.getSymbol(),
                marketAccountRatioRequest.getDataRecordingPeriod() == null ? null : marketAccountRatioRequest.getDataRecordingPeriod().getPeriod(),
                marketAccountRatioRequest.getLimit()
        ));
    }
}
