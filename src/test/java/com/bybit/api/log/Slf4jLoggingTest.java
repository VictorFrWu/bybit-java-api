package com.bybit.api.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.api.client.service.BybitApiServiceGenerator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Slf4jLoggingTest {

    private ListAppender<ILoggingEvent> listAppender;

    @Before
    public void setup() {
        // Get Logback Logger
        Logger logger = (Logger) LoggerFactory.getLogger(BybitApiServiceGenerator.class);

        // Create and start a ListAppender
        listAppender = new ListAppender<>();
        listAppender.start();

        // Add the appender to the logger
        logger.addAppender(listAppender);
    }

    @Test
    public void testInterceptorLogsHeaders() {
        // Trigger the logging
        BybitApiConfig.useSlf4j = true;
        BybitApiClientFactory.newInstance(BybitApiConfig.TESTNET_DOMAIN, true)
                .newMarketDataRestClient().getServerTime();

        // Get captured log events
        List<ILoggingEvent> logsList = listAppender.list;

        // Assertions to ensure the headers were logged
        assertTrue("Log entry should contain header title",
                logsList.stream().anyMatch(event -> event.getFormattedMessage().contains("--- request header ---")));
        assertTrue("Log entry should contain Content-Type header",
                logsList.stream().anyMatch(event -> event.getFormattedMessage().contains("content-type: application/json; charset=utf-8")));
    }
}

