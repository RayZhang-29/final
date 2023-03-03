package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test5GetLoad {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        // get() is eager, load() is lazy
        // both get() and load() are using cache
        // if record does not exist in database,
        // get() returns null, load() exception out

        Sample noah = (Sample)session.get(Sample.class, "Noah1");
        Sample bob = (Sample)session.load(Sample.class, "Bob1"); // proxy object

        System.out.println("********************");

//        System.out.println(noah.getClass());
        System.out.println(bob.getClass());

        System.out.println("********************");

        System.out.println(noah);
        System.out.println(bob);

        transaction.commit();
        HibernateUtil.closeSession();
    }

}
