package javaexamples;

import com.sun.istack.internal.NotNull;

import java.util.Map;

public class HashMapTest {


    public static void main(String[] args) throws InterruptedException {

        Map map = null;//System.getProperties();FunctionalInterface functionalInterface = ArrayList::new;


        HashMapTest hashMapTest = new HashMapTest();

        new Thread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        });

        HashMapTest h = new HashMapTest();
        h = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("End main");
    }

    @Override
    @NotNull
    protected void finalize() {
        System.out.println("finalize method called");
        System.out.println(10 / 0);
    }
}