package com.bybit.api.client.service;

import com.bybit.api.client.domain.ProductType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.position.PositionDataRequest;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.preupgrade.request.*;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonConverter {

    // Trade Mapper
    private final ObjectMapper mapper = new ObjectMapper();

    public BatchOrderRequest jsonToBatchOrderRequest(String json) throws IOException {
        JsonNode rootNode = mapper.readTree(json);

        String category = rootNode.get("category").asText();

        List<TradeOrderRequest> requestList = new ArrayList<>();

        JsonNode requestArrayNode = rootNode.get("request");
        for (JsonNode requestNode : requestArrayNode) {
            TradeOrderRequest request = TradeOrderRequest.builder()
                    .category(ProductType.valueOf(category.toUpperCase()))
                    .symbol(requestNode.get("symbol").asText())
                    .orderType(TradeOrderType.valueOf(requestNode.get("orderType").asText().toUpperCase()))
                    .transactionSide(TransactionSide.valueOf(requestNode.get("side").asText().toUpperCase()))
                    .qty(requestNode.get("qty").asText())
                    .price(requestNode.has("price") ? requestNode.get("price").asText() : null)
                    .triggerDirection(requestNode.has("triggerDirection") ? requestNode.get("triggerDirection").asInt() : null) // Amend Order ID. Either orderId or orderLinkId is required
                    .orderId(requestNode.has("orderId") ? requestNode.get("orderId").asText() : null) // Amend Order ID. Either orderId or orderLinkId is required
                    .orderLinkId(requestNode.has("orderLinkId") ? requestNode.get("orderLinkId").asText() : null)
                    .orderFilter(requestNode.has("orderFilter") ? requestNode.get("orderFilter").asText() : null)
                    .triggerPrice(requestNode.has("triggerPrice") ? requestNode.get("triggerPrice").asText() : null)
                    .triggerBy(requestNode.has("triggerBy") ? TriggerBy.valueOf(requestNode.get("triggerBy").asText().toUpperCase()) : null)
                    .orderIv(requestNode.has("orderIv") ? requestNode.get("orderIv").asText() : null)
                    .timeInForce(requestNode.has("timeInForce") ? TimeInForce.valueOf(requestNode.get("timeInForce").asText().toUpperCase()) : null)
                    .positionIdx(requestNode.has("positionIdx") ? PositionIdx.valueOf(requestNode.get("positionIdx").asText().toUpperCase()) : null)
                    .orderLinkId(requestNode.has("orderLinkId") ? requestNode.get("orderLinkId").asText() : null)
                    .takeProfit(requestNode.has("takeProfit") ? requestNode.get("takeProfit").asText() : null)
                    .stopLoss(requestNode.has("stopLoss") ? requestNode.get("stopLoss").asText() : null)
                    .tpTriggerBy(requestNode.has("tpTriggerBy") ? TriggerBy.valueOf(requestNode.get("tpTriggerBy").asText().toUpperCase()) : TriggerBy.LAST_PRICE)
                    .slTriggerBy(requestNode.has("slTriggerBy") ? TriggerBy.valueOf(requestNode.get("slTriggerBy").asText().toUpperCase()) : TriggerBy.LAST_PRICE)
                    .reduceOnly(requestNode.has("reduceOnly") && requestNode.get("reduceOnly").asBoolean())
                    .closeOnTrigger(requestNode.has("closeOnTrigger") && requestNode.get("closeOnTrigger").asBoolean())
                    .smpType(requestNode.has("smpType") ? SmpType.valueOf(requestNode.get("smpType").asText().toUpperCase()) : null)
                    .mmp(requestNode.has("mmp") ? requestNode.get("mmp").asBoolean() : null)
                    .tpslMode(requestNode.has("tpslMode") ? requestNode.get("tpslMode").asText() : null)
                    .tpLimitPrice(requestNode.has("tpLimitPrice") ? requestNode.get("tpLimitPrice").asText() : null)
                    .slLimitPrice(requestNode.has("slLimitPrice") ? requestNode.get("slLimitPrice").asText() : null)
                    .tpOrderType(requestNode.has("tpOrderType") ? requestNode.get("tpOrderType").asText() : "Market")
                    .slOrderType(requestNode.has("slOrderType") ? requestNode.get("slOrderType").asText() : "Market")
                    .build();

            requestList.add(request);
        }

        return BatchOrderRequest.builder()
                .category(category)
                .request(requestList)
                .build();
    }

    public BatchOrderRequest convertMapToBatchOrderRequest(Map<String, Object> payload) {
        String category = (String) payload.get("category"); // Required

        List<Map<String, Object>> orderMaps = (List<Map<String, Object>>) payload.get("request");

        List<TradeOrderRequest> orders = new ArrayList<>();
        for (Map<String, Object> orderMap : orderMaps) {
            // Set default value for time in force
            String orderTypeValue = (String) orderMap.get("orderType");
            TradeOrderType currentOrderType = TradeOrderType.valueOf(orderTypeValue.toUpperCase()); // Required
            TimeInForce defaultTimeInForce = (currentOrderType == TradeOrderType.MARKET) ? TimeInForce.IOC : TimeInForce.GTC;

            TradeOrderRequest order = TradeOrderRequest.builder()
                    .category(ProductType.valueOf(category.toUpperCase()))
                    .symbol((String) orderMap.get("symbol"))                          // Required
                    .transactionSide(TransactionSide.valueOf(orderMap.get("side").toString().toUpperCase())) // Required
                    .orderType(currentOrderType)   // Required
                    .qty((String) orderMap.get("qty"))                                // Required
                    .orderId((String) orderMap.getOrDefault("orderId", null))              // Amend Order ID. Either orderId or orderLinkId is required
                    .orderLinkId((String) orderMap.getOrDefault("orderLinkId", null))              // Amend Order ID. Either orderId or orderLinkId is required
                    .triggerDirection((Integer) orderMap.getOrDefault("triggerDirection", null)) // Optional
                    .orderFilter((String) orderMap.getOrDefault("orderFilter", null))  // Optional
                    .triggerPrice((String) orderMap.getOrDefault("triggerPrice", null)) // Optional
                    .triggerBy(orderMap.containsKey("triggerBy") ? TriggerBy.valueOf(orderMap.get("triggerBy").toString().toUpperCase()) : null) // Optional
                    .orderIv((String) orderMap.getOrDefault("orderIv", null))        // Optional
                    .timeInForce(TimeInForce.valueOf(orderMap.getOrDefault("timeInForce", defaultTimeInForce).toString().toUpperCase())) // Optional and default value depends on order type
                    .positionIdx(orderMap.containsKey("positionIdx") ? getOrderPositionIndex(orderMap.get("positionIdx").toString()) : null) // Optional
                    .orderLinkId((String) orderMap.getOrDefault("orderLinkId", null)) // Optional
                    .takeProfit((String) orderMap.getOrDefault("takeProfit", null))  // Optional
                    .stopLoss((String) orderMap.getOrDefault("stopLoss", null))      // Optional
                    .tpTriggerBy(orderMap.containsKey("tpTriggerBy") ? TriggerBy.valueOf(orderMap.get("tpTriggerBy").toString().toUpperCase()) : TriggerBy.LAST_PRICE) // Optional, default to LastPrice
                    .slTriggerBy(orderMap.containsKey("slTriggerBy") ? TriggerBy.valueOf(orderMap.get("slTriggerBy").toString().toUpperCase()) : TriggerBy.LAST_PRICE) // Optional, default to LastPrice
                    .reduceOnly((Boolean) orderMap.getOrDefault("reduceOnly", false))  // Optional, default to false
                    .closeOnTrigger((Boolean) orderMap.getOrDefault("closeOnTrigger", false))  // Optional, default to false
                    .smpType(orderMap.containsKey("smpType") ? SmpType.valueOf(orderMap.get("smpType").toString().toUpperCase()) : null) // Optional, replace DEFAULT_SMP_TYPE_VALUE with a real default if needed
                    .mmp((Boolean) orderMap.getOrDefault("mmp", null))               // Optional, default to false
                    .tpslMode((String) orderMap.getOrDefault("tpslMode", null))      // Optional
                    .tpLimitPrice((String) orderMap.getOrDefault("tpLimitPrice", null)) // Optional
                    .slLimitPrice((String) orderMap.getOrDefault("slLimitPrice", null)) // Optional
                    .tpOrderType((String) orderMap.getOrDefault("tpOrderType", "null"))  // Optional, default to Market
                    .slOrderType((String) orderMap.getOrDefault("slOrderType", "null"))  // Optional, default to Market
                    .build();

            orders.add(order);
        }

        return BatchOrderRequest.builder()
                .category(category)
                .request(orders)
                .build();
    }

    public PositionIdx getOrderPositionIndex(String positionIdxValue) {
        int index = Integer.parseInt(positionIdxValue);
        for (PositionIdx positionIdx : PositionIdx.values()) {
            if (positionIdx.getIndex() == index) {
                return positionIdx;
            }
        }
        return null;
    }

    // Position Request
    public SetLeverageRequest mapToSetLeverageRequest(PositionDataRequest positionDataRequest) {
        return SetLeverageRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .buyLeverage(positionDataRequest.getBuyLeverage())
                .sellLeverage(positionDataRequest.getSellLeverage())
                .build();
    }

    public SetAutoAddMarginRequest mapToSetAutoAddMarginRequest(PositionDataRequest positionDataRequest) {
        return SetAutoAddMarginRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .autoAddMargin(positionDataRequest.getAutoAddMargin().getValue())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public ModifyMarginRequest mapToModifyMarginRequest(PositionDataRequest positionDataRequest) {
        return ModifyMarginRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .margin(positionDataRequest.getMargin())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public SetRiskLimitRequest mapToSetRiskLimitRequest(PositionDataRequest positionDataRequest) {
        return SetRiskLimitRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .riskId(positionDataRequest.getRiskId())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public SetTpSlModeRequest mapToSetTpSlModeRequest(PositionDataRequest positionDataRequest) {
        return SetTpSlModeRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .tpSlMode(positionDataRequest.getTpslMode().getDescription())
                .build();
    }

    public SwitchPositionModeRequest mapToSwitchPositionModeRequest(PositionDataRequest positionDataRequest) {
        return SwitchPositionModeRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .coin(positionDataRequest.getBaseCoin())
                .positionMode(positionDataRequest.getPositionMode().getValue())
                .build();
    }

    public TradingStopRequest mapToTradingStopRequest(PositionDataRequest positionDataRequest) {
        return TradingStopRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .takeProfit(positionDataRequest.getTakeProfit())
                .stopLoss(positionDataRequest.getStopLoss())
                .trailingStop(positionDataRequest.getTrailingStop())
                .tpTriggerBy(positionDataRequest.getTpTriggerBy().getTrigger())
                .slTriggerBy(positionDataRequest.getSlTriggerBy().getTrigger())
                .activePrice(positionDataRequest.getActivePrice())
                .tpslMode(positionDataRequest.getTpslMode().getDescription())
                .tpSize(positionDataRequest.getTpSize())
                .slSize(positionDataRequest.getSlSize())
                .tpLimitPrice(positionDataRequest.getTpLimitPrice())
                .slLimitPrice(positionDataRequest.getSlLimitPrice())
                .tpOrderType(positionDataRequest.getTpOrderType().getOType())
                .slOrderType(positionDataRequest.getSlOrderType().getOType())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public SwitchMarginRequest mapToSwitchMarginRequest(PositionDataRequest positionDataRequest) {
        return SwitchMarginRequest.builder()
                .category(positionDataRequest.getCategory().getProductTypeId())
                .symbol(positionDataRequest.getSymbol())
                .tradeMode(positionDataRequest.getTradeMode().getValue())
                .buyLeverage(positionDataRequest.getBuyLeverage())
                .sellLeverage(positionDataRequest.getSellLeverage())
                .build();
    }

    // Pre upgrade request
    public PreUpgradeClosePnlRequest mapToPreUpgradeClosePnlRequest(PreUpgradeDataRequest preUpgradeDataRequest) {
        return PreUpgradeClosePnlRequest.builder()
                .category(preUpgradeDataRequest.getCategory().getProductTypeId())
                .symbol(preUpgradeDataRequest.getSymbol())
                .startTime(preUpgradeDataRequest.getStartTime())
                .endTime(preUpgradeDataRequest.getEndTime())
                .limit(preUpgradeDataRequest.getLimit())
                .cursor(preUpgradeDataRequest.getCursor())
                .build();
    }

    public PreUpgradeOrderHistoryRequest mapToPreUpgradeOrderHistoryRequest(PreUpgradeDataRequest preUpgradeDataRequest) {
        return PreUpgradeOrderHistoryRequest.builder()
                .category(preUpgradeDataRequest.getCategory().getProductTypeId())
                .symbol(preUpgradeDataRequest.getSymbol())
                .baseCoin(preUpgradeDataRequest.getBaseCoin())
                .orderId(preUpgradeDataRequest.getOrderId())
                .orderLinkId(preUpgradeDataRequest.getOrderLinkId())
                .orderFilter(preUpgradeDataRequest.getOrderFilter())
                .orderStatus(preUpgradeDataRequest.getOrderStatus() != null ? preUpgradeDataRequest.getOrderStatus().getDescription() : null)
                .startTime(preUpgradeDataRequest.getStartTime())
                .endTime(preUpgradeDataRequest.getEndTime())
                .limit(preUpgradeDataRequest.getLimit())
                .cursor(preUpgradeDataRequest.getCursor())
                .build();
    }

    public PreUpgradeOptionDeliveryRequest mapToPreUpgradeOptionDeliveryRequest(PreUpgradeDataRequest preUpgradeDataRequest) {
        return PreUpgradeOptionDeliveryRequest.builder()
                .category(preUpgradeDataRequest.getCategory().getProductTypeId())
                .symbol(preUpgradeDataRequest.getSymbol())
                .expDate(preUpgradeDataRequest.getExpDate())
                .limit(preUpgradeDataRequest.getLimit())
                .cursor(preUpgradeDataRequest.getCursor())
                .build();
    }

    public PreUpgradeTransactionRequest mapToPreUpgradeTransactionRequest(PreUpgradeDataRequest preUpgradeDataRequest) {
        return PreUpgradeTransactionRequest.builder()
                .category(preUpgradeDataRequest.getCategory().getProductTypeId())
                .baseCoin(preUpgradeDataRequest.getBaseCoin())
                .transactionType(preUpgradeDataRequest.getTransactionType() != null ? preUpgradeDataRequest.getTransactionType().getTransactionTypeId() : null)
                .startTime(preUpgradeDataRequest.getStartTime())
                .endTime(preUpgradeDataRequest.getEndTime())
                .limit(preUpgradeDataRequest.getLimit())
                .cursor(preUpgradeDataRequest.getCursor())
                .build();
    }

    public PreUpgradeTradeHistoryRequest mapToPreUpgradeTradeHistoryRequest(PreUpgradeDataRequest preUpgradeDataRequest) {
        return PreUpgradeTradeHistoryRequest.builder()
                .category(preUpgradeDataRequest.getCategory().getProductTypeId())
                .symbol(preUpgradeDataRequest.getSymbol())
                .orderId(preUpgradeDataRequest.getOrderId())
                .orderLinkId(preUpgradeDataRequest.getOrderLinkId())
                .baseCoin(preUpgradeDataRequest.getBaseCoin())
                .startTime(preUpgradeDataRequest.getStartTime())
                .endTime(preUpgradeDataRequest.getEndTime())
                .execType(preUpgradeDataRequest.getExecType() != null ? preUpgradeDataRequest.getExecType().getExecTypeId() : null)
                .limit(preUpgradeDataRequest.getLimit())
                .cursor(preUpgradeDataRequest.getCursor())
                .build();
    }

    public PreUpgradeUsdcSettlementRequest mapToPreUpgradeUsdcSettlementRequest(PreUpgradeDataRequest preUpgradeDataRequest) {
        return PreUpgradeUsdcSettlementRequest.builder()
                .category(preUpgradeDataRequest.getCategory().getProductTypeId())
                .symbol(preUpgradeDataRequest.getSymbol())
                .limit(preUpgradeDataRequest.getLimit())
                .cursor(preUpgradeDataRequest.getCursor())
                .build();
    }

}