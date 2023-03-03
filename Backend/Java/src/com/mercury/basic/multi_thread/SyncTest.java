package com.mercury.basic.multi_thread;

public class SyncTest {

    // keyword : synchronized, can be added in front of a function, or code block

    // in java, every object (/ class) can be used as a lock - key/ticket
    //
    // to execute a sync function, the thread need to own the corresponding lock
    // (the class / object where the function from), then execute it

    synchronized public static void f1() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " is sleeping in f1...");
        sleep(3);
        System.out.println(name + " is awake from f1!");
    }

    synchronized public static void f2() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " is sleeping in f2...");
        sleep(3);
        System.out.println(name + " is awake from f2!");
    }

    synchronized public void f3 () {
        String name = Thread.currentThread().getName();

        System.out.println(name + " is sleeping in f3...");
        sleep(3);
        System.out.println(name + " is awake from f3!");
    }

    synchronized public void f4 () {
        String name = Thread.currentThread().getName();

        System.out.println(name + " is sleeping in f4...");
        sleep(3);
        System.out.println(name + " is awake from f4!");
    }

    public static class MyThread extends Thread {
        SyncTest st;
        @Override
        public void run() {
//            st.f4();
            f1();
        }
    }

    public static void main(String[] args) {
        SyncTest st = new SyncTest();

        MyThread mt = new MyThread();
        mt.st = st;
        mt.start();
        System.out.println("**********************");

        synchronized (SyncTest.class){
            String name = Thread.currentThread().getName();

            System.out.println(name + " is sleeping in main()...");
            sleep(3);
            System.out.println(name + " is awake from main()!");
        }
        System.out.println("*******************");

        System.out.println(SyncTest.class == st.getClass());
        System.out.println(SyncTest.class == new SyncTest().getClass());
        System.out.println(SyncTest.class == new SyncTest().getClass());


    }

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
