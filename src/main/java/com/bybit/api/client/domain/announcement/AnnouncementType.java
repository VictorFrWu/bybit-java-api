package com.bybit.api.client.domain.announcement;

import lombok.Getter;

@Getter
public enum AnnouncementType {
    NEW_CRYPTO("new_crypto"),
    LATEST_BYBIT_NEWS("latest_bybit_news"),
    DELISTINGS("delistings"),
    LATEST_ACTIVITIES("latest_activities"),
    PRODUCT_UPDATES("product_updates"),
    MAINTENANCE_UPDATES("maintenance_updates"),
    NEW_FIAT_LISTINGS("new_fiat_listings"),
    OTHER("other");

    private final String announcementType;

    AnnouncementType(String announcementType) {
        this.announcementType = announcementType;
    }
}
