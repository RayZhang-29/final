package com.mercury.basic.singleton;

import java.io.Serializable;

public class EagerSingleton implements Serializable {
    // 1. private all constructors
    private EagerSingleton(){}

    // 2. create a field to hold the singleton instance
    private static EagerSingleton es = new EagerSingleton();

    // 3. provide a getInstance() to return the singleton instance
    public static EagerSingleton getInstance() {
        return es;
    }

    // 4. should not provide any functions to create a new object
//    public EagerSingleton foo() {
//        return new EagerSingleton();
//    }


}
