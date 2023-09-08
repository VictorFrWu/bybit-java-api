 /*
  *   category	true	string	Product type. option
  *   baseCoin	false	string	Base coin. Default: return BTC data
  *   period	false	integer	Period
  *   startTime	false	integer	The start timestamp (ms)
  *   endTime	false	integer	The end timestamp (ms)
  *  */
 package com.bybit.api.client.domain.market.request;

 import com.bybit.api.client.domain.ProductType;
 import lombok.Getter;
 import lombok.Setter;
 import lombok.ToString;

 @Getter
 @Setter
 @ToString
 public class HistoricalVolatilityRequest {
     private ProductType category;
     private String baseCoin;
     private Integer period;
     private Long startTime;
     private Long endTime;

     private HistoricalVolatilityRequest(Builder builder) {
         this.category = builder.category;
         this.baseCoin = builder.baseCoin;
         this.period = builder.period;
         this.startTime = builder.startTime;
         this.endTime = builder.endTime;
     }

     public static class Builder {
         private final ProductType category;
         private String baseCoin;
         private Integer period;
         private Long startTime;
         private Long endTime;

         public Builder(ProductType category) {
             this.category = category;
         }

         public Builder baseCoin(String baseCoin) {
             this.baseCoin = baseCoin;
             return this;
         }

         public Builder period(Integer period) {
             this.period = period;
             return this;
         }

         public Builder startTime(Long startTime) {
             this.startTime = startTime;
             return this;
         }

         public Builder endTime(Long endTime) {
             this.endTime = endTime;
             return this;
         }

         public HistoricalVolatilityRequest build() {
             return new HistoricalVolatilityRequest(this);
         }
     }
 }
