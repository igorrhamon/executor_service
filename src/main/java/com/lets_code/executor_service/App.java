package com.lets_code.executor_service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> postgreResult = executorService.submit(new Postgresql());
        Future<String> mySqlResult = executorService.submit(new MySQL());

        List<Future<String>> futures = executorService.invokeAll(List.of(new Postgresql(), new MySQL()));
        executorService.shutdown();

        futures.stream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
