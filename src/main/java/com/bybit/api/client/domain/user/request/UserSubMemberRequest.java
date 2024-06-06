package com.bybit.api.client.domain.user.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSubMemberRequest {
    private String username;
    private String password;
    private int memberType;
    @JsonProperty("switch")
    private int switchOption;
    @JsonProperty("isUta")
    private Boolean isUta;
    private String note;
}
