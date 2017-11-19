package com.yangqi.concurrency;

public class FirstRun {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Worker());

        thread.start();
       // thread.start();

        System.out.println("thread,status "+thread.isInterrupted());
        System.out.println(thread.interrupted());
        System.out.println("stop thread,status "+thread.isInterrupted());
        thread.interrupt();
        System.out.println("stop thread,status "+thread.isInterrupted());
        boolean s=thread.interrupted();
        System.out.println("after interrupted "+s+" "+thread.isInterrupted());
        System.out.println("after interrupted "+s+" "+thread.isInterrupted());
        //Thread.sleep(1000);
        //thread.interrupt();

    }
}
