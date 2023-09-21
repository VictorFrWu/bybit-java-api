package com.bybit.api.client;

import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;

public interface BybitAnnouncementRestClient {
    Object getAnnouncementInfo(AnnouncementInfoRequest announcementInfoRequest);
}
