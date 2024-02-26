package com.bybit.api.client.domain.websocket_message.public_channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicTickerData {
    private String symbol;
    private String tickDirection;
    private String bidPrice;
    private String bidSize;
    private String bidIv;
    private String askPrice;
    private String askSize;
    private String askIv;
    private String lastPrice;
    private String highPrice24h;
    private String lowPrice24h;
    private String prevPrice24h;
    private String volume24h;
    private String turnover24h;
    private String price24hPcnt;
    private String usdIndexPrice;
    private String underlyingPrice;
    private String markPrice;
    private String indexPrice;
    private String markPriceIv;
    private String openInterest;
    private String openInterestValue;
    private String totalVolume;
    private String totalTurnover;
    private String nextFundingTime;
    private String fundingRate;
    private String bid1Price;
    private String bid1Size;
    private String ask1Price;
    private String ask1Size;
    private String delta;   // Option
    private String gamma;   // Option
    private String vega;    // Option
    private String theta; // Option
    private String deliveryTime; // Linear and Inverse
    private String basisRate; // Linear and Inverse
    private String deliveryFeeRate; // Linear and Inverse
    private String predictedDeliveryPrice;
    private String change24h;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublicTickerData{");

        if (symbol != null) sb.append("symbol='").append(symbol).append("', ");
        if (tickDirection != null) sb.append("tickDirection='").append(tickDirection).append("', ");
        if (bidPrice != null) sb.append("bidPrice='").append(bidPrice).append("', ");
        if (bidSize != null) sb.append("bidSize='").append(bidSize).append("', ");
        if (bidIv != null) sb.append("bidIv='").append(bidIv).append("', ");
        if (askPrice != null) sb.append("askPrice='").append(askPrice).append("', ");
        if (askSize != null) sb.append("askSize='").append(askSize).append("', ");
        if (askIv != null) sb.append("askIv='").append(askIv).append("', ");
        if (lastPrice != null) sb.append("lastPrice='").append(lastPrice).append("', ");
        if (highPrice24h != null) sb.append("highPrice24h='").append(highPrice24h).append("', ");
        if (lowPrice24h != null) sb.append("lowPrice24h='").append(lowPrice24h).append("', ");
        if (prevPrice24h != null) sb.append("prevPrice24h='").append(prevPrice24h).append("', ");
        if (volume24h != null) sb.append("volume24h='").append(volume24h).append("', ");
        if (turnover24h != null) sb.append("turnover24h='").append(turnover24h).append("', ");
        if (price24hPcnt != null) sb.append("price24hPcnt='").append(price24hPcnt).append("', ");
        if (usdIndexPrice != null) sb.append("usdIndexPrice='").append(usdIndexPrice).append("', ");
        if (underlyingPrice != null) sb.append("underlyingPrice='").append(underlyingPrice).append("', ");
        if (markPrice != null) sb.append("markPrice='").append(markPrice).append("', ");
        if (indexPrice != null) sb.append("indexPrice='").append(indexPrice).append("', ");
        if (markPriceIv != null) sb.append("markPriceIv='").append(markPriceIv).append("', ");
        if (openInterest != null) sb.append("openInterest='").append(openInterest).append("', ");
        if (openInterestValue != null) sb.append("openInterestValue='").append(openInterestValue).append("', ");
        if (totalVolume != null) sb.append("totalVolume='").append(totalVolume).append("', ");
        if (totalTurnover != null) sb.append("totalTurnover='").append(totalTurnover).append("', ");
        if (nextFundingTime != null) sb.append("nextFundingTime='").append(nextFundingTime).append("', ");
        if (fundingRate != null) sb.append("fundingRate='").append(fundingRate).append("', ");
        if (bid1Price != null) sb.append("bid1Price='").append(bid1Price).append("', ");
        if (bid1Size != null) sb.append("bid1Size='").append(bid1Size).append("', ");
        if (ask1Price != null) sb.append("ask1Price='").append(ask1Price).append("', ");
        if (ask1Size != null) sb.append("ask1Size='").append(ask1Size).append("', ");
        if (delta != null) sb.append("delta='").append(delta).append("', ");
        if (gamma != null) sb.append("gamma='").append(gamma).append("', ");
        if (vega != null) sb.append("vega='").append(vega).append("', ");
        if (theta != null) sb.append("theta='").append(theta).append("', ");
        if (deliveryTime != null) sb.append("deliveryTime='").append(deliveryTime).append("', ");
        if (basisRate != null) sb.append("basisRate='").append(basisRate).append("', ");
        if (deliveryFeeRate != null) sb.append("deliveryFeeRate='").append(deliveryFeeRate).append("', ");
        if (predictedDeliveryPrice != null) sb.append("predictedDeliveryPrice='").append(predictedDeliveryPrice).append("', ");
        if (change24h != null) sb.append("change24h='").append(change24h).append("'");

        if (sb.length() > "PublicTickerData{".length()) {
            sb.setLength(sb.length() - (sb.charAt(sb.length() - 2) == ',' ? 2 : 0)); // Remove last comma and space if present
        }
        sb.append("}");
        return sb.toString();
    }
}
