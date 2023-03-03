package com.mercury.basic.multi_thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static class MyL extends Thread{
        private Lock l1, l2;

        public MyL(Lock l1, Lock l2) {
            this.l1 = l1;
            this.l2 = l2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            if(l1.tryLock()) {
                System.out.println(name + " get " + l1);
                if (l2.tryLock()) {
                    System.out.println(name + " get " + l2);
                    System.out.println(name + " release " + l2);
                    l2.unlock();
                } else {
                    System.out.println(name + " cannot get " + l2);
                }
                System.out.println(name + " release " + l1);
                l1.unlock();
            } else {
                System.out.println(name + " cannot get " + l1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("************");
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        MyL m1 = new MyL(l1, l1);
//        MyL m2 = new MyL(l2, l1);

        m1.start();
//        m2.start();
    }
}
