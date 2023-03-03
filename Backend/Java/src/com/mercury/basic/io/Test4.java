package com.mercury.basic.io;

import com.mercury.bean.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test4 {
    public static void write() {
        try(FileOutputStream fos = new FileOutputStream("resources/test4.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Student s = new Student(10, "Tom", "Cat");
            System.out.println(s);
            oos.writeObject(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try (FileInputStream fis = new FileInputStream("resources/test4.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Student s = (Student)ois.readObject();
            System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        System.out.println("***********");
        read();
        System.out.println(123);
    }
}
