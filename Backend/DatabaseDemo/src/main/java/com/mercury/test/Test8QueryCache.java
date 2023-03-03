package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Test8QueryCache {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.getNamedQuery("userQuery");
        query.setInteger("x", 10);  // select * from sample where age > 10
        query.setCacheable(true);

        List<Sample> sampleList1 = query.list();
        sampleList1.forEach(s -> System.out.println(s));

        System.out.println("*******************");

        List<Sample> sampleList2 = query.list();
        sampleList2.forEach(s -> System.out.println(s));


        transaction.commit();
        HibernateUtil.closeSession();
    }
}
