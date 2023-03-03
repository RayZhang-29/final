package com.mercury.basic.multi_thread;

// 2 or more thread holding each other's resource without releasing, then all stuck
public class DeadLock {

    public static class MyDL extends Thread{
        private Object o1, o2;

        public MyDL(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            synchronized (o1) {
                System.out.println(name + " get " + o1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(name + " get " + o2);
                    System.out.println(name + " release " + o2);
                }
                System.out.println(name + " release " + o1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("************");
        Object o1 = new Object();
        Object o2 = new Object();

        MyDL m1 = new MyDL(o1, o2);
        MyDL m2 = new MyDL(o2, o1);

        m1.start();
        m2.start();
    }
}
