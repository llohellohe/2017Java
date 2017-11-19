package com.yangqi.classloader;

/**
 * Created by yangqi on 12/06/2017.
 */
public class CLMain {
    public static void main(String[] args) {
        System.out.println("EXT DIR"+System.getProperty("java.ext.dirs"));
        System.out.println("CLASS PATH"+System.getProperty("java.class.path"));
        ClassLoader cl=ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        System.out.println("parent is "+cl.getParent());
        System.out.println("parent's parent is "+cl.getParent().getParent());
    }
}
