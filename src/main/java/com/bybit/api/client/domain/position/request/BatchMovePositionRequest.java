package com.bybit.api.client.domain.position.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchMovePositionRequest {
    private String fromUid;
    private String toUid;
    private List<MovePositionDetailsRequest> list;
}
