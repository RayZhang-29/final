package com.mercury.dao;

import com.mercury.bean.Sample;
import com.mercury.util.HibernateUtil;
import com.mercury.util.JdbcOracleUtil;
import com.mercury.util.JdbcPostgresUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SampleDao {

    public List<Sample> getAll() {
        List<Sample> sampleList = new ArrayList<>();

        String sql = "SELECT * FROM SAMPLE";

        try (Connection connection = JdbcOracleUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql);) {

            while(rs.next()) {
                String name = rs.getString("NAME");
                int age = rs.getInt("AGE");

                sampleList.add(new Sample(name, age));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sampleList;
    }

    public Optional<Sample> get(String name) {
        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();

        // java bean - most basic operation unit of Java Application

        // hibernate entity - most basic operation unit of Hibernate
        // java bean with the corresponding ORM

        Sample sample = (Sample)session.get(Sample.class, name);

        transaction.commit();
        HibernateUtil.closeSession();

        return Optional.ofNullable(sample);
    }

    public List<Sample> getByAge(int age) {
        return null;
    }

    public void save(Sample sample) {

    }
}
