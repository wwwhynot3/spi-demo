package com.wwwhynot3;

public class LogBack implements com.wwwhynot3.Logger {
    @Override
    public void info(String message) {
        System.out.println("logback[info]: " + message);
    }

    @Override
    public void error(String message) {
        System.out.println("logback[error]: " + message);
    }
}
