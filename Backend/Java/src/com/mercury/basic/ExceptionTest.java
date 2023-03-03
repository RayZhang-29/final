package com.mercury.basic;

import javax.management.modelmbean.XMLParseException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {

    // throw
    // throws
    // thrown
    // Throwable

    public static void foo() {
//        try {
//            System.out.println(1 / 0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println(1);
        try {
            // exception : jump out of the current block
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    // MAY throws exception
    public static void bar(int x) throws FileNotFoundException {
        if(x > 10) {
            FileOutputStream fos = new FileOutputStream("c:/abc.txt");
//            throw new FileNotFoundException();
        } else
            System.out.println(123);
    }

    public static void testRuntimeException() {
//        throw new IOException();
        throw new NullPointerException();
    }

    public static void testError() {
        // StackOverflowError
//        StackOverflowError e;
//        try {

        testError();


////            throw new StackOverflowError();
//        }catch (StackOverflowError soe) {
//            soe.printStackTrace();
//        }
    }

    public static void testFinally() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("c:/abc.txt");
            // logic

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // the finally block will guaranteed to be executed
            // no matter what happens in try-catch
            // unless the JVM is shut down

            // normally, use finally to close resource
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testTryWithResource() {

        // resources will be closed immediately after the try block
        // resource : AutoCloseable
        try (MyResource mr = new MyResource();
             FileOutputStream fos = new FileOutputStream("c:/abcasdf.txt");
             ) {

            System.out.println(123);
            throw new Exception();

        } catch (Exception e) {
            System.out.println(456);
            e.printStackTrace();
        }
    }

    public static class MyResource implements AutoCloseable {

        @Override
        public void close() throws Error {
            System.out.println("Closing my resource");
        }
    }

    public static void testMultiException(int x){
        try {
            if (x > 10) {
                throw new IOException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException ioe ) {

        }
    }

    public static void main(String[] args) {
        // how to handle exceptions in Java?
//        foo();
//        Throwable t = new Throwable();
//
//        bar(1);
//        testRuntimeException();
//        System.out.println(1/0);
//
//        throw new ArithmeticException();

        System.out.println("************");

        testTryWithResource();

        test();
    }

    public static void test() throws NullPointerException {
        String s = null;
        System.out.println(s.toString());
    }
}
