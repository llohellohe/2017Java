package com.yangqi.concurrency.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Graunt extends Thread {

    private CyclicBarrier barrier = null;

    private static AtomicInteger nextId  = new AtomicInteger();

    private int                  id      = 0;

    public Graunt(CyclicBarrier barrier) {
        id = nextId.incrementAndGet();
        this.barrier = barrier;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Gruant " + id + " is waiting");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Gruant " + id + " is attacking");
    }
}
