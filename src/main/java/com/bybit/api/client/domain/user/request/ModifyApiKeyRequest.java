package com.bybit.api.client.domain.user.request;

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
public class ModifyApiKeyRequest {
    private Integer readOnly;
    private String ips;
    private String apikey;
    private Map<String, List<String>> permissionsMap;
}
