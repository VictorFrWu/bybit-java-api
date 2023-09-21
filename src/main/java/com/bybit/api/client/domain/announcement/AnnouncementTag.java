package com.bybit.api.client.domain.announcement;

import lombok.Getter;

@Getter
public enum AnnouncementTag {
    SPOT("Spot", "Спот"),
    DERIVATIVES("Derivatives", "Деривативы"),
    SPOT_LISTINGS("Spot Listings", "Спот лістинги"),
    BTC("BTC"),
    ETH("ETH"),
    TRADING_BOTS("Trading Bots", "Торгові боти", "Торговые боты"),
    USDC("USDC"),
    LEVERAGED_TOKENS("Leveraged Tokens", "Токени з кредитним плечем"),
    USDT("USDT"),
    MARGIN_TRADING("Margin Trading", "Маржинальна торгівля"),
    PARTNERSHIPS("Partnerships", "Партнерство"),
    LAUNCHPAD("Launchpad"),
    UPGRADES("Upgrades", "Оновлення"),
    BYVOTES("ByVotes"),
    DELISTINGS("Delistings", "Делістинги", "Делистинг"),
    VIP("VIP"),
    FUTURES("Futures", "Ф'ючерси"),
    INSTITUTIONS("Institutions"),
    OPTIONS("Options", "Опціони"),
    WEB3("WEB3"),
    COPY_TRADING("Copy Trading", "Копітрейдинг", "Копитрейдинг"),
    EARN("Earn"),
    BYBIT_SAVINGS("Bybit Savings", "Bybit Накопичення"),
    DUAL_ASSET("Dual Asset", "Бівалютні інвестиції"),
    LIQUIDITY_MINING("Liquidity Mining", "Майнінг ліквідності"),
    SHARK_FIN("Shark Fin"),
    LAUNCHPOOL("Launchpool"),
    NFT_GRAB_PIC("NFT GrabPic"),
    BUY_CRYPTO("Buy Crypto", "Купівля криптовалюти"),
    P2P_TRADING("P2P Trading", "P2P торгівля", "P2P"),
    FIAT_DEPOSIT("Fiat Deposit", "Фіатні депозити"),
    CRYPTO_DEPOSIT("Crypto Deposit", "Криптодепозити");

    private final String englishTranslation;
    private final String[] otherTranslations;

    AnnouncementTag(String englishTranslation, String... otherTranslations) {
        this.englishTranslation = englishTranslation;
        this.otherTranslations = otherTranslations;
    }
}
