package com.example.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    private static final System.Logger logger = System.getLogger(ExecutorServiceExample.class.getName());

    public static void main(String[] args) {
        // Create an ExecutorService with a single thread executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a task to the executor service
        executorService.submit(() -> {
            try {
                // Simulate a long-running task
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Shutdown the executor service
        executorService.shutdown();
    }
}
