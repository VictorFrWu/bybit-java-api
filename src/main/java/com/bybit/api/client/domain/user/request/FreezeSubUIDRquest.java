package com.bybit.api.client.domain.user.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreezeSubUIDRquest {
    private Integer subuid; // required
    private Integer frozen; // required 0：unfreeze, 1：freeze

    public FreezeSubUIDRquest(Integer subuid, Integer frozen) {
        this.subuid = subuid;
        this.frozen = frozen;
    }
}
