/**
 * Request Parameters
 * Parameter	Required	Type	Comments
 * coin	true	string	Coin name
 * quantity	true	string	Deposit quantity
 * serialNo	false	string	Customised ID. If not passed, system will create one by default
 * Response Parameters
 * Parameter	Type	Comments
 * coin	string	Coin name
 * createdTime	string	Created timestamp (ms)
 * orderId	string	Order ID
 * quantity	string	Deposit quantity
 * serialNo	string	Serial No
 * status	string	Order status. 0: Initial, 1: Processing, 2: Success, 10: Failed
 * updatedTime	string	Updated timestamp (ms)
 */
package com.bybit.api.client.domain.c2c;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientLendingFundsRequest {
    private final String coin;
    private final String quantity;
    private final String serialNo;

    private ClientLendingFundsRequest(Builder builder) {
        this.coin = builder.coin;
        this.quantity = builder.quantity;
        this.serialNo = builder.serialNo;
    }

    public static class Builder {
        private final String coin;
        private final String quantity;
        private String serialNo;

        public Builder (String coin, String quantity) {
            this.coin = coin;
            this.quantity = quantity;
        }

        public Builder serialNo(String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public ClientLendingFundsRequest build() {
            return new ClientLendingFundsRequest(this);
        }
    }
}