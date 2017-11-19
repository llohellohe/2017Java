package com.yangqi.concurrency.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class StringRunner {
    public static void main(String[] args) {
        BlockingQueue<String>blockingQueue=new LinkedBlockingDeque<>(10);
        Thread thread=null;
        for(int i=0;i<100;i++){
            Thread t1=new Thread(new StringProvider(blockingQueue));
            t1.start();
            thread=t1;
        }

        for(int i=0;i<3;i++){
            Thread t1=new Thread(new StringConsumer(blockingQueue));
            t1.start();
        }


        thread.interrupt();



    }
}
