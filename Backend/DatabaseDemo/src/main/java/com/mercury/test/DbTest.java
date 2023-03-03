package com.mercury.test;

import com.mercury.bean.Sample;
import com.mercury.dao.SampleDao;

import java.util.List;
import java.util.Optional;

public class DbTest {
    public static void main(String[] args) {
        SampleDao sampleDao = new SampleDao();

        List<Sample> sampleList = sampleDao.getAll();

        sampleList.forEach(s -> System.out.println(s));

        System.out.println("***************");
        Optional<Sample> op = sampleDao.get("Bob");
        if(op.isPresent()) {
            System.out.println(op.get());
        }
    }
}
