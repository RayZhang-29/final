package com.mercury.test;

import com.mercury.bean.Sample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test3SessionFactoryLevelCache {
    public static void main(String[] args) {
        SessionFactory sf1 = new Configuration().configure().buildSessionFactory();
        SessionFactory sf2 = new Configuration().configure().buildSessionFactory();

        Session s1 = sf1.openSession();
        Transaction t1 = s1.beginTransaction();

        Sample n1 = (Sample)s1.get(Sample.class, "Noah1");

        t1.commit();
        s1.close();

        System.out.println("******************");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Session s2 = sf1.openSession();
        Transaction t2 = s2.beginTransaction();

        Sample n2 = (Sample)s2.get(Sample.class, "Noah1");

        t2.commit();
        s2.close();

        System.out.println("******************");

        Session s3 = sf2.openSession();
        Transaction t3 = s3.beginTransaction();

        Sample n3 = (Sample)s3.get(Sample.class, "Noah1");

        t3.commit();
        s3.close();

        System.out.println("******************");
        // how many SQL? - 2
        System.out.println(n1 == n2);   // true, false
        System.out.println(n2 == n3);   // false
    }
}
