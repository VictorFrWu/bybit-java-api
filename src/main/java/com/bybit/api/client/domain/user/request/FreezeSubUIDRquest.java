package com.bybit.api.client.domain.user.request;

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
public class FreezeSubUIDRquest {
    private Integer subuid; // required
    private Integer frozen; // required 0：unfreeze, 1：freeze
}
