package com.bybit.api.client.domain.announcement.request;

import com.bybit.api.client.domain.announcement.AnnouncementTag;
import com.bybit.api.client.domain.announcement.AnnouncementType;
import com.bybit.api.client.domain.announcement.LanguageSymbol;
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
public class AnnouncementInfoRequest {
    private LanguageSymbol locale;
    private AnnouncementType type;
    private AnnouncementTag tag;
    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int limit = 20;
}

