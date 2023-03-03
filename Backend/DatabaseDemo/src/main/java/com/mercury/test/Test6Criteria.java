package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Test6Criteria {

    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Sample.class);

        // where age < 50 and age > 10
//        criteria.add(Restrictions.lt("age", 50))
//                .add(Restrictions.gt("age", 10));

        // where age < 30 or age > 50
        criteria.add(Restrictions.or(Restrictions.lt("age", 30)
        , Restrictions.gt("age", 50)));

//        criteria.uniqueResult();
        List<Sample> sampleList = criteria.list();
        System.out.println(sampleList);

        transaction.commit();
        HibernateUtil.closeSession();
    }
}
