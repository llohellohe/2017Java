package com.yangqi.concurrency;

import java.util.Date;

public class Worker implements Runnable {
    private int id;

    public Worker(int id) {
        this.id = id;
    }
    public Worker() {
    }

    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println(new Date()+" "+Thread.currentThread().getName()+" id "+id);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("I AM INTERRUPTED");
                Thread.currentThread().interrupt();
            }
        }
    }
}
