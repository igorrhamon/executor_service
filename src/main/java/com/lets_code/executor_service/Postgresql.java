package com.lets_code.executor_service;

import java.util.concurrent.Callable;

public class Postgresql implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Postgresql";
    }
    
}
