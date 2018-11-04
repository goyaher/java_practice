package com.hgoyal.springbootexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hgoyal.springbootexample.dto.Greeting;

@RestController
public class HomeController {
 
    @RequestMapping("/greet")
    public Greeting greet(@RequestParam String user) 
    {
        return new Greeting(1, "Hello " + user + "!");
    }
}
