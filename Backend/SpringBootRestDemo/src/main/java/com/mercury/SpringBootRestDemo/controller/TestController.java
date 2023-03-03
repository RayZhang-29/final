package com.mercury.SpringBootRestDemo.controller;

import com.mercury.SpringBootRestDemo.bean.Sample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

//@Controller + @ResponseBody

@RestController
public class TestController {

    @RequestMapping("/foo")
    @ResponseBody
    public void foo() {
        System.out.println("foo...");
    }

    @GetMapping("/bar")
    public String bar() {
        System.out.println("bar");
        return "abc";
    }

    @GetMapping("/add")
    public int add(@RequestParam int x, @RequestParam("y") int y) {
        return x + y;
    }

    @GetMapping("/mul/{x}/{y}")
    public int mul(@PathVariable("x") int x, @PathVariable("y") int y) {
        return x * y;
    }

    @PostMapping("/modify")
    public Sample modify(@RequestBody Sample sample) {
        sample.setAge(sample.getAge() * 2);
        return sample;
    }
}
