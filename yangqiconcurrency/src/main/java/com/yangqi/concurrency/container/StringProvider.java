package com.yangqi.concurrency.container;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class StringProvider implements Runnable{

    private BlockingQueue<String> workline;

    public StringProvider(BlockingQueue<String> workline) {
        this.workline = workline;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            String work = Thread.currentThread().getName() + " " + (new Date());
            try {
                System.out.println("work "+work);
                workline.put(work);
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
