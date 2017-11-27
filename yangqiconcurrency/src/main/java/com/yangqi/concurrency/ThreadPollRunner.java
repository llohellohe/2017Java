package com.yangqi.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPollRunner {
    public static void main(String[] args) {



       // FutureTask<String> f=new FutureTask(new Worker(),new String());

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<String>> futureList=new ArrayList<Future<String>>();
        for (int i = 0; i <= 60; i++) {
        //    executorService.submit(new PrintWorker(i));
            Callable<String>callable=new PrintWorkerCallable(i);

            FutureTask<String> futureTask=new FutureTask<String>(callable);
            //Future<String> future=
                    Future future=executorService.submit(futureTask);
            //try {
              //  System.out.println(callable.call()+" abc ");
            //} catch (Exception e) {
              //  e.printStackTrace();
            //}
            futureList.add(futureTask);
            System.out.println("future is done "+futureTask.isDone());
        }

        futureList.forEach((f)->{
            System.out.printf(""+f.isDone());
        });

        System.out.println("is terminate "+executorService.isTerminated());
        executorService.shutdown();
        System.out.println("shut down");
        System.out.println("is terminate "+executorService.isTerminated());


        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        futureList.forEach((f)->{
            System.out.println(""+f.isDone());
        });
        System.out.println("COMPLETED shutdown status "+executorService.isShutdown()+",terminate status "+executorService.isTerminated());
        executorService.shutdown();
        System.out.println("COMPLETED shutdown status "+executorService.isShutdown()+",terminate status "+executorService.isTerminated());
    }
}
