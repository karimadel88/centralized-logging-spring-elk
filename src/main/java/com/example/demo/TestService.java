package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    public void performTest(boolean shouldFail) {
        logger.debug("Starting performTest with shouldFail={}", shouldFail);
        logger.info("Performing test");
        if (shouldFail) {
            logger.warn("About to fail as requested");
            throw new RuntimeException("Simulated failure");
        }
        logger.info("Test performed successfully");
    }
}