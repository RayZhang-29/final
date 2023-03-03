package com.mercury.basic.multi_thread;

public class WaitNotifyTest {


    public static class MyWaitThread extends Thread {
        Object o;

        public MyWaitThread(Object o) {
            this.o = o;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starts and waiting...");
            synchronized (o) {
                try {
                    Thread.sleep(5000);

                    // thread hang up
                    o.wait();   // put current thread in waiting status
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("******");
        // wait(), notify(), notifyAll() should only be called from the object
        // which is used as a lock
        //
        // only in the sync environment

        Object o = new Object();
        MyWaitThread mwt = new MyWaitThread(o);


        mwt.start();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized (o) {
            o.notify();
            try {
                mwt.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mwt.notify();
        }

        System.out.println("******");
    }
}
