package com.mercury.basic.multi_thread.concurrent;

import com.mercury.basic.HelloWorld;
import com.mercury.bean.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static class DummyTask implements Runnable {
        int id;

        public DummyTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ---> " + id);
        }
    }

    public static void testThreadPool() {
//        ExecutorService es = Executors.newCachedThreadPool();     // unlimited
//        ExecutorService es = Executors.newFixedThreadPool(5);   // max 5
        ExecutorService es = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 100; i++) {
            Future f = es.submit(new DummyTask(i));
        }

        es.shutdown();
    }

    public static class SmartTask implements Callable<Integer> {

        private int id;

        public SmartTask(int id) {
            this.id = id;
        }

        // n!
        public int factorial(int num) {
            if(num < 2)
                return 1;

            return factorial(num - 1) * num;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep((11 - id) * 1000);
            return factorial(id);
        }
    }

    public static void testFuture() {
        ExecutorService es = Executors.newCachedThreadPool();

        List<Future<Integer>> futureList = new ArrayList();

        for(int i = 1; i <= 10; i++) {
            Future<Integer> f = es.submit(new SmartTask(i));
            futureList.add(f);
        }

        for(Future<Integer> f : futureList) {
            while(!f.isDone()){
                // wait for the result
            }
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        es.shutdown();
    }

    public static void main(String[] args) {
        System.out.println("*************");
//        testThreadPool();
        testFuture();
    }
}
