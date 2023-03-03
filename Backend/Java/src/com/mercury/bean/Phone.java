package com.mercury.bean;

import com.mercury.basic.CloneTest;

import java.util.*;
import java.util.concurrent.Executors;

// immutable:
// 1. only getters, no setters
// 2. provide constructor to assign value
// 3. for list, set, map,  use Collections.unmodifiableList/Set/Map() to make the field immutable
// 4. for the field with a customized class type, make sure it is immutable
// 5. should not provide any function that can modify the object
// 6. final the class, so no weird overriden function with funny logic exists

// 7. in java, no immutable class
public final class Phone {
    private String brand;
    private int price;
    private List<String> info;
    private final Employee employee;

    public Phone() {
        brand = "N/A";
        employee = null;
    }

    public Phone(String brand, int price, List<String> info, Employee employee) {
        this.brand = brand;
        this.price = price;
        this.info = Collections.unmodifiableList(info);
        this.employee = employee;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getInfo() {
        return info;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void finalize() {
        System.out.println(123);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", info=" + info +
                ", employee=" + employee +
                '}';
    }

//    public static class MyPhone extends Phone {
//        @Override
//        public int getPrice() {
//            return new Random().nextInt(100);
//        }
//    }

//    public static void main(String[] args) {
//        Employee e1 = new Employee();
//        CloneTest ct = new CloneTest();
//        Phone p = new Phone();
//        try {
//            e1.clone();
//            ct.clone();
//            p.clone();
//        }catch (Exception ep) {
//            ep.printStackTrace();
//        }
//    }
}
