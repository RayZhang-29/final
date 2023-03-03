package com.mercury.basic.java8;

import com.mercury.bean.Employee;

public class LambdaExpressionTest {

    public static void main(String[] args) {
        // Lambda Expression:
        // a shorten way than anonymous implementation
        // to create an object from a functional interface

        My8Interface mi = new My8Interface() {
            @Override
            public void foo() {
                System.out.println("Anonymous impl of MI");
            }
        };

        My8Interface mi2 = () -> {
                System.out.println("Anonymous impl of MI" );
            }
        ;

        A a0 = new A() {
            @Override
            public void foo() {
                System.out.println(123);
            }
        };

        A a = () -> System.out.println(123);
        B b = () -> 1;
        C c = x -> x;
        D d = (y, x) -> 1;

        bar(new A() {
            @Override
            public void foo() {
                System.out.println(89);
            }
        });
    }

    public static void bar(A a) {

    }

    public interface A{void foo();}
    public interface B{int foo();}
    public interface C{int foo(int x);}
    public interface D{int foo(int x, String y);}
}
