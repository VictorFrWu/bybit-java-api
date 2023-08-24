package com.bybit.api.client.domain.trade;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base request parameters for order-related methods.
 */

public class OrderRequest {
    private final ProductType category;

    public OrderRequest(ProductType category) {
        this.category = category;
    }


    public ProductType getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("category", category)
                .toString();
    }
}
