package com.bybit.api.domain.trade;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.trade.response.OrderEntry;
import com.bybit.api.client.domain.trade.response.OrderResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class OrderResultDeserializerTest {

    @Test
    public void testOrderResultDeserialization() {
        final String orderResultJson = "{"
                + "\"retCode\":0,"
                + "\"retMsg\":\"OK\","
                + "\"result\":{"
                + "\"nextPageCursor\":\"819f16c1-e846-4b02-9ce1-58e94623e2c7%3A1692308802198%2Ca7f6b647-0721-43c2-aab8-8765faa8ddef%3A1692308186396\","
                + "\"category\":\"linear\","
                + "\"list\": ["
                + "{"
                + "\"symbol\":\"BTCUSDT\","
                + "\"orderType\":\"Limit\","
                + "\"orderLinkId\":\"\","
                + "\"slLimitPrice\":\"0\","
                + "\"orderId\":\"819f16c1-e846-4b02-9ce1-58e94623e2c7\","
                + "\"cancelType\":\"CancelByUser\","
                + "\"avgPrice\":\"\","
                + "\"stopOrderType\":\"\","
                + "\"lastPriceOnCreated\":\"26457.4\","
                + "\"orderStatus\":\"Cancelled\","
                + "\"takeProfit\":\"\","
                + "\"cumExecValue\":\"0\","
                + "\"tpslMode\":\"UNKNOWN\","
                + "\"smpType\":\"None\","
                + "\"triggerDirection\":0,"
                + "\"blockTradeId\":\"\","
                + "\"rejectReason\":\"EC_PerCancelRequest\","
                + "\"isLeverage\":\"\","
                + "\"price\":\"18900\","
                + "\"orderIv\":\"\","
                + "\"createdTime\":\"1692308802198\","
                + "\"tpTriggerBy\":\"\","
                + "\"positionIdx\":0,"
                + "\"timeInForce\":\"GTC\","
                + "\"leavesValue\":\"0\","
                + "\"updatedTime\":\"1692309377016\","
                + "\"side\":\"Buy\","
                + "\"smpGroup\":0,"
                + "\"triggerPrice\":\"\","
                + "\"tpLimitPrice\":\"0\","
                + "\"cumExecFee\":\"0\","
                + "\"slTriggerBy\":\"\","
                + "\"leavesQty\":\"0\","
                + "\"closeOnTrigger\":false,"
                + "\"placeType\":\"\","
                + "\"cumExecQty\":\"0\","
                + "\"reduceOnly\":false,"
                + "\"qty\":\"0.001\","
                + "\"stopLoss\":\"\","
                + "\"smpOrderId\":\"\","
                + "\"triggerBy\":\"\""
                + "},"
                + "{"
                + "\"symbol\":\"BTCUSDT\","
                + "\"orderType\":\"Limit\","
                + "\"orderLinkId\":\"\","
                + "\"slLimitPrice\":\"0\","
                + "\"orderId\":\"a7f6b647-0721-43c2-aab8-8765faa8ddef\","
                + "\"cancelType\":\"CancelByUser\","
                + "\"avgPrice\":\"\","
                + "\"stopOrderType\":\"\","
                + "\"lastPriceOnCreated\":\"27648.8\","
                + "\"orderStatus\":\"Cancelled\","
                + "\"takeProfit\":\"\","
                + "\"cumExecValue\":\"0\","
                + "\"tpslMode\":\"UNKNOWN\","
                + "\"smpType\":\"None\","
                + "\"triggerDirection\":0,"
                + "\"blockTradeId\":\"\","
                + "\"rejectReason\":\"EC_PerCancelRequest\","
                + "\"isLeverage\":\"\","
                + "\"price\":\"17500\","
                + "\"orderIv\":\"\","
                + "\"createdTime\":\"1692308186396\","
                + "\"tpTriggerBy\":\"\","
                + "\"positionIdx\":0,"
                + "\"timeInForce\":\"GTC\","
                + "\"leavesValue\":\"0\","
                + "\"updatedTime\":\"1692309376548\","
                + "\"side\":\"Buy\","
                + "\"smpGroup\":0,"
                + "\"triggerPrice\":\"\","
                + "\"tpLimitPrice\":\"0\","
                + "\"cumExecFee\":\"0\","
                + "\"slTriggerBy\":\"\","
                + "\"leavesQty\":\"0\","
                + "\"closeOnTrigger\":false,"
                + "\"placeType\":\"\","
                + "\"cumExecQty\":\"0\","
                + "\"reduceOnly\":false,"
                + "\"qty\":\"0.1\","
                + "\"stopLoss\":\"\","
                + "\"smpOrderId\":\"\","
                + "\"triggerBy\":\"\""
                + "}"
                + "]"
                + "},"
                + "\"retExtInfo\":{},"
                + "\"time\":1692606475515"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GenericResponse<OrderResult> response = objectMapper.readValue(orderResultJson, objectMapper.getTypeFactory().constructParametricType(GenericResponse.class, OrderResult.class));
            System.out.println("retCode: " + response.getRetCode());
            System.out.println("retMsg: " + response.getRetMsg());

            var orderResult = response.getResult();
            System.out.println("nextPageCursor: " + orderResult.getNextPageCursor());
            System.out.println("category: " + orderResult.getCategory());

            for (OrderEntry order : orderResult.getOrderEntries()) {
                System.out.println("orderId: " + order.getOrderId());
                System.out.println("price: " + order.getPrice());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
