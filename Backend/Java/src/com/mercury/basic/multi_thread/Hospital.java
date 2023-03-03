package com.mercury.basic.multi_thread;

public class Hospital {

    public static class Patient extends Thread {
        private int id;
        private Doctor doctor;

        public Patient(int id, Doctor d) {
            this.id = id;
            this.doctor = d;
        }

        @Override
        public void run() {
            doctor.treat(this);
        }
    }

    class Room{

    }

    public static class Doctor {

        public void treat(Patient p) {
            System.out.println(p.id + " need a treatment");
            synchronized (this) {
                if (p.id > 5) {
                    try {
                        System.out.println(p.id + " is waiting...");
                        this.wait();
                        System.out.println(p.id + " is back, start treatment");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(p.id + " is getting treatment directly.");
                }
                sleep(p.id);
                System.out.println(p.id + " well done!");
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Doctor d = new Doctor();


        Patient p8 = new Patient(8, d);
        Patient p9 = new Patient(9, d);
        sleep(1);
        Patient p1 = new Patient(1, d);
        Patient p2 = new Patient(2, d);
        Patient p3 = new Patient(3, d);

        p1.start();
        p2.start();
        p3.start();
        p8.start();
        p9.start();


        System.out.println("*****************");
    }


    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
