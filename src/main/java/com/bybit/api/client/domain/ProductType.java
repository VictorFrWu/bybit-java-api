package com.bybit.api.client.domain;

/**
 *  Product type. Spot,linear, inverse
 */
public enum ProductType {
    SPOT("spot"),
    LINEAR("linear"),
    INVERSE("inverse");
    private final String productTypeId;

    ProductType(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }
}
