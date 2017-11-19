package com.yangqi.concurrency.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Container {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<String,String>();
        concurrentHashMap.put("str1","name1");
        concurrentHashMap.put("str2","name2");

        concurrentHashMap.forEach((k,v)-> System.out.println(k+" "+v));

        concurrentHashMap.putIfAbsent("str1","name1-new");
        concurrentHashMap.remove("str1","name2");
        concurrentHashMap.forEach((k,v)-> System.out.println(k+" "+v));


        BlockingQueue<String> blockingQueue=new LinkedBlockingDeque<>(10);

        for(int i=0;i<12;i++){
            try {
                boolean add = blockingQueue.offer("String" + i,1, TimeUnit.SECONDS);
                System.out.println("size " + blockingQueue.size() + " ,add status " + add+" ,remaning size "+blockingQueue.remainingCapacity());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("for each queue");
        blockingQueue.forEach((str)-> System.out.println(str));

        for(int i=0;i<20;i++){
            try {
                String work = blockingQueue.take();
                System.out.println("size " + blockingQueue.size() + " ,work " + work);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
