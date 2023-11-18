package com.bybit.api.client.domain.position.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModifyMarginRequest {
    private String category;
    private String symbol;
    private String margin;
    private Integer positionIdx;
}

