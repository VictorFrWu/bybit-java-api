package com.bybit.api.client.domain.user.request;

import com.bybit.api.client.domain.user.SubUserPermissions;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSubApiKeyRequest {
    private Integer subuid; // required
    private String note;
    private Integer readOnly; // required
    private String ips;
    @JsonProperty("permissions")
    private Map<String, List<String>> permissions; // required
}


