package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test2SessionCache {

    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        Sample noah1 = (Sample)session.get(Sample.class, "Noah");
        Sample noah2 = (Sample)session.get(Sample.class, "Noah");

        System.out.println("***********");
        System.out.println(noah1);
        System.out.println(noah2);

        System.out.println(noah1 == noah2);

        transaction.commit();
        HibernateUtil.closeSession();

        System.out.println("******************");

        Session session2 = HibernateUtil.currentSession();
        Transaction transaction2 = session2.beginTransaction();

        Sample noah3 = (Sample)session2.get(Sample.class, "Noah");

        transaction2.commit();
        HibernateUtil.closeSession();
    }

}
