package com.mercury.test;

import com.mercury.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test7NamedQuery {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.getNamedQuery("userQuery");
        query.setInteger("x", 10);

        query.list().forEach(s -> System.out.println(s));

        transaction.commit();
        HibernateUtil.closeSession();
    }
}
