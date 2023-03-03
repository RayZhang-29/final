package com.mercury.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test1 {

    public static void write() {
        try (FileOutputStream fos = new FileOutputStream("resources/test1.dat");) {

            int[] nums = {-1, 2, 3, 4, 23427934};

            for(int num : nums) {
                fos.write(num);
            }

            System.out.println("Write finish!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try (FileInputStream fis = new FileInputStream("resources/test1.dat")) {

            int next = fis.read();

            while(next != -1) {
                System.out.println(next);
                next = fis.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        write();
//        read();
        int x = 23427934; // 94

        System.out.println(x % 256);
        System.out.println("*******************");
//        String binCode = Integer.toBinaryString(x);
        String binCode = Integer.toString(x, 2);
        String lastByte = binCode.substring(binCode.length() - 8);
        System.out.println(Integer.parseInt(lastByte, 2));
        System.out.println("*******************");

        System.out.println(x << 24 >>> 24);

        System.out.println("*******************");

        System.out.println(x - (x >> 8 << 8));

        System.out.println("*******************");

        System.out.println(x & 255);

        String str = "11111111";
        System.out.println(Integer.parseInt(str, 2));
    }
}
