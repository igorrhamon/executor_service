package com.lets_code.executor_service;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MongoDB implements Callable<String> {
    @Override
    public String call() throws Exception {
        
        String resultString = "MongoDB: " + LocalDateTime.now();
        return resultString;
    }
    
}
