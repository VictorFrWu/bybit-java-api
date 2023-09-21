package com.bybit.api.client.domain.announcement;

import lombok.Getter;

@Getter
public enum LanguageSymbol {
    DE_DE("de-DE"),
    EN_US("en-US"),
    ES_AR("es-AR"),
    ES_ES("es-ES"),
    ES_MX("es-MX"),
    FR_FR("fr-FR"),
    KK_KZ("kk-KZ"),
    ID_ID("id-ID"),
    UK_UA("uk-UA"),
    JA_JP("ja-JP"),
    RU_RU("ru-RU"),
    TH_TH("th-TH"),
    PT_BR("pt-BR"),
    TR_TR("tr-TR"),
    VI_VN("vi-VN"),
    ZH_TW("zh-TW"),
    AR_SA("ar-SA"),
    HI_IN("hi-IN"),
    FIL_PH("fil-PH");

    private final String languageSymbol;

    LanguageSymbol(String languageSymbol) {
        this.languageSymbol = languageSymbol;
    }
}
