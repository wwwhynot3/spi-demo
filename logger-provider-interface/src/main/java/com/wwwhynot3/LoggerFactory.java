package com.wwwhynot3;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class LoggerFactory {
    private final List<Logger> services;
    private Logger logger;
    private LoggerFactory() {
        services = ServiceLoader.load(Logger.class).stream().map(ServiceLoader.Provider::get).toList();
        if(!services.isEmpty()){
            logger = services.getFirst();
        }
    }
    public static LoggerFactory getLoggerFactory(){
        return new LoggerFactory();
    }
    public Logger getLogger(){
        return logger;
    }
}
