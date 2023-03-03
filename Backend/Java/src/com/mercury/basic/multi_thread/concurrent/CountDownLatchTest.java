package com.mercury.basic.multi_thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static class Add extends Thread {
        int x, y;
        int res;
        CountDownLatch cdl;

        public Add(int x, int y, CountDownLatch cdl) {
            this.x = x;
            this.y = y;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("Add start...");
            try {
                Thread.sleep(x * 1000);
                res = x + y;
                cdl.countDown();
                Thread.sleep(x * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Add finish!");

        }

        public int getRes() {
            return res;
        }
    }

    public static class Mul extends Thread {
        int x, y;
        int res;
        CountDownLatch cdl;

        public Mul(int x, int y, CountDownLatch cdl) {
            this.x = x;
            this.y = y;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("Mul start...");

            try {
                Thread.sleep(y * 1000);
                res = x * y;
                cdl.countDown();
                Thread.sleep(y * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Mul finish!");

        }

        public int getRes() {
            return res;
        }
    }

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(2);
        int x = 2;
        int y = 5;

        Add a = new Add(x, y, cdl);
        Mul m = new Mul(x, y, cdl);

        a.start();
        m.start();
        System.out.println("************");

        try {
            System.out.println("main is waiting for the result");
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.getRes() - a.getRes());

    }
}
