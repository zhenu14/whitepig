package com.thread.demo.chapter1;

public class Run {
    public static void main(String[] args){
        try{
            MyThread thread = new MyThread();
//            Thread t1 = new Thread(thread);
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static class MyThread extends Thread{
        private int i = 5;

        public MyThread(){
            System.out.println("构造方法打印:" + Thread.currentThread().getName());
        }

        @Override
        public void run(){
            super.run();
            for (int i = 0;i < 500000;i++){
                if(this.isInterrupted()){
                    System.out.println("this.isInterrupted() 1 " + this.isInterrupted());
                    System.out.println("this.isInterrupted() 2 " + this.isInterrupted());
                    System.out.println("已经是停止状态了！退出");
                    return;
                }
                System.out.println("i = " + i);
            }
            System.out.println("for语句外");
        }
    }
}
