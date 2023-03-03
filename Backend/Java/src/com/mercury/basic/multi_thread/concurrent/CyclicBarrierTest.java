package com.mercury.basic.multi_thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static class MyCBThread extends Thread {

        private int id;
        private CyclicBarrier cb;

        public MyCBThread(int id, CyclicBarrier cb) {
            this.id = id;
            this.cb = cb;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " starts......");
            mySleep(id);
            System.out.println(name + " is ready!");
            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " resume!");
            mySleep(id);
            System.out.println(name + " finished!");
        }
    }

    public static void mySleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4);
        MyCBThread m1 = new MyCBThread(1, cb);
        MyCBThread m2 = new MyCBThread(2, cb);
        MyCBThread m3 = new MyCBThread(3, cb);

        m1.start();
        m2.start();
        m3.start();
        System.out.println("**********");
        mySleep(10);
        try {
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("***************************");
    }
}
