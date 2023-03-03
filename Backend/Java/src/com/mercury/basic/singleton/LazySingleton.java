package com.mercury.basic.singleton;

public class LazySingleton {

    private LazySingleton(){}

    private volatile static LazySingleton ls;
    private static final Object o = new Object();

    public static LazySingleton getInstance() {
        if (ls == null) {
            synchronized (o) {
                if(ls == null)
                    ls = new LazySingleton();
            }
        }

        return ls;
    }

    protected static void foo() {

    }
}
