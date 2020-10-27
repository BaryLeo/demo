package com.test.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private int i = 0;

    @GetMapping("/")
    public void test(){
        System.out.println(i++);
    }
}
