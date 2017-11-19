package com.yangqi.concurrency.container;

import java.util.concurrent.BlockingQueue;

public class StringConsumer implements Runnable{
    private BlockingQueue<String> workline;

    public StringConsumer(BlockingQueue workline) {
        this.workline = workline;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                String workToDo=workline.take();
                System.out.println(Thread.currentThread().getName()+" Consumer consume "+workToDo+" ,size "+workline.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Consumer interputed");
                Thread.currentThread().interrupt();
            }

        }
    }
}
