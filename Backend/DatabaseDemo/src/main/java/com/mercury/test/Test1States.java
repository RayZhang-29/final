package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test1States {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
//        Transaction transaction = session.beginTransaction();
//
//        // state : transient : never in the session
        Sample noah = new Sample("Billy", 12);
        session.save(noah);

        noah.setAge(30);
//
//        // state : persistence - attached : currently in the session
//        Sample bob = (Sample) session.get(Sample.class, "Bob");
//        bob.setAge(100);
//
//        System.out.println(bob);
//        System.out.println("************");
//
//        transaction.commit();
        HibernateUtil.closeSession();

        // state : detached : use to in the session, not any more
//        System.out.println(bob);
    }
}
