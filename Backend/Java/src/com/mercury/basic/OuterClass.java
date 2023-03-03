package com.mercury.basic;

public class OuterClass {

    // static func
    // non-static func

    // static inner class can be used as an outer class
    public static class InnerClass1 {
        public static void a() {

        }

        public void b() {

        }
    }

    // static function cannot exists in a non-static inner class
    public class InnerClass2 {
        public void d() {

        }
    }

}
