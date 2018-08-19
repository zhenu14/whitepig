package com.example.demo.thread.chapter1;

import lombok.Data;

public class ProtectTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("我离开thread对象也不再打印了，也就是停止了！");
    }

    @Data
    public static class MyThread extends Thread{
        private int i = 0;
        @Override
        public void run(){
            try {
                while (true) {
                    i++;
                    System.out.println("i = " + i);
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
