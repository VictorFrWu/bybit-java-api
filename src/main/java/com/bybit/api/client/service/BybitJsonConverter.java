package com.bybit.api.client.service;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.TradeOrderType;
import com.bybit.api.client.domain.TriggerBy;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.request.SetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.SetMMPRequest;
import com.bybit.api.client.domain.account.request.SetMarginModeRequest;
import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.domain.institution.clientLending.ClientLendingFundsRequest;
import com.bybit.api.client.domain.institution.insLending.UpdateInstitutionLoadUidRequest;
import com.bybit.api.client.domain.position.request.ConfirmNewRiskLimitRequest;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.account.request.*;
import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeRePayRequest;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.trade.request.*;
import com.bybit.api.client.domain.user.IsUta;
import com.bybit.api.client.domain.user.MemberType;
import com.bybit.api.client.domain.user.SwitchOption;
import com.bybit.api.client.domain.user.UserDataRequest;
import com.bybit.api.client.domain.user.request.CreateApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.ModifyApiKeyRequest;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import com.bybit.api.client.exception.BybitApiException;
import com.bybit.api.client.restApi.BybitApiService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bybit.api.client.constant.Util.generateTransferID;
import static com.bybit.api.client.constant.Util.listToString;

public class BybitJsonConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    // Private Methods
    private TradeOrderRequest getTradeOrderRequest(Map<String, Object> orderMap) {
        String category = orderMap.containsKey("category") ? orderMap.get("category").toString() : null; // Required
        if (StringUtils.isEmpty(category)) throw new BybitApiException("Please set category for your order");
        return getTradeOrderRequest(orderMap, category);
    }

    private TradeOrderRequest getTradeOrderRequest(Map<String, Object> orderMap, String category) {
        // Set default value for time in force
        String orderTypeValue = (String) orderMap.get("orderType");
        TradeOrderType currentOrderType = TradeOrderType.valueOf(orderTypeValue.toUpperCase()); // Required
        TimeInForce defaultTimeInForce = (currentOrderType == TradeOrderType.MARKET) ? TimeInForce.IMMEDIATE_OR_CANCEL : TimeInForce.GOOD_TILL_CANCEL;

        return TradeOrderRequest.builder()
                .category(CategoryType.valueOf(category.toUpperCase()))
                .symbol((String) orderMap.get("symbol"))                          // Required
                .side(Side.valueOf(orderMap.get("side").toString().toUpperCase())) // Required
                .orderType(currentOrderType)   // Required
                .qty((String) orderMap.get("qty"))                                // Required
                .price(orderMap.containsKey("price") ? orderMap.get("price").toString() : null)
                .orderId((String) orderMap.getOrDefault("orderId", null))              // Amend Order ID. Either orderId or orderLinkId is required
                .orderLinkId((String) orderMap.getOrDefault("orderLinkId", null))              // Amend Order ID. Either orderId or orderLinkId is required
                .triggerDirection((Integer) orderMap.getOrDefault("triggerDirection", null)) // Optional
                .orderFilter(orderMap.containsKey("orderFilter") ? OrderFilter.valueOf(orderMap.get("orderFilter").toString().toUpperCase()) : null)  // Optional
                .triggerPrice((String) orderMap.getOrDefault("triggerPrice", null)) // Optional
                .triggerBy(orderMap.containsKey("triggerBy") ? TriggerBy.valueOf(orderMap.get("triggerBy").toString().toUpperCase()) : null) // Optional
                .orderIv((String) orderMap.getOrDefault("orderIv", null))        // Optional
                .timeInForce(TimeInForce.valueOf(orderMap.getOrDefault("timeInForce", defaultTimeInForce).toString().toUpperCase())) // Optional and default value depends on order type
                .positionIdx(orderMap.containsKey("positionIdx") ? getOrderPositionIndexFromString(orderMap.get("positionIdx").toString()) : null) // Optional
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
                .tpOrderType(orderMap.containsKey("tpOrderType") ? TradeOrderType.valueOf(orderMap.get("tpOrderType").toString().toUpperCase()) : null)  // Optional, default to Market
                .slOrderType(orderMap.containsKey("slOrderType") ? TradeOrderType.valueOf(orderMap.get("slOrderType").toString().toUpperCase()) : null)  // Optional, default to Market
                .build();
    }

    private TradeOrderRequest getTradeOrderRequest(JsonNode requestNode) {
        String category = requestNode.has("category") ? requestNode.get("category").asText() : null;
        if (StringUtils.isEmpty(category)) throw new BybitApiException("Please set category for your order");
        return getTradeOrderRequest(requestNode, category);
    }

    public TradeOrderRequest getTradeOrderRequest(JsonNode requestNode, String category) {
        return TradeOrderRequest.builder()
                .category(CategoryType.valueOf(category.toUpperCase()))
                .symbol(requestNode.get("symbol").asText())
                .orderType(TradeOrderType.valueOf(requestNode.get("orderType").asText().toUpperCase()))
                .side(Side.valueOf(requestNode.get("side").asText().toUpperCase()))
                .qty(requestNode.get("qty").asText())
                .price(requestNode.has("price") ? requestNode.get("price").asText() : null)
                .triggerDirection(requestNode.has("triggerDirection") ? requestNode.get("triggerDirection").asInt() : null) // Amend Order ID. Either orderId or orderLinkId is required
                .orderId(requestNode.has("orderId") ? requestNode.get("orderId").asText() : null) // Amend Order ID. Either orderId or orderLinkId is required
                .orderLinkId(requestNode.has("orderLinkId") ? requestNode.get("orderLinkId").asText() : null)
                .orderFilter(requestNode.has("orderFilter") ? OrderFilter.valueOf(requestNode.get("orderFilter").asText().toUpperCase()) : null)
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
                .tpOrderType(requestNode.has("tpOrderType") ? TradeOrderType.valueOf(requestNode.get("tpOrderType").asText().toUpperCase()) : null)
                .slOrderType(requestNode.has("slOrderType") ? TradeOrderType.valueOf(requestNode.get("slOrderType").asText().toUpperCase()) : null)
                .build();
    }

    public PositionIdx getOrderPositionIndexFromString(String positionIdxValue) {
        int index = Integer.parseInt(positionIdxValue);
        for (PositionIdx positionIdx : PositionIdx.values()) {
            if (positionIdx.getIndex() == index) {
                return positionIdx;
            }
        }
        throw new BybitApiException("Position index invalid");
    }

    public CategoryType getCategoryTypeFromString(String category) {
        for (CategoryType type : CategoryType.values()) {
            if (type.getCategoryTypeId().equalsIgnoreCase(category)) {
                return type;
            }
        }
        throw new BybitApiException("category invalid");
    }

    // Trade Mapper
    public TradeOrderRequest convertMapToSingleOrderRequest(Map<String, Object> orderMap) {
        return getTradeOrderRequest(orderMap);
    }

    public TradeOrderRequest convertJsonToSingleOrderRequest(String json) throws IOException {
        JsonNode rootNode = mapper.readTree(json);
        return getTradeOrderRequest(rootNode);
    }

    public BatchOrderRequest jsonToBatchOrderRequest(String json) throws IOException {
        JsonNode rootNode = mapper.readTree(json);
        String category = rootNode.has("category") ? rootNode.get("category").asText() : null;
        if (StringUtils.isEmpty(category)) throw new BybitApiException("Please set category for your order");
        var CategoryType = getCategoryTypeFromString(category);
        List<TradeOrderRequest> requestList = new ArrayList<>();

        JsonNode requestArrayNode = rootNode.get("request");
        for (JsonNode requestNode : requestArrayNode) {
            TradeOrderRequest request = getTradeOrderRequest(requestNode, category);
            requestList.add(request);
        }

        return BatchOrderRequest.builder()
                .category(CategoryType)
                .request(requestList)
                .build();
    }

    public BatchOrderRequest convertMapToBatchOrderRequest(Map<String, Object> payload) {
        String category = payload.containsKey("category") ? payload.get("category").toString() : null; // Required
        if (StringUtils.isEmpty(category)) throw new BybitApiException("Please set category for your order");
        var CategoryType = getCategoryTypeFromString(category);
        @SuppressWarnings("unchecked") // Safe cast as we checked the contents
        List<Map<String, Object>> orderMaps = (List<Map<String, Object>>) payload.get("request");
        List<TradeOrderRequest> orders = new ArrayList<>();
        for (Map<String, Object> orderMap : orderMaps) {
            TradeOrderRequest order = getTradeOrderRequest(orderMap, category);
            orders.add(order);
        }

        return BatchOrderRequest.builder()
                .category(CategoryType)
                .request(orders)
                .build();
    }

    public PlaceBatchOrderRequest convertToPlaceBatchOrderRequest(BatchOrderRequest batchOrderRequest) {
        List<PlaceOrderRequest> list = new ArrayList<>();
        for (TradeOrderRequest tradeOrderRequest : batchOrderRequest.getRequest()) {
            list.add(convertTradeToPlaceOrderRequest(tradeOrderRequest));
        }
        return PlaceBatchOrderRequest.builder()
                .category(batchOrderRequest.getCategory())
                .request(list)
                .build();
    }

    public AmendBatchOrderRequest convertToAmendBatchOrderRequest(BatchOrderRequest batchOrderRequest) {
        List<AmendOrderRequest> list = new ArrayList<>();
        for (TradeOrderRequest tradeOrderRequest : batchOrderRequest.getRequest()) {
            list.add(convertTradeToAmendOrderRequest(tradeOrderRequest));
        }
        return AmendBatchOrderRequest.builder()
                .category(batchOrderRequest.getCategory())
                .request(list)
                .build();
    }

    public CancelBatchOrderRequest convertToCancelBatchOrderRequest(BatchOrderRequest batchOrderRequest) {
        List<CancelOrderRequest> list = new ArrayList<>();
        for (TradeOrderRequest tradeOrderRequest : batchOrderRequest.getRequest()) {
            list.add(convertTradeToCancelOrderRequest(tradeOrderRequest));
        }
        return CancelBatchOrderRequest.builder()
                .category(batchOrderRequest.getCategory())
                .request(list)
                .build();
    }

    public CancelOrderRequest convertTradeToCancelOrderRequest(TradeOrderRequest tradeOrderRequest) {
        return CancelOrderRequest.builder()
                .category(tradeOrderRequest.getCategory() == null ? null : tradeOrderRequest.getCategory().getCategoryTypeId())
                .symbol(tradeOrderRequest.getSymbol())
                .orderId(tradeOrderRequest.getOrderId())
                .orderLinkId(tradeOrderRequest.getOrderLinkId()) // Optional
                .orderFilter(tradeOrderRequest.getOrderFilter() == null ? null : tradeOrderRequest.getOrderFilter().getOrderFilterType())
                .build();
    }

    public CancelAllOrdersRequest convertTradeToCancelAllOrdersRequest(TradeOrderRequest tradeOrderRequest) {
        return CancelAllOrdersRequest.builder()
                .category(tradeOrderRequest.getCategory() == null ? null : tradeOrderRequest.getCategory().getCategoryTypeId())
                .symbol(tradeOrderRequest.getSymbol())
                .baseCoin(tradeOrderRequest.getBaseCoin())
                .settleCoin(tradeOrderRequest.getSettleCoin())
                .orderFilter(tradeOrderRequest.getOrderFilter() == null ? null : tradeOrderRequest.getOrderFilter().getOrderFilterType())
                .stopOrderType(tradeOrderRequest.getStopOrderType() == null ? null : tradeOrderRequest.getStopOrderType().getDescription())
                .build();
    }

    public AmendOrderRequest convertTradeToAmendOrderRequest(TradeOrderRequest tradeOrderRequest) {
        return AmendOrderRequest.builder()
                .category(tradeOrderRequest.getCategory() == null ? null : tradeOrderRequest.getCategory().getCategoryTypeId())
                .symbol(tradeOrderRequest.getSymbol())
                .qty(tradeOrderRequest.getQty())
                .price(tradeOrderRequest.getPrice())
                .triggerPrice(tradeOrderRequest.getTriggerPrice()) // Optional
                .triggerBy(tradeOrderRequest.getTriggerBy() == null ? null : tradeOrderRequest.getTriggerBy().getTrigger()) // Optional
                .orderIv(tradeOrderRequest.getOrderIv())        // Optional
                .orderId(tradeOrderRequest.getOrderId())
                .orderLinkId(tradeOrderRequest.getOrderLinkId()) // Optional
                .takeProfit(tradeOrderRequest.getTakeProfit())  // Optional
                .stopLoss(tradeOrderRequest.getStopLoss())      // Optional
                .tpTriggerBy(tradeOrderRequest.getTpTriggerBy() == null ? null : TriggerBy.LAST_PRICE.getTrigger()) // Optional, default to LastPrice
                .slTriggerBy(tradeOrderRequest.getSlTriggerBy() == null ? null : TriggerBy.LAST_PRICE.getTrigger()) // Optional, default to LastPrice
                .tpslMode(tradeOrderRequest.getTpslMode())      // Optional
                .tpLimitPrice(tradeOrderRequest.getTpLimitPrice()) // Optional
                .slLimitPrice(tradeOrderRequest.getSlLimitPrice()) // Optional
                .build();
    }

    public PlaceOrderRequest convertTradeToPlaceOrderRequest(TradeOrderRequest tradeOrderRequest) {
        return PlaceOrderRequest.builder()
                .category(tradeOrderRequest.getCategory() == null ? null : tradeOrderRequest.getCategory().getCategoryTypeId())
                .symbol(tradeOrderRequest.getSymbol())
                .isLeverage(tradeOrderRequest.getIsLeverage())
                .side(tradeOrderRequest.getSide().getTransactionSide())
                .orderType(tradeOrderRequest.getOrderType().getOType())
                .qty(tradeOrderRequest.getQty())
                .price(tradeOrderRequest.getPrice())
                .triggerDirection(tradeOrderRequest.getTriggerDirection()) // Optional
                .orderFilter(tradeOrderRequest.getOrderFilter() == null ? null : tradeOrderRequest.getOrderFilter().getOrderFilterType())  // Optional
                .triggerPrice(tradeOrderRequest.getTriggerPrice()) // Optional
                .triggerBy(tradeOrderRequest.getTriggerBy() == null ? null : tradeOrderRequest.getTriggerBy().getTrigger()) // Optional
                .orderIv(tradeOrderRequest.getOrderIv())        // Optional
                .timeInForce(tradeOrderRequest.getTimeInForce() == null ? null : tradeOrderRequest.getTimeInForce().getDescription()) // Optional and default value depends on order type
                .positionIdx(tradeOrderRequest.getPositionIdx() == null ? null : tradeOrderRequest.getPositionIdx().getIndex()) // Optional
                .orderLinkId(tradeOrderRequest.getOrderLinkId()) // Optional
                .takeProfit(tradeOrderRequest.getTakeProfit())  // Optional
                .stopLoss(tradeOrderRequest.getStopLoss())      // Optional
                .tpTriggerBy(tradeOrderRequest.getTpTriggerBy() == null ? null : TriggerBy.LAST_PRICE.getTrigger()) // Optional, default to LastPrice
                .slTriggerBy(tradeOrderRequest.getSlTriggerBy() == null ? null : TriggerBy.LAST_PRICE.getTrigger()) // Optional, default to LastPrice
                .reduceOnly(tradeOrderRequest.getReduceOnly())  // Optional, default to false
                .closeOnTrigger(tradeOrderRequest.getCloseOnTrigger())  // Optional, default to false
                .smpType(tradeOrderRequest.getSmpType() == null ? null : tradeOrderRequest.getSmpType().getDescription()) // Optional, replace DEFAULT_SMP_TYPE_VALUE with a real default if needed
                .mmp(tradeOrderRequest.getMmp())               // Optional, default to false
                .tpslMode(tradeOrderRequest.getTpslMode())      // Optional
                .tpLimitPrice(tradeOrderRequest.getTpLimitPrice()) // Optional
                .slLimitPrice(tradeOrderRequest.getSlLimitPrice()) // Optional
                .tpOrderType(tradeOrderRequest.getTpOrderType() == null ? null : tradeOrderRequest.getTpOrderType().getOType())  // Optional, default to Market
                .slOrderType(tradeOrderRequest.getSlOrderType() == null ? null : tradeOrderRequest.getSlOrderType().getOType())  // Optional, default to Market
                .build();
    }

    public SetDcpRequest convertMapToDcpRequest(TradeOrderRequest tradeOrderRequest) {
        return SetDcpRequest.builder().timeWindow(tradeOrderRequest.getTimeWindow()).build();
    }

    // Position Request
    public SetLeverageRequest mapToSetLeverageRequest(PositionDataRequest positionDataRequest) {
        return SetLeverageRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .buyLeverage(positionDataRequest.getBuyLeverage())
                .sellLeverage(positionDataRequest.getSellLeverage())
                .build();
    }

    public SetAutoAddMarginRequest mapToSetAutoAddMarginRequest(PositionDataRequest positionDataRequest) {
        return SetAutoAddMarginRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .autoAddMargin(positionDataRequest.getAutoAddMargin().getValue())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public ModifyMarginRequest mapToModifyMarginRequest(PositionDataRequest positionDataRequest) {
        return ModifyMarginRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .margin(positionDataRequest.getMargin())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public SetRiskLimitRequest mapToSetRiskLimitRequest(PositionDataRequest positionDataRequest) {
        return SetRiskLimitRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .riskId(positionDataRequest.getRiskId())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public ConfirmNewRiskLimitRequest mapToConfirmNewRiskLimitRequest(PositionDataRequest positionDataRequest) {
        return ConfirmNewRiskLimitRequest
                .builder()
                .category(positionDataRequest.getCategory() == null ? null : positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .build();
    }

    public SetTpSlModeRequest mapToSetTpSlModeRequest(PositionDataRequest positionDataRequest) {
        return SetTpSlModeRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .tpSlMode(positionDataRequest.getTpslMode().getDescription())
                .build();
    }

    public SwitchPositionModeRequest mapToSwitchPositionModeRequest(PositionDataRequest positionDataRequest) {
        return SwitchPositionModeRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .coin(positionDataRequest.getBaseCoin())
                .positionMode(positionDataRequest.getPositionMode().getValue())
                .build();
    }

    public TradingStopRequest mapToTradingStopRequest(PositionDataRequest positionDataRequest) {
        return TradingStopRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .takeProfit(positionDataRequest.getTakeProfit())
                .stopLoss(positionDataRequest.getStopLoss())
                .trailingStop(positionDataRequest.getTrailingStop())
                .tpTriggerBy(positionDataRequest.getTpTriggerBy() == null ? null : positionDataRequest.getTpTriggerBy().getTrigger())
                .slTriggerBy(positionDataRequest.getSlTriggerBy() == null ? null : positionDataRequest.getSlTriggerBy().getTrigger())
                .activePrice(positionDataRequest.getActivePrice())
                .tpslMode(positionDataRequest.getTpslMode() == null ? null : positionDataRequest.getTpslMode().getDescription())
                .tpSize(positionDataRequest.getTpSize())
                .slSize(positionDataRequest.getSlSize())
                .tpLimitPrice(positionDataRequest.getTpLimitPrice())
                .slLimitPrice(positionDataRequest.getSlLimitPrice())
                .tpOrderType(positionDataRequest.getTpOrderType() == null ? null : positionDataRequest.getTpOrderType().getOType())
                .slOrderType(positionDataRequest.getSlOrderType() == null ? null : positionDataRequest.getSlOrderType().getOType())
                .positionIdx(positionDataRequest.getPositionIdx().getIndex())
                .build();
    }

    public SwitchMarginRequest mapToSwitchMarginRequest(PositionDataRequest positionDataRequest) {
        return SwitchMarginRequest.builder()
                .category(positionDataRequest.getCategory().getCategoryTypeId())
                .symbol(positionDataRequest.getSymbol())
                .tradeMode(positionDataRequest.getTradeMode().getValue())
                .buyLeverage(positionDataRequest.getBuyLeverage())
                .sellLeverage(positionDataRequest.getSellLeverage())
                .build();
    }

    // Account request
    public SetMarginModeRequest mapToSetMarginModeRequest(AccountDataRequest accountDataRequest) {
        return SetMarginModeRequest.builder()
                .setMarginMode(accountDataRequest.getSetMarginMode() == null ? null : accountDataRequest.getSetMarginMode().getDescription())
                .build();
    }

    public ResetMMPRequest mapToResetMarginModeRequest(AccountDataRequest accountDataRequest) {
        return ResetMMPRequest.builder()
                .baseCoin(accountDataRequest.getBaseCoin())
                .build();
    }

    public SetCollateralCoinRequest mapToSetCollateralCoinRequest(AccountDataRequest accountDataRequest) {
        return SetCollateralCoinRequest.builder()
                .coin(accountDataRequest.getCoin())
                .collateralSwitch(accountDataRequest.getCollateralSwitch())
                .build();
    }

    public SetMMPRequest mapToSetMMPRequest(AccountDataRequest accountDataRequest) {
        return SetMMPRequest.builder()
                .baseCoin(accountDataRequest.getBaseCoin())
                .window(accountDataRequest.getWindow())
                .frozenPeriod(accountDataRequest.getFrozenPeriod())
                .qtyLimit(accountDataRequest.getQtyLimit())
                .deltaLimit(accountDataRequest.getDeltaLimit())
                .build();
    }

    public SetSpotHedgingRequest mapToSetSpotHedgingModeRequest(AccountDataRequest setSpotHedging) {
        return SetSpotHedgingRequest.builder().setHedgingMode(setSpotHedging.getSetHedgingMode() == null ? null : setSpotHedging.getSetHedgingMode().getSpotHedgingMode()).build();
    }

    // Asset request
    public AssetInternalTransferRequest mapToAssetInternalTransferRequest(AssetDataRequest assetDataRequest) {
        return AssetInternalTransferRequest.builder()
                .transferId(assetDataRequest.getTransferId() == null ? generateTransferID() : assetDataRequest.getTransferId())
                .coin(assetDataRequest.getCoin())
                .amount(assetDataRequest.getAmount())
                .fromAccountType(assetDataRequest.getFromAccountType().getAccountTypeValue())  // Assuming fromAccountType is an enum and you want to store its name as String in AssetInternalTransferRequest
                .toAccountType(assetDataRequest.getToAccountType().getAccountTypeValue())      // Same assumption as above
                .build();
    }

    public AssetUniversalTransferRequest mapToAssetUniversalTransferRequest(AssetDataRequest assetDataRequest) {
        return AssetUniversalTransferRequest.builder()
                .transferId(assetDataRequest.getTransferId() == null ? generateTransferID() : assetDataRequest.getTransferId())
                .coin(assetDataRequest.getCoin())
                .amount(assetDataRequest.getAmount())
                .fromMemberId(assetDataRequest.getFromMemberId())  // Assuming memberId in AssetDataRequest is a String and you want to convert it to Integer in AssetUniversalTransferRequest
                .toMemberId(assetDataRequest.getToMemberId())  // Same assumption as above
                .fromAccountType(assetDataRequest.getFromAccountType().getAccountTypeValue())  // Assuming fromAccountType is an enum and you want to store its name as String in AssetUniversalTransferRequest
                .toAccountType(assetDataRequest.getToAccountType().getAccountTypeValue())      // Same assumption as above
                .build();
    }

    public SetAssetDepositAccountRequest mapToSetDepositAccountRequest(AssetDataRequest request) {
        return SetAssetDepositAccountRequest.builder().accountType(request.getAccountType() == null ? null : request.getAccountType().getAccountTypeValue()).build();
    }

    public AssetCancelWithdrawRequest mapToAssetCancelWithdrawRequest(AssetDataRequest request) {
        return AssetCancelWithdrawRequest.builder().withdrawId(request.getWithdrawID()).build();
    }

    public AssetWithdrawRequest mapToAssetWithdrawRequest(AssetDataRequest assetDataRequest) {
        return AssetWithdrawRequest.builder()
                .coin(assetDataRequest.getCoin())
                .chain(assetDataRequest.getChain())
                .address(assetDataRequest.getAddress())
                .tag(assetDataRequest.getTag())
                .amount(assetDataRequest.getAmount())
                .timestamp(assetDataRequest.getTimestamp())
                .forceChain(assetDataRequest.getForceChain())
                .accountType(assetDataRequest.getAccountType() != null ? assetDataRequest.getAccountType().name() : null)  // Assuming accountType is an enum and you want to store its name as String in AssetWithdrawRequest
                .feeType(assetDataRequest.getFeeType() == null ? null : assetDataRequest.getFeeType().getValue())
                .build();
    }

    public Call<Object> getSingleCoinBalance(BybitApiService bybitApiService, AssetDataRequest singleCoinBalanceRequest) {
        return bybitApiService.getAssetSingleCoinBalance(
                singleCoinBalanceRequest.getAccountType() == null ? null : singleCoinBalanceRequest.getAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getToAccountType() == null ? null : singleCoinBalanceRequest.getToAccountType().getAccountTypeValue(),
                singleCoinBalanceRequest.getMemberId(),
                singleCoinBalanceRequest.getToMemberId() == null ? null : singleCoinBalanceRequest.getToMemberId().toString(),
                singleCoinBalanceRequest.getCoin(),
                singleCoinBalanceRequest.getWithBonus() == null ? null : singleCoinBalanceRequest.getWithBonus().getValue(),
                singleCoinBalanceRequest.getWithTransferSafeAmount() == null ? null : singleCoinBalanceRequest.getWithTransferSafeAmount().getValue(),
                singleCoinBalanceRequest.getWithLtvTransferSafeAmount() == null ? null : singleCoinBalanceRequest.getWithLtvTransferSafeAmount().getValue());
    }
    // User Requests
    public UserSubMemberRequest mapToCreateSubMemberRequest(UserDataRequest subUserRequest) {
        return UserSubMemberRequest.builder()
                .username(subUserRequest.getUsername())
                .password(subUserRequest.getPassword())
                .memberType(subUserRequest.getMemberType() == null ? MemberType.NORMAL_SUB_ACCOUNT.getValue() : subUserRequest.getMemberType().getValue())
                .switchOption(subUserRequest.getSwitchOption() == null ? SwitchOption.TURN_OFF.getValue() : subUserRequest.getSwitchOption().getValue())
                .isUta(subUserRequest.getIsUta() == null ? IsUta.CLASSIC_ACCOUNT.isValue() : subUserRequest.getIsUta().isValue())
                .note(subUserRequest.getNote())
                .build();
    }

    public CreateApiKeyRequest mapToCreateSubApiRequest(UserDataRequest subUserRequest) {
        return CreateApiKeyRequest.builder()
                .subuid(subUserRequest.getSubuid())
                .note(subUserRequest.getPassword())
                .readOnly(subUserRequest.getReadOnlyStatus() == null ? null : subUserRequest.getReadOnlyStatus().getValue())
                .ips(subUserRequest.getIps() == null ? null : listToString(subUserRequest.getIps()))
                .permissions(subUserRequest.getUserPermissionsMap() == null ? null : subUserRequest.getUserPermissionsMap().getPermissionMap())
                .build();
    }

    public FreezeSubUIDRquest mapToFreezeSubApiRequest(UserDataRequest request) {
        return FreezeSubUIDRquest.builder()
                .subuid(request.getSubuid())
                .frozen(request.getFrozenStatus() == null ? null : request.getFrozenStatus().getValue())
                .build();
    }

    public ModifyApiKeyRequest mapToModifyApiKeyRequest(UserDataRequest userDataRequest) {
        return ModifyApiKeyRequest.builder()
                .readOnly(userDataRequest.getReadOnlyStatus() == null ? null : userDataRequest.getReadOnlyStatus().getValue())
                .ips(userDataRequest.getIps() == null ? null : listToString(userDataRequest.getIps()))
                .permissionsMap(userDataRequest.getUserPermissionsMap() == null ? null : userDataRequest.getUserPermissionsMap().getPermissionMap())
                .build();
    }

    public ModifyApiKeyRequest mapToDeleteSubApiKeyRequest(UserDataRequest userDataRequest) {
        return ModifyApiKeyRequest
                .builder()
                .apikey(userDataRequest.getApikey())
                .build();
    }

    // Spot Margin Requests
    public SpotLeverageTokenRequest mapToSpotLeverageTokenRequest(SpotMarginDataRequest spotMarginDataRequest) {
        return SpotLeverageTokenRequest
                .builder()
                .ltCoin(spotMarginDataRequest.getLtCoin())
                .quantity(spotMarginDataRequest.getQuantity())
                .serialNo(spotMarginDataRequest.getSerialNo())
                .ltAmount(spotMarginDataRequest.getLtAmount())
                .build();
    }

    public SpotMarginTradeBorrowRequest mapToSpotMarginBorrowRequest(SpotMarginDataRequest spotMarginDataRequest) {
        return SpotMarginTradeBorrowRequest
                .builder()
                .coin(spotMarginDataRequest.getCoin())
                .qty(spotMarginDataRequest.getQty())
                .build();
    }

    public SpotMarginTradeRePayRequest mapToSpotMarginRepayRequest(SpotMarginDataRequest spotMarginDataRequest) {
        return SpotMarginTradeRePayRequest
                .builder()
                .coin(spotMarginDataRequest.getCoin())
                .qty(spotMarginDataRequest.getQty())
                .completeRepayment(spotMarginDataRequest.getCompleteRepayment() == null ? 0 : spotMarginDataRequest.getCompleteRepayment().getValue())
                .build();
    }

    public ClientLendingFundsRequest mapToC2CLendingFundRequest(LendingDataRequest lendingDataRequest) {
        return ClientLendingFundsRequest
                .builder()
                .coin(lendingDataRequest.getCoin())
                .orderId(lendingDataRequest.getOrderId())
                .quantity(lendingDataRequest.getQuantity())
                .serialNo(lendingDataRequest.getSerialNo())
                .build();
    }

    // Institution
    public UpdateInstitutionLoadUidRequest convertToUpdateInsUidRequest(LendingDataRequest lendingDataRequest) {
        return UpdateInstitutionLoadUidRequest
                .builder()
                .uid(lendingDataRequest.getUid())
                .operate(lendingDataRequest.getOperate() == null ? null : lendingDataRequest.getOperate().getOperateType())
                .build();
    }
}