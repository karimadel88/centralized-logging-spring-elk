package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String testEndpoint(@RequestParam(defaultValue = "false") boolean fail) {
        logger.info("Received request to /test endpoint with fail={}", fail);
        try {
            throw new RuntimeException("Test exception");
//            testService.performTest(fail);
//            return "Test endpoint called successfully";
        } catch (Exception e) {
            logger.error("Error occurred during test", e);
            return "Test endpoint encountered an error";
        }
    }
}