package com.mercury.SpringBootRestDemo.controller;

import com.mercury.SpringBootRestDemo.bean.Sample;
import com.mercury.SpringBootRestDemo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/samples")
public class SampleController {
    // RESTful style

    @Autowired
    private SampleService sampleService;

    @PostMapping    // http://localhost:8080/samples  -  POST
    public void save(@RequestBody Sample sample) {

    }

    @GetMapping("/{name}")  // http://localhost:8080/samples/Bob
    public Sample get(@PathVariable String name) {
        return sampleService.getSampleByName(name);
    }

    @GetMapping("/age/{age}")   // http://localhost:8080/samples/age/10
    public List<Sample> getByAge(@PathVariable int age){
        return sampleService.getSamplesByAge(age);
    }

    @GetMapping     // http://localhost:8080/samples  -  GET
    public List<Sample> getAll() {
        return null;
    }
}
