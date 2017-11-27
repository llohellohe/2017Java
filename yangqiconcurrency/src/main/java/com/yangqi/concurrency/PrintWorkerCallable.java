package com.yangqi.concurrency;

import java.util.Date;
import java.util.concurrent.Callable;

public class PrintWorkerCallable implements Callable {
    private int id;

    public PrintWorkerCallable(int id) {
        this.id = id;
    }

    public PrintWorkerCallable() {
    }

    public String call() {
        String result=(new Date() + " with callable" + Thread.currentThread().getName() + " id " + id);
        System.out.println(result);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("I AM INTERRUPTED");
            Thread.currentThread().interrupt();
        }
        return result;
    }
}
