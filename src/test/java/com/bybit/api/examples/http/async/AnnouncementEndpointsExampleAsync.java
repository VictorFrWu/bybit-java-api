package com.bybit.api.examples.http.async;

import com.bybit.api.client.domain.announcement.LanguageSymbol;
import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;
import com.bybit.api.client.service.BybitApiClientFactory;

public class AnnouncementEndpointsExampleAsync {
    public static void main(String[] args) {
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance();
        var client = factory.newAsyncMarketDataRestClient();

        // Get Announcement
        var announcementInfoRequest = AnnouncementInfoRequest.builder().locale(LanguageSymbol.EN_US).build();
        client.getAnnouncementInfo(announcementInfoRequest, System.out::println);
    }
}
