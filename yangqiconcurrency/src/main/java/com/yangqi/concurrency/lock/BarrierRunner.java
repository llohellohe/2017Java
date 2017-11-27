package com.yangqi.concurrency.lock;

import java.util.concurrent.CyclicBarrier;

public class BarrierRunner {
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(10);
        for(int i =0;i<10;i++){
            Graunt g=new Graunt(barrier);
            g.start();
        }
    }
}
