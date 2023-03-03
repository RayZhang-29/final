package com.mercury.basic;

import com.mercury.bean.Student;
import com.mercury.bean.StudentBuilder;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);

        String s5 = new String("xyz");
        String s6 = new String("xyz");

        // ? a string only on heap but not in pool

        String s7 = s6.intern();

        String s8 = s1 + s2 + s3;

        StringBuilder sb = new StringBuilder();
        String str = sb.append("a").append("b").append("c").toString();
        System.out.println(str);

        StudentBuilder stb = new StudentBuilder();
        Student student = stb.withId(1)
                            .withFirstName("Alice")
                            .withLastName("H")
                            .getStudent();

        StringBuffer sbf;
    }

    public static void bar(int sec) {
        // 1970.1.1 00:00
        long start = System.currentTimeMillis();
        long end = -1;
        while(end - start < sec * 1000) {
            end = System.currentTimeMillis();
        }
    }
}
