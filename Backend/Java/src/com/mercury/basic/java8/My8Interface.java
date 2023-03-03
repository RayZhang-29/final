package com.mercury.basic.java8;

@FunctionalInterface
public interface My8Interface {
    // all fields : public static final
    // all functions : public + abstract(by default) || static || default

    // functional interface :
    // no matter how many static && default functions
    // as long as only 1 abstract function : toString() hashCode() equals() are not included

    void foo();

    // class level
    static void bar() {

    }

    // object level concrete function
    default void test() {

    }
}
