package com.mercury.basic.oop;

import java.util.ArrayList;
import java.util.List;

public class AbstractionTest {

    // abstract - concrete

    abstract public static class AbPar {

        // abstract function - function without implementation
        abstract public void foo();

        public void bar() {
            System.out.println("Par bar..");

            new AbSub();
        }
    }

    public static class AbSub extends AbPar implements MyInterface {

        @Override
        public void foo(){

        }

        @Override
        public void test() {

        }

        @Override
        public void test2() {

        }
    }

    abstract public static class AbGrandSub extends AbSub {

    }

    public static void main(String[] args) {
        AbSub abSub = new AbSub();
        List l = new ArrayList();

    }
}
