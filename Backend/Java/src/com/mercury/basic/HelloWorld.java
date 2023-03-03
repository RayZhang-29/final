package com.mercury.basic;

import com.mercury.basic.singleton.Color;

import java.util.LinkedList;

public class HelloWorld {

    static {
        System.out.println(123);
        System.out.println(123);
        System.out.println(123);
    }

    // what is it?
    // How / why - detail

    // steps of new:
    // 1. find the class from all loaded class (meta space)
    // 2. allocate a piece of memory for the obj
    // 3. create obj
    // 4. call constructor to initialize the obj
    // 5. return the address

    // static is a keyword
    // can be added in front of field, function, inner class, block - all available element
    // to make it class level

    // non-static : object level

    public static void main(String[] args) {
        String str = new String("Hello World!");
        System.out.println(str);

        System.out.println(123);

        foo();

        HelloWorld hw = new HelloWorld();
        hw.bar();

        System.out.println(y);


        OuterClass.InnerClass1 ic1 = new OuterClass.InnerClass1();

        OuterClass oc = new OuterClass();

        // do not search the class from meta space, search it from the object
        OuterClass.InnerClass2 ic2 = oc.new InnerClass2();

        LinkedList ll;

        Class clazz = oc.getClass();
        OuterClass oc2 = new OuterClass();
        Class clazz2 = oc2.getClass();


    }


    // modifiers + return + function name (params / args) {function body}
    static public void foo(){
        System.out.println(123);
    }

    public void bar() {
        foo();
    }

    public void test() {
        bar();
    }

    int x = 1;
    static int y = 2;
}
