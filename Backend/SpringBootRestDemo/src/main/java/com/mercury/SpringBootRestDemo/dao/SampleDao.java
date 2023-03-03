package com.mercury.SpringBootRestDemo.dao;

import com.mercury.SpringBootRestDemo.bean.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SampleDao extends JpaRepository<Sample, String> {

    List<Sample> findByAge(int age);

}
