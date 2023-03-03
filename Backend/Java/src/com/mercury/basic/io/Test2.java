package com.mercury.basic.io;

import java.io.*;

public class Test2 {
    public static void write() {
        try (FileOutputStream fos = new FileOutputStream("resources/test2.dat");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)){

            int i = -5;
            double d = 3.1415926;
            boolean b = true;

            dos.writeInt(i);
            dos.writeDouble(d);
            dos.writeBoolean(b);

            System.out.println("Write finish!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try (FileInputStream fis = new FileInputStream("resources/test2.dat");
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {

            boolean b = dis.readBoolean();
            double d = dis.readDouble();
            int i = dis.readInt();


            System.out.println(i);
            System.out.println(d);
            System.out.println(b);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        read();
    }
}
