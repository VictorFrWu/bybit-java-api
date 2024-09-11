package com.bybit.api.client.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
@Builder
public class WithdrawBeneficiaryMap {
    private final Map<String, String> beneficiaryMap;

    public WithdrawBeneficiaryMap(Map<String, String> beneficiaryMap) {
        this.beneficiaryMap = beneficiaryMap;
    }

    @JsonAnyGetter // This annotation allows the map's entries to be serialized as properties.
    public Map<String, String> getBeneficiaryMap() {
        return beneficiaryMap;
    }
}