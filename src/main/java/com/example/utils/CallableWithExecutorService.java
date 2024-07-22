package com.example.utils;

import java.util.Random;
import java.util.concurrent.*;

public class CallableWithExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = () -> {
            // Simulate some computation by sleeping
            TimeUnit.SECONDS.sleep(2);
            return new Random().nextInt(10);
        };

        Future<Integer> future = executorService.submit(callableTask);

        // Do some operations while the callable is executing

        // Retrieve the result of the computation
        Integer result = future.get();
        System.out.println("Result from callable: " + result);

        // Don't forget to shut down the executor service
        executorService.shutdown();
    }
}
