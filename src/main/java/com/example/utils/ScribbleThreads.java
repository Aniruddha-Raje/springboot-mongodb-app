package com.example.utils;

import java.util.concurrent.Callable;

public class ScribbleThreads {
    public static void main(String[] args) {
        TestThread t = new TestThread();
        t.start();

        TestRunnable ob1 = new TestRunnable();
        TestCallable ob2 = new TestCallable();

        Thread tr = new Thread(ob1);
        tr.start();

    }
}

class TestThread extends Thread {
    public void run(){
        System.out.println("Thread running");
    }
}

class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Run called");
    }
}

class TestCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return "Callable called";
    }
}
