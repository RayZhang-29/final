package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Test4Hql {

    public static void main(String[] args) {
        // Hibernate Query Language

        // HQL operates Hibernate entity

        String hql = "fROM Sample"; // SELECT * FROM SAMplE


        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(hql);

//        query.uniqueResult();   // only use it if only 1 row return, exception if more rows
        List<Sample> sampleList = query.list();

        sampleList.forEach(e -> System.out.println(e));

        transaction.commit();
        HibernateUtil.closeSession();

    }

}
