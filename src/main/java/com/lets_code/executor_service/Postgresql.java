package com.lets_code.executor_service;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class Postgresql implements Callable<String> {
    @Override
    public String call() throws Exception {
        
        String resultString = "Postgresql: " + LocalDateTime.now();
        return resultString;
    }
    
}
