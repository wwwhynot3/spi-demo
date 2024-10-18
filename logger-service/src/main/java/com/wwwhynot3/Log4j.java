package com.wwwhynot3;

public class Log4j implements com.wwwhynot3.Logger {
    @Override
    public void info(String message) {
        System.out.println("log4j[info]: " + message);
    }

    @Override
    public void error(String message) {
        System.out.println("log4j[error]: " + message);
    }
}
