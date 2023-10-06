package com.bybit.api.client.domain.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserSubMemberRequest {
    private String username;
    private String password;
    private int memberType;
    private int switchOption;
    private boolean isUta;
    private String note;
}
