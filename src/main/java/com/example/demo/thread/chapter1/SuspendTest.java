package com.example.demo.thread.chapter1;

import lombok.Data;

public class SuspendTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);

        thread.suspend();
        System.out.println(" A = " + System.currentTimeMillis() + " i = " + thread.getI());
        Thread.sleep(1000);
        System.out.println(" A = " + System.currentTimeMillis() + " i = " + thread.getI());

        thread.resume();
        Thread.sleep(1000);

        thread.suspend();
        System.out.println(" B = " + System.currentTimeMillis() + " i = " + thread.getI());
        Thread.sleep(1000);
        System.out.println(" B = " + System.currentTimeMillis() + " i = " + thread.getI());
    }

    @Data
    public static class MyThread extends Thread{
        private long i = 0;
        @Override
        public void run(){
            while (true){
                i++;
            }
        }
    }
}
