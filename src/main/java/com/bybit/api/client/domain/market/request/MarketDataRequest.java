package com.bybit.api.client.domain.market.request;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.announcement.AnnouncementTag;
import com.bybit.api.client.domain.announcement.AnnouncementType;
import com.bybit.api.client.domain.announcement.LanguageSymbol;
import com.bybit.api.client.domain.market.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MarketDataRequest {
    private CategoryType category; // always required
    private String coin;
    private String symbol;
    private String baseCoin;
    private String expDate;
    private InstrumentStatus instrumentStatus;
    private MarketStatus marketStatus;
    private IntervalTime marketIntervalTime;
    private MarketInterval marketInterval; // open interest interval time
    private OptionType optionType; // option only
    private Integer optionPeriod; // option only
    private DataRecordingPeriod dataRecordingPeriod;
    private Long startTime;
    private Long endTime;
    private Long start;
    private Long end;
    private Integer limit;
    private String cursor;
    private LanguageSymbol locale;
    private AnnouncementType type;
    private AnnouncementTag tag;
    @Builder.Default
    private int page = 1;
}
