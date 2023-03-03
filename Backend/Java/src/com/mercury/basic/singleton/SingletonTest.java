package com.mercury.basic.singleton;

import com.mercury.bean.Student;

public class SingletonTest {
    public static void main(String[] args) {
        EagerSingleton es1 = EagerSingleton.getInstance();
        EagerSingleton es2 = EagerSingleton.getInstance();

        paint(Color.Red);

        Color.bar();
        Color.Red.foo();

        LazySingleton.foo();

//        es1.finalize();
    }

    public static void paint(Color color) {
        System.out.println(color);
    }
}
