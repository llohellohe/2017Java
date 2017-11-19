package com.yangqi.concurrency;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class SimpleWorker implements Runnable {

    private CountDownLatch startLatch;

    private CountDownLatch endLatch;

    public SimpleWorker(CountDownLatch startLatch, CountDownLatch endLatch) {
        this.startLatch = startLatch;
        this.endLatch = endLatch;
    }

    public void run() {
        try {
            startLatch.await();
        } catch (Exception e) {

        }

        try {
            System.out.println(Thread.currentThread().getName() + " " + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I AM INTERRUPTED");
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {

        } finally {
            endLatch.countDown();
        }
    }
}
