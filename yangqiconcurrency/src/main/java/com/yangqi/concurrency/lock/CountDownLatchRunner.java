package com.yangqi.concurrency.lock;

import com.yangqi.concurrency.SimpleWorker;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunner {

    private static CountDownLatch startLatch = new CountDownLatch(1);

    private static CountDownLatch endLatch;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int threadNum = 100;

        endLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            Thread t = new Thread(new SimpleWorker(startLatch, endLatch));
            t.start();
        }
        long initThreadEnd = System.currentTimeMillis();
        System.out.println("init thread use " + (initThreadEnd - start)+new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startLatch.countDown();


        try {
            endLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(threadNum + " use " + (end - start));

    }
}
