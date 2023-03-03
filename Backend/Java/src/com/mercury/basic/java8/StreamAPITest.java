package com.mercury.basic.java8;

import com.mercury.bean.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest {

    public static void main(String[] args) {
        // concurrent package : java.util.concurrent
        // function package : java.util.function - functional interfaces

        List<String> info = new ArrayList<>();

        info.add("Today is");
        info.add("Tuesday, Jan 31, 2023");
        info.add("a good day");
        info.add("maybe in the afternoon");

        // 1. find all element length > 10
        // 2. convert them to capital
        // 3. print them
        // 4. save them into a result list

//        List<String> resultList = new ArrayList<>();
//
//        for(String s : info) {
//            if(s.length() > 10) {
//                String str = s.toUpperCase();
//                System.out.println(str);
//                resultList.add(s);
//            }
//        }

        // 1. convert the input to a stream
        // 2. use intermediate operation to define the logic
        // 3. use terminal operation to define logic and start the stream

        // 1. find all element length > 10
        // 2. convert them to capital
        // 3. print them
        // 4. save them into a result list

        List<String> resList = info.stream()
                .filter(s -> s.length() > 10)
                .map(s -> s.toUpperCase())
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList())
                ;

        Stream<String> stringStream = info.stream()
                .filter(s -> s.length() > 10)
                .map(s -> s.toUpperCase())
                .peek(s -> System.out.println(s))
                ;

        System.out.println("**************");

        System.out.println(resList);

        System.out.println("**************");

        System.out.println(info);

        Optional<Employee> op = getEmployeeById(1);

        Supplier<Employee> employeeSupplier = () -> {
            return new Employee(2);
        };

        Employee e = op.orElseGet(employeeSupplier);

        System.out.println(e);

        // lazy vs eager
    }

    public static Optional<Employee> getEmployeeById(int id) {
        // logic
        Employee e = new Employee(id);  // assume e is from DB

        return Optional.ofNullable(e);
    }
}














