package com.mercury.basic;

import com.mercury.bean.Employee;
import com.mercury.bean.Phone;

import java.util.ArrayList;

public class CloneTest {

    public static void main(String[] args) {
        char a = 'a';
        Object o;
        Phone p = new Phone("iPhone", 100, new ArrayList(), null);
        Employee e1 = new Employee(1, "Dave", true, p);

        // deep copy vs shallow copy

        // super.clone() will create a shallow copy
        Employee e2 = e1.clone();

        System.out.println(e1);
        System.out.println(e2);

        System.out.println(e1 == e2);
        System.out.println(e1.getId() == e2.getId());
        System.out.println(e1.getName() == e2.getName());
        System.out.println(e1.isDone() == e2.isDone());
        System.out.println(e1.getPhone() == e2.getPhone());

        Phone p2 = new Phone("iPhone", 200, new ArrayList<>(), null);
        e2.setPhone(p2);

        Employee e3 = e1;


    }
}
