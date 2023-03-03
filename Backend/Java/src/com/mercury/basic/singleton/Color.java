package com.mercury.basic.singleton;

import java.io.Serializable;

public enum Color implements Runnable {
    // 枚举
    Red;

    int x = 2;
    private static final int y = 3;

    public void foo(){}

    public static final void bar() {

    }

    @Override
    public void run() {

    }
}
