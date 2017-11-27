package com.yangqi.concurrency;

import java.util.Date;

public class PrintWorker implements Runnable {
    private int id;

    public PrintWorker(int id) {
        this.id = id;
    }

    public PrintWorker() {
    }

    public void run() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " id " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("I AM INTERRUPTED");
            Thread.currentThread().interrupt();
        }
    }
}
