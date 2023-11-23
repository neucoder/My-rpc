package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void testMethod() {
        MDC.put("traceId", "123456");
        logger.info("hello, world");
        logger.error("{}", "error");
    }

}
