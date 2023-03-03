package com.mercury.basic.oop;

public class InheritanceTest {

    // 1 java class can extends from at most 1 class, but able to implements multi interfaces
    // interface can extends from other interfaces, but cannot implement any
    public static class InheritancePar {
        public static void foo() {
            System.out.println("Par foo...");
        }

        public void bar() {
            System.out.println("Par bar...");
        }
    }


    public static class InheritanceSub extends InheritancePar {
        // static function cannot be extended, nor overridden

        public static void foo() {
            System.out.println("Sub foo...");
        }

        @Override
        public void bar() {
            System.out.println("Sub bar...");
        }
    }

    public static void main(String[] args) {
        // if a function cannot be found from an object
        // then search from it's reference class
        // if still not found, keep searching from its parent class
        InheritancePar par = new InheritancePar();
//        par.foo();

        InheritanceSub sub = new InheritanceSub();
        sub.foo();  // static func not accessed by a static way

        sub.bar();

        Object o;

        AccessPar ap = new AccessSub1();
        ap.f6();
    }
}
