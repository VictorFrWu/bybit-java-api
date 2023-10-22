package com.bybit.api.client.domain.announcement;

import lombok.Getter;

@Getter
public enum AnnouncementTag {
    SPOT("Spot"),
    DERIVATIVES("Derivatives"),
    SPOT_LISTINGS("Spot Listings"),
    BTC("BTC"),
    ETH("ETH"),
    TRADING_BOTS("Trading Bots"),
    USDC("USDC"),
    LEVERAGED_TOKENS("Leveraged Tokens"),
    USDT("USDT"),
    MARGIN_TRADING("Margin Trading"),
    PARTNERSHIPS("Partnerships"),
    LAUNCHPAD("Launchpad"),
    UPGRADES("Upgrades"),
    BYVOTES("ByVotes"),
    DELISTINGS("Delistings"),
    VIP("VIP"),
    FUTURES("Futures"),
    INSTITUTIONS("Institutions"),
    OPTIONS("Options"),
    WEB3("WEB3"),
    COPY_TRADING("Copy Trading"),
    EARN("Earn"),
    BYBIT_SAVINGS("Bybit Savings"),
    DUAL_ASSET("Dual Asset"),
    LIQUIDITY_MINING("Liquidity Mining"),
    SHARK_FIN("Shark Fin"),
    LAUNCHPOOL("Launchpool"),
    NFT_GRAB_PIC("NFT GrabPic"),
    BUY_CRYPTO("Buy Crypto"),
    P2P_TRADING("P2P Trading", "P2P"),
    FIAT_DEPOSIT("Fiat Deposit"),
    CRYPTO_DEPOSIT("Crypto Deposit");

    private final String englishTranslation;
    private final String[] otherTranslations;

    AnnouncementTag(String englishTranslation, String... otherTranslations) {
        this.englishTranslation = englishTranslation;
        this.otherTranslations = otherTranslations;
    }
}
