package com.lets_code.executor_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException, IOException
    {
        
        ExecutorService executorService = Executors.newCachedThreadPool();

        

        List<Future<String>> results = executorService.invokeAll(
            List.of(
                new Postgresql(), 
                new MySQL(),
                new CSV(),
                new MongoDB()
            )
        );
        executorService.shutdown();
        Files.write(Path.of("result.csv"), results.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).map(s -> s + "\n").collect(Collectors.toList()));
        System.out.println("Done");


    }
}
