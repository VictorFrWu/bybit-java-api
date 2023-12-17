package com.bybit.api.client.domain.institution.insLending;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInstitutionLoadUidRequest {
    private String uid;
    private String operate;
}
