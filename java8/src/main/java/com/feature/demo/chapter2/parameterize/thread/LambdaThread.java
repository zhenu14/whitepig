package com.feature.demo.chapter2.parameterize.thread;

public class LambdaThread {
    public static void main(String[] a) throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        thread2.start();

        Thread.currentThread().join();
    }
}
