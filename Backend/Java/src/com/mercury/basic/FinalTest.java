package com.mercury.basic;

import com.mercury.bean.Employee;
import com.mercury.bean.Phone;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    // final is a java keyword
    // can be added in front of a class / method / variable
    // final class cannot be extended
    // final function cannot be overridden
    // final variable cannot be changed / reassigned

    // assign value to a static final field

    // 1. assign when define
    static final int X = 1;

    // 2. assign in static block
    static final int Y;

    static {
        // static block will be executed during class initialization
        Y = 2;
        System.out.println(123);
    }

    // assign value to a non-static final field

    // 1. assign when define
    final int m = 1;

    // 2. assign in block
    final int n;

    {   // block will be executed during the object inialization
        n = 2;
    }

    // 3. assign in all constructors
    final int k;

    public FinalTest() {
        k = 3;
    }

    public FinalTest(int x) {
        k = 4;
    }

    public static void main(String[] args) {
        Employee e = new Employee(1);
        e.setId(2);
        System.out.println(e);

        e.setId(3);
        System.out.println(e);

        System.out.println("************");

        List<String> info = new ArrayList<>();
        info.add("THis is a");
        info.add("brand new phone");

        Phone p = new Phone("iPhone", 500, info, new Employee(1));
        p.finalize();
        p.finalize();

        System.out.println(p);

        p.getEmployee().setId(2);

        System.out.println(p);

//        Phone p2 = new Phone.MyPhone();
//        System.out.println(p2.getPrice());
//        System.out.println(p2.getPrice());

        Employee e1 = new Employee();
        Employee e2 = new Employee();
        System.out.println(e1 == e2);


    }

}
