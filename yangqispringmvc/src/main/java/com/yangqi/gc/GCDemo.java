package com.yangqi.gc;

/**
 * Created by yangqi on 13/03/2017.
 */
public class GCDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I AM START");
        for(int i=0;i<100;i++) {
            byte[] b = new byte[1024 * 1024 * 8];
            byte[] b2 = new byte[1024 * 1024 * 5];
            byte[] b3 = new byte[1024 * 1024 * 3];
            byte[] b4 = new byte[1024 * 1024 * 4];
            byte[] b5 = new byte[1024 * 1024 * 4];
            byte[] b6 = new byte[1024 * 1024 * 4];
            byte[] b7 = new byte[1024 * 1024 * 16];
            byte[] b8 = new byte[1024 * 1024 * 8];
        }
    }

}
