package com.mercury.basic.multi_thread;

public class AddMulTest {

    public static class Add extends Thread {
        int x, y;
        int res;
        volatile boolean finish;

        public Add(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            res = x + y;
            finish = true;
        }

        public int getRes() {
            return res;
        }
    }

    public static class Mul extends Thread {
        int x, y;
        int res;

        public Mul(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            res = x * y;
        }

        public int getRes() {
            return res;
        }
    }

    public static void main(String[] args) {
        // (x * y) - (x + y)
        // x * y in 1 thread
        // x + y in 1 thread
        // -  in  main

        int x = 3;
        int y = 5;

        Add a = new Add(x, y);
        Mul m = new Mul(x, y);
        a.start();
        m.start();

        while(!a.finish){}


//        try {
//            // current thread will wait for
//            // the thread created by that thread object to finish,
//            // then continue
//            a.join();
//            m.join();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println(m.getRes() - a.getRes());    // 0, 15, -8, 7
    }
}
