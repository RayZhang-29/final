package com.mercury.basic.io;

import com.mercury.bean.CreditCard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test3 {
    public static void write() {
        try(FileOutputStream fos = new FileOutputStream("resources/test3.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            CreditCard cc = new CreditCard("1234567890", "Jerry Mouse", "09876");
            oos.writeObject(cc);

            System.out.println("Write finish!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try(FileInputStream fis = new FileInputStream("resources/test3.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            CreditCard cc = (CreditCard) ois.readObject();
            System.out.println(cc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        write();

        CreditCard.bank = "JPMC";

        read();
    }
}
