package com.mercury.SpringBootRestDemo.service;

import com.mercury.SpringBootRestDemo.bean.Sample;
import com.mercury.SpringBootRestDemo.dao.SampleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    @Autowired  // by type, then by name    // @Qualifier > @Primary > byName
    private SampleDao sampleDao;

    @Value("${myapp.location}")
    private String myAppLocation;

    public Sample getSampleByName(String name) {

        System.out.println(myAppLocation);

        Optional<Sample> op = sampleDao.findById(name);


//        if(op.isPresent())
//            return op.get();
//        else
//            return null;

        return op.orElse(null);
    }

    public List<Sample> getSamplesByAge(int age) {
        return sampleDao.findByAge(age);
    }
}
