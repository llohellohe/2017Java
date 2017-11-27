package com.yangqi.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorRunner {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,5,1000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());


        for(int i=0;i<=100;i++){
            Callable<String> callable=new PrintWorkerCallable(i);
            try {
                threadPoolExecutor.submit(callable);
            }catch (Exception e){
                System.out.println("abort "+e);
            }
        }
    }
}
