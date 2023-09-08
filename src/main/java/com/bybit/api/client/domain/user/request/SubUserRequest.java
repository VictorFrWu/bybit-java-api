package com.bybit.api.client.domain.user.request;

import com.bybit.api.client.constant.BybitApiConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
@ToString
public class SubUserRequest {

    private final String username; // required
    private final String password;
    private final Integer memberType; // required
    private final Integer switchOption;
    private final Boolean isUta;
    private final String note;

    private SubUserRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.memberType = builder.memberType;
        this.switchOption = builder.switchOption;
        this.isUta = builder.isUta;
        this.note = builder.note;
    }

    public static class Builder {
        private final String username;
        private String password;
        private final Integer memberType;
        private Integer switchOption;
        private Boolean isUta;
        private String note;

        public Builder(String username, Integer memberType) {
            this.username = username;
            this.memberType = memberType;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder switchOption(Integer switchOption) {
            this.switchOption = switchOption;
            return this;
        }

        public Builder isUta(Boolean isUta) {
            this.isUta = isUta;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public SubUserRequest build() {
            return new SubUserRequest(this);
        }
    }
}

