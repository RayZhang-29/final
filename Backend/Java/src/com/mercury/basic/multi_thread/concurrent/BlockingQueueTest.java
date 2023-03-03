package com.mercury.basic.multi_thread.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static class Producer extends Thread {
        BlockingQueue<Integer> bq;

        public Producer(BlockingQueue bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            for(int i = 1; i <= 100; i++) {
                try {
                    bq.put(i);
                    System.out.println("Producing: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer extends Thread {
        BlockingQueue<Integer> bq;

        public Consumer(BlockingQueue bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);

                while(!bq.isEmpty()) {
                    int next = bq.take();
                    System.out.println("---> Consuming: " + next);
                    Thread.sleep(3000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(5);
        Producer p = new Producer(bq);
        Consumer c = new Consumer(bq);

        System.out.println("*************");

        p.start();
        c.start();
    }

    abstract static class Par {

    }


    static class Sub extends Par {

        public Sub() {
            super();
        }
    }
}
