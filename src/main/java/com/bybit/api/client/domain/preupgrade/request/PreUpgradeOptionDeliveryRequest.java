/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * category	true	string	Product type. option
 * symbol	false	string	Symbol name
 * expDate	false	string	Expiry date. 25MAR22. Default: return all
 * limit	false	integer	Limit for data size per page. [1, 50]. Default: 20
 * cursor	false	string	Cursor. Used for pagination
 */
package com.bybit.api.client.domain.preupgrade.request;

import com.bybit.api.client.domain.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PreUpgradeOptionDeliveryRequest {
    private final ProductType category;
    private final String symbol;
    private final String expDate;
    private final Integer limit;
    private final String cursor;

    private PreUpgradeOptionDeliveryRequest(Builder builder) {
        this.category = builder.category;
        this.symbol = builder.symbol;
        this.expDate = builder.expDate;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static class Builder {
        private final ProductType category;
        private String symbol;
        private String expDate;
        private Integer limit; // Default value 20
        private String cursor;

        public Builder(ProductType category) {
            this.category = category;
        }

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder expDate(String expDate) {
            this.expDate = expDate;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public PreUpgradeOptionDeliveryRequest build() {
            return new PreUpgradeOptionDeliveryRequest(this);
        }
    }
}
