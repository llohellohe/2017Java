package com.yangqi.concurrency;

import java.util.Date;

public class Worker implements Runnable {

    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I AM INTERRUPTED");
                Thread.currentThread().interrupt();
            }
        }
    }
}
