package com.bybit.api.client.domain.announcement.request;

import com.bybit.api.client.domain.announcement.AnnouncementTag;
import com.bybit.api.client.domain.announcement.AnnouncementType;
import com.bybit.api.client.domain.announcement.LanguageSymbol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AnnouncementInfoRequest {
    private LanguageSymbol locale;
    private AnnouncementType type;
    private AnnouncementTag tag;
    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int limit = 20;
}

