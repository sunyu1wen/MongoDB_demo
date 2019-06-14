package com.bocai.springBoot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {
    @RequestMapping("/hello")
    public String HelloWorld(){
        return  "Hello world";
    }
}
