package com.bybit.api.client.domain;

import lombok.Getter;

/**
 *  Product type. Spot,linear, inverse
 */
@Getter
public enum ProductType {
    SPOT("spot"),
    LINEAR("linear"),
    INVERSE("inverse"),
    OPTION("option");
    private final String productTypeId;

    ProductType(String productTypeId) {
        this.productTypeId = productTypeId;
    }

}
