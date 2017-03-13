package com.yangqi.gc;

/**
 * Created by yangqi on 13/03/2017.
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("I AM START");
        for(int i=0;;i++){
           String s=new String("hello "+i);
            System.out.println(s);
        }
    }
}
