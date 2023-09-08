package com.bybit.api.client.domain.user.request;

import com.bybit.api.client.constant.BybitApiConstants;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
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
        private String username;
        private String password;
        private Integer memberType;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("username", username)
                .append("password", password)
                .append("memberType", memberType)
                .append("switchOption", switchOption)
                .append("isUta", isUta)
                .append("note", note)
                .toString();
    }
}

