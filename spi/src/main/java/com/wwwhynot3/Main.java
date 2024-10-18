package com.wwwhynot3;

public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = LoggerFactory.getLoggerFactory();
        Logger logger = loggerFactory.getLogger();
        logger.info("Hello, World!");
        logger.error("Hello, World!");
    }
}