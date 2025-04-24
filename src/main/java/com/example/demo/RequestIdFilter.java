package com.example.demo;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class RequestIdFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RequestIdFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.debug("Set requestId in MDC: {}", requestId);
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("requestId");
            logger.debug("Removed requestId from MDC");
        }
    }
}