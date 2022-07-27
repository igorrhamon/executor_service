package com.lets_code.executor_service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class CSV implements Callable<String> {
    @Override
    public String call() throws Exception {
        String resultString = "CSV: " + LocalDateTime.now();
        final List<String> linhas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            linhas.add("CSV line " + i);
        }
        Thread.sleep(15000);
        return "CSV: " + LocalDateTime.now() + ": \n" + linhas.stream().collect(Collectors.joining("\n"));
    }
    
}
