package com.ncsoft.dataplatform.dummies;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://logback.qos.ch/manual/configuration.html
 * 페이지를 참고하여 Logback 라이브러리를 사용하여 로깅 테스트
 *
 */
public class LogBackTest {

    private final Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    @Before
    public void setUp() {
        logger.debug("setUp");
    }

    @Test
    public void testLogBack() {
        int i = 0;
        logger.info("testLogBack");
        Assert.assertTrue("i is one", i == 0);
        logger.warn("is about to end");
    }
}
