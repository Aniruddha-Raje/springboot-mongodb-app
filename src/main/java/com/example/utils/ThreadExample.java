package com.example.utils;

// Implementing the Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running by implementing Runnable");
    }
}

// Extending the Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running by extending Thread");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Creating a thread using the Runnable interface
        Runnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Creating a thread by extending the Thread class
        Thread thread2 = new MyThread();
        thread2.start();
    }
}
