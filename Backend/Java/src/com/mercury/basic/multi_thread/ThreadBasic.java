package com.mercury.basic.multi_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadBasic {
    // Thread class - Thread, and all its sub classes
    // thread object - object of thread class
    // thread : can only be started from a thread object


    // which is better?

    // 1. create a class extends Thread, override the run(), start a thread from its object
    // 2. create a class implements Runnable, override the run(),
    //    start a thread from a thread object

    public static class MyThread extends Thread {
        @Override
        public void run() {
            // define logic for the new thread
            String name = Thread.currentThread().getName();
            System.out.println(name);
            try {
                System.out.println(name + " is sleeping...");
                Thread.sleep(3000);
                System.out.println(name + " wakes up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        // as long as a non-daemon thread is in running, JVM will hold
        // daemon thread : if JVM only have daemon thread, then JVM will shut down
        MyThread mt = new MyThread();
        mt.setDaemon(true);
//        mt.run();   // execute by current thread
        mt.start();     // create a new thread, and ask it to execute the run()

        MyRunnable mr = new MyRunnable();
//        mr.run();
        new Thread(mr).start();

        System.out.println("*****************");
        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
        FutureTask ft = new FutureTask(c);
        new Thread(ft).start();

        while(!ft.isDone()) {}

        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
