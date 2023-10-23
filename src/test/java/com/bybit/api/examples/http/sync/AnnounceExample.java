package com.bybit.api.examples.http.sync;

import com.bybit.api.client.domain.announcement.LanguageSymbol;
import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class AnnounceExample {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newMarketDataRestClient();

        // Get Announcement
        var announcementInfoRequest = AnnouncementInfoRequest.builder().locale(LanguageSymbol.EN_US).build();
        var announceInfo = client.getAnnouncementInfo(announcementInfoRequest);
        System.out.println(announceInfo);
    }
}
