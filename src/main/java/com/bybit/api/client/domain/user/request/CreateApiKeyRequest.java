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
public class CreateApiKeyRequest {

    private Integer subuid; // required
    private String note;
    private Integer readOnly; // required
    private String ips;
    private Map<String, List<String>> permissions; // required
}


