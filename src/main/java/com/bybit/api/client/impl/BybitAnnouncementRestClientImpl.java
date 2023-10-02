package com.bybit.api.client.impl;

import com.bybit.api.client.BybitAnnouncementRestClient;
import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;
import com.bybit.api.client.BybitApiService;
import lombok.Getter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

@Getter
public class BybitAnnouncementRestClientImpl implements BybitAnnouncementRestClient {
    private final BybitApiService bybitApiService;

    public BybitAnnouncementRestClientImpl() {
        bybitApiService = createService(BybitApiService.class);
    }
    @Override
    public Object getAnnouncementInfo(AnnouncementInfoRequest announcementInfoRequest) {
        return executeSync(bybitApiService.getAnouncementInfo(
                announcementInfoRequest.getLocale() == null ? null : announcementInfoRequest.getLocale().getLanguageSymbol(),
                announcementInfoRequest.getType() == null ? null : announcementInfoRequest.getType().getAnnouncementType(),
                announcementInfoRequest.getTag() == null ? null : announcementInfoRequest.getTag().getEnglishTranslation(),
                announcementInfoRequest.getPage(),
                announcementInfoRequest.getLimit()
        ));
    }

}
