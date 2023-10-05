package com.example.springbootfull.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hi(){
        return "Hello World";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome user";
    }
    @GetMapping("/Admin")
    public String admin(){
        return "Welcome Admin";
    }
}
