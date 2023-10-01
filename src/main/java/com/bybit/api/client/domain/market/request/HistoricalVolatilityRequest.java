 /*
Request Parameters
Parameter	Required	Type	Comments
category	true	string	Product type. option
baseCoin	false	string	Base coin. Default: return BTC data
period	false	integer	Period
startTime	false	integer	The start timestamp (ms)
endTime	false	integer	The end timestamp (ms)
Response Parameters
Parameter	Type	Comments
category	string	Product type
list	array	Object
> period	integer	Period
> value	string	Volatility
> time	string	Timestamp (ms)
  *  */
 package com.bybit.api.client.domain.market.request;

 import com.bybit.api.client.domain.ProductType;
 import lombok.Builder;
 import lombok.Getter;
 import lombok.Setter;
 import lombok.ToString;

 @Getter
 @Setter
 @ToString
 @Builder
 public class HistoricalVolatilityRequest {
     private ProductType category;
     private String baseCoin;
     private Integer period;
     private Long startTime;
     private Long endTime;
 }
